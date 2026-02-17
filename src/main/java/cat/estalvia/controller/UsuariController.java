package cat.estalvia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.service.UsuariService;

/**
 * Clase per gestionar les peticions dels usuaris
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuariController {

	private final UsuariService usuariService;

	public UsuariController(UsuariService usuariService) {
		this.usuariService = usuariService;
	}

	/**
	 * Per eliminar un compte d'usuari
	 * @param id (id del usuari)
	 * @param modo (mode per eliminar tot o dexar les llistes publiques (en autor anonim)
	 * @return
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestParam String modo) {
		try {
			usuariService.eliminarCuenta(id, modo);
			return ResponseEntity.ok().body("{\"message\": \"Cuenta eliminada\"}");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error: " + e.getMessage());
		}
	}

	/**
	 * Per coneixer el nombre total d'usuaris
	 * @return 
	 */

	@GetMapping("/usuaris/count")
	public ResponseEntity<Long> getTotalUsuarios() {
		return ResponseEntity.ok(usuariService.contarTodos());
	}
}
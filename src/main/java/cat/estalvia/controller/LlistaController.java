package cat.estalvia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.LlistaDTO;
import cat.estalvia.entity.Llista;
import cat.estalvia.request.CrearLlistaRequest;
import cat.estalvia.service.LlistaService;

/**
 * Clase per controller per gestio de les llistes
 */


@RestController
@RequestMapping("/api/listas")
public class LlistaController {

	private final LlistaService llistaService;

	public LlistaController(LlistaService llistaService) {
		this.llistaService = llistaService;
	}

	/**
	 * Per crear una llista nova
	 * @param req
	 * @return
	 */

	@PostMapping
	public ResponseEntity<Long> crearLlista(@RequestBody CrearLlistaRequest req) {

		Llista llista = llistaService.crearLlista(req);
		return ResponseEntity.ok(llista.getListaId());
	}


	/**
	 * Per obtenir les llistes d'un usari
	 * @param usuariId
	 * @return 
	 */

	@GetMapping
	public ResponseEntity<List<LlistaDTO>> getLlistesUsuari(@RequestParam Long usuariId) {
		List<Llista> llistes = llistaService.obtenirLlistesUsuari(usuariId);
		// Convertim cada llista a DTO per evitar el bucle infinit
		List<LlistaDTO> dtos = llistes.stream()
				.map(llistaService::toDTO)
				.toList();
		return ResponseEntity.ok(dtos);
	}

	/**
	 * Per obtenir totes les llistes publiques de la bae d edades
	 * @return
	 */

	@GetMapping("/publiques")
	public ResponseEntity<List<LlistaDTO>> getPubliques() {
		return ResponseEntity.ok(llistaService.obtenirPubliques());
	}

	/**
	 * Per obtenir el nombre de llistes privades totals de la base de dades
	 * @return
	 */

	@GetMapping("/privades/stats")
	public ResponseEntity<Integer> getPrivadesStats() {
		// Eliminem el paréntesis extra: .TotalPrivades()
		return ResponseEntity.ok(llistaService.TotalPrivades());
	}

	/**
	 * Retorna el nombre de llistes publiques i provades de un usuari
	 * @param userId
	 * @return
	 */

	@GetMapping("/stats/{userId}")
	public ResponseEntity<Map<String, Long>> getStats(@PathVariable Long userId) {
		return ResponseEntity.ok(llistaService.estadistiquesUsuari(userId));
	}

	/**
	 * Per eliminar una llista
	 * @param id (de llista)
	 * @param usuariId
	 * @return
	 */

	@DeleteMapping("/{id}/{usuariId}")
	public ResponseEntity<Void> eliminarLlista(@PathVariable Long id, @PathVariable Long usuariId) {
		llistaService.eliminarLlistaSegura(id, usuariId);
		return ResponseEntity.noContent().build();
	}
}

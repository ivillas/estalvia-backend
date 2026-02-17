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

@RestController
@RequestMapping("/api/listas")
public class LlistaController {

    private final LlistaService llistaService;

    public LlistaController(LlistaService llistaService) {
        this.llistaService = llistaService;
    }

    @PostMapping
    public ResponseEntity<Long> crearLlista(@RequestBody CrearLlistaRequest req) {

        Llista llista = llistaService.crearLlista(req);
        return ResponseEntity.ok(llista.getListaId());
    }

    @GetMapping
    public ResponseEntity<List<LlistaDTO>> getLlistesUsuari(@RequestParam Long usuariId) {
        List<Llista> llistes = llistaService.obtenirLlistesUsuari(usuariId);
        // Convertimos cada lista a DTO para evitar el bucle infinito
        List<LlistaDTO> dtos = llistes.stream()
                                      .map(llistaService::toDTO)
                                      .toList();
        return ResponseEntity.ok(dtos);
    }
    
    @GetMapping("/publiques")
    public ResponseEntity<List<LlistaDTO>> getPubliques() {
        return ResponseEntity.ok(llistaService.obtenirPubliques());
    }
    
    @GetMapping("/privades/stats")
    public ResponseEntity<Integer> getPrivadesStats() {
        // Eliminamos el paréntesis extra: .TotalPrivades()
        return ResponseEntity.ok(llistaService.TotalPrivades());
    }

    
    
    @GetMapping("/stats/{userId}")
    public ResponseEntity<Map<String, Long>> getStats(@PathVariable Long userId) {
        return ResponseEntity.ok(llistaService.estadistiquesUsuari(userId));
    }
    
    @DeleteMapping("/{id}/{usuariId}")
    public ResponseEntity<Void> eliminarLlista(@PathVariable Long id, @PathVariable Long usuariId) {
        llistaService.eliminarLlistaSegura(id, usuariId);
        return ResponseEntity.noContent().build();
    }
}

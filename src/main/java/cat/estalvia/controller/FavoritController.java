package cat.estalvia.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.estalvia.entity.Favorit;
import cat.estalvia.repository.FavoritRepository;

import java.util.List;

/**
 * Clase per controller per gestio del productes favorits
 */

@RestController
@RequestMapping("/api/favoritos")
public class FavoritController {

	private final FavoritRepository favoritRepository;

	public FavoritController(FavoritRepository favoritRepository) {
		this.favoritRepository = favoritRepository;
	}

	/*
	 * Llista de id's dels productes favorits d'un usuari
	 */

	@GetMapping("/ids/{userId}")
	public ResponseEntity<List<Long>> getIdsFavoritos(@PathVariable Long userId) {
		return ResponseEntity.ok(favoritRepository.findProductIdsByUserId(userId));
	}

	/*
	 * Per afegir un producte favorit a un usuari
	 */

	@PostMapping("/{userId}/{prodId}")
	public ResponseEntity<Void> addFavorito(@PathVariable Long userId, @PathVariable Long prodId) {
		Favorit favorit = new Favorit();
		favorit.setId(new Favorit.FavoritId(userId, prodId));
		favoritRepository.save(favorit);
		return ResponseEntity.ok().build();
	}

	/*
	 * Per eliminar un producte favorit a un usuari
	 */

	@DeleteMapping("/{userId}/{prodId}")
	public ResponseEntity<Void> removeFavorito(@PathVariable Long userId, @PathVariable Long prodId) {
		favoritRepository.deleteFavorito(userId, prodId);
		return ResponseEntity.ok().build();
	}

	/*
	 * Per saber el nombre total de productes favorits d'un usari
	 */

	@GetMapping("/count/{userId}")
	public ResponseEntity<Long> getCountFavoritos(@PathVariable Long userId) {
		return ResponseEntity.ok(favoritRepository.countByUserId(userId));
	}
}

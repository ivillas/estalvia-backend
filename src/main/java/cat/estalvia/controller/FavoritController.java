package cat.estalvia.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.estalvia.entity.Favorit;
import cat.estalvia.repository.FavoritRepository;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritController {

    private final FavoritRepository favoritRepository;

    public FavoritController(FavoritRepository favoritRepository) {
        this.favoritRepository = favoritRepository;
    }

    @GetMapping("/ids/{userId}")
    public ResponseEntity<List<Long>> getIdsFavoritos(@PathVariable Long userId) {
        return ResponseEntity.ok(favoritRepository.findProductIdsByUserId(userId));
    }

    @PostMapping("/{userId}/{prodId}")
    public ResponseEntity<Void> addFavorito(@PathVariable Long userId, @PathVariable Long prodId) {
        Favorit favorit = new Favorit();
        favorit.setId(new Favorit.FavoritId(userId, prodId));
        favoritRepository.save(favorit);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/{prodId}")
    public ResponseEntity<Void> removeFavorito(@PathVariable Long userId, @PathVariable Long prodId) {
        favoritRepository.deleteFavorito(userId, prodId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/count/{userId}")
    public ResponseEntity<Long> getCountFavoritos(@PathVariable Long userId) {
        // Llamamos al método countByUserId que definimos en el FavoritRepository
        return ResponseEntity.ok(favoritRepository.countByUserId(userId));
    }
}

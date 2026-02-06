package cat.estalvia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cat.estalvia.entity.Favorit;

import java.util.List;

public interface FavoritRepository extends JpaRepository<Favorit, Favorit.FavoritId> {

    @Query(value = "SELECT COUNT(*) FROM productes_favorits WHERE user_id = :userId", nativeQuery = true)
    long countByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT producte_id FROM productes_favorits WHERE user_id = :userId", nativeQuery = true)
    List<Long> findProductIdsByUserId(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productes_favorits WHERE user_id = :userId AND producte_id = :prodId", nativeQuery = true)
    void deleteFavorito(@Param("userId") Long userId, @Param("prodId") Long prodId);
}

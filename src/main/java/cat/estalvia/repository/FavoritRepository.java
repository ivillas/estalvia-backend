package cat.estalvia.repository;

/**
 * Clase Repository per les consultes dels favorits
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cat.estalvia.entity.Favorit;

import java.util.List;

public interface FavoritRepository extends JpaRepository<Favorit, Favorit.FavoritId> {

	/*
	 * Consulta per saver el nombre total de productes favorits d'un usari
	 */

	@Query(value = "SELECT COUNT(*) FROM productes_favorits WHERE user_id = :userId", nativeQuery = true)
	long countByUserId(@Param("userId") Long userId);


	/*
	 * Consulta per saver els id's dels productes favorits d'un usuari
	 */

	@Query(value = "SELECT producte_id FROM productes_favorits WHERE user_id = :userId", nativeQuery = true)
	List<Long> findProductIdsByUserId(@Param("userId") Long userId);

	/*
	 * Consulta per eliminar un producte favorit d'un usari
	 */

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM productes_favorits WHERE user_id = :userId AND producte_id = :prodId", nativeQuery = true)
	void deleteFavorito(@Param("userId") Long userId, @Param("prodId") Long prodId);
}

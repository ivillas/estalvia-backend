package cat.estalvia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cat.estalvia.entity.Llista;
import cat.estalvia.entity.Visibilitat;
import jakarta.transaction.Transactional;


/**
 * Clase Repository per les consultes de les llistes
 */

@Repository
public interface LlistaRepository extends JpaRepository<Llista, Long> {

	// Consulta per les llistes d'un usuari
	@Query(value = "SELECT * FROM llistes WHERE usuari_id = :userId", nativeQuery = true)
	List<Llista> findByUsuari_UserId(@Param("userId") Long userId);

	// Consulta per les llistes publiques (visibles)
	@Query(value = "SELECT * FROM llistes WHERE visibilitat = :vis", nativeQuery = true)
	List<Llista> findByVisibilitat(@Param("vis") String vis);

	//Consulta per saber el nombre de llistes publiques d'un usuari
	@Query(value = "SELECT COUNT(*) FROM llistes WHERE usuari_id = :userId AND visibilitat = :vis", nativeQuery = true)
	long countByUsuari_UserIdAndVisibilitat(@Param("userId") Long userId, @Param("vis") String vis);

	// Consulta per borrar totes les llistes d'un usari 
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM llistes WHERE usuari_id = :userId", nativeQuery = true)
	void deleteByUsuariId(@Param("userId") Long userId);

	//Consulta per borrar les llistes d'un usuari amb seleccio (publiques o privades) normalment per les privades 
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM llistes WHERE usuari_id = :userId AND visibilitat = :vis", nativeQuery = true)
	void deleteByUsuariIdAndVisibilitat(@Param("userId") Long userId, @Param("vis") String vis);

	//Consulta per passar una llista publica d'un usari amb el usuari anonim( per deixar la llista sempre publica
	@Modifying
	@Transactional
	@Query(value = "UPDATE llistes SET usuari_id = :nuevoId WHERE usuari_id = :viejoId AND visibilitat = 'PUBLICA'", nativeQuery = true)
	void reassignPublicLists(@Param("viejoId") Long viejoId, @Param("nuevoId") Long nuevoId);

	//Consulta per eliminar totes les llistes d'un usari
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM llistes WHERE llista_id = :llistaId AND usuari_id = :userId", nativeQuery = true)
	void deleteByIdAndUsuariId(@Param("llistaId") Long llistaId, @Param("userId") Long userId);
}
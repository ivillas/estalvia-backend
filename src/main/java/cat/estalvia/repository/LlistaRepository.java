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

@Repository
public interface LlistaRepository extends JpaRepository<Llista, Long> {

    // Consultas para el LlistaService
    @Query(value = "SELECT * FROM llistes WHERE usuari_id = :userId", nativeQuery = true)
    List<Llista> findByUsuari_UserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM llistes WHERE visibilitat = :vis", nativeQuery = true)
    List<Llista> findByVisibilitat(@Param("vis") String vis);

    @Query(value = "SELECT COUNT(*) FROM llistes WHERE usuari_id = :userId AND visibilitat = :vis", nativeQuery = true)
    long countByUsuari_UserIdAndVisibilitat(@Param("userId") Long userId, @Param("vis") String vis);

    // Consultas para borrar cuenta (SQL Puro)
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM llistes WHERE usuari_id = :userId", nativeQuery = true)
    void deleteByUsuariId(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM llistes WHERE usuari_id = :userId AND visibilitat = :vis", nativeQuery = true)
    void deleteByUsuariIdAndVisibilitat(@Param("userId") Long userId, @Param("vis") String vis);

    @Modifying
    @Transactional
    @Query(value = "UPDATE llistes SET usuari_id = :nuevoId WHERE usuari_id = :viejoId AND visibilitat = 'PUBLICA'", nativeQuery = true)
    void reassignPublicLists(@Param("viejoId") Long viejoId, @Param("nuevoId") Long nuevoId);
 
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM llistes WHERE llista_id = :llistaId AND usuari_id = :userId", nativeQuery = true)
    void deleteByIdAndUsuariId(@Param("llistaId") Long llistaId, @Param("userId") Long userId);
}
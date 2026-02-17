package cat.estalvia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cat.estalvia.entity.Usuari;


/**
 * Clase Repository Usuaris
 */

@Repository
public interface UsuariRepository extends JpaRepository<Usuari, Long> {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	Optional<Usuari> findByUsername(String username);

	//Consulta per saver el nombre total d'usuaris
	@Query(value = "SELECT COUNT(*) FROM usuaris", nativeQuery = true)
	long countUsuarios();


}

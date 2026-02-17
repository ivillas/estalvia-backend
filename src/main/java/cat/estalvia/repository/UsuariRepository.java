package cat.estalvia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cat.estalvia.entity.Usuari;

@Repository
public interface UsuariRepository extends JpaRepository<Usuari, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Usuari> findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM usuaris", nativeQuery = true)
    long countUsuarios();
    
    
}

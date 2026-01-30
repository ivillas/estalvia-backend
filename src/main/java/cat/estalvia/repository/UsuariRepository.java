package cat.estalvia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.estalvia.entity.Usuari;

@Repository
public interface UsuariRepository extends JpaRepository<Usuari, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Usuari> findByUsername(String username);

}

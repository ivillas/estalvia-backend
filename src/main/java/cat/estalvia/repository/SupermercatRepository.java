package cat.estalvia.repository;

import cat.estalvia.entity.Supermercat;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Clase Repository Supermercats
 */

public interface SupermercatRepository extends JpaRepository<Supermercat, Long> {
}

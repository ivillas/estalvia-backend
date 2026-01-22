package cat.estalvia.repository;



import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.estalvia.entity.Producte;

public interface ProducteRepository extends JpaRepository<Producte, Long> {
	
    @Query("""
            SELECT p.producteId, p.marca, p.nomProducte,
                   p.unitat, p.quantitatUnitat,
                   s.nom, pr.preu
            FROM Producte p
            JOIN Preu pr ON pr.producte = p
            JOIN Supermercat s ON pr.supermercat = s
        """)
        List<Object[]> findAllWithPrices();
        
        @Query("""
                SELECT MAX(p.lastUpdate)
                FROM Producte p
            """)
            LocalDateTime findLastUpdate();
}

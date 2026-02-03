package cat.estalvia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.estalvia.entity.ItemLlista;
import cat.estalvia.entity.Llista;

@Repository
public interface ItemLlistaRepository extends JpaRepository<ItemLlista, Long> {
    
    // Spring navegará: ItemLlista -> Llista -> Usuari -> userId
    List<ItemLlista> findByLlista_Usuari_UserId(Long userId);
}

package cat.estalvia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.estalvia.entity.Llista;

public interface LlistaRepository extends JpaRepository<Llista, Long> {

    // Para ver las de un usuario concreto (Privadas y Públicas suyas)
    List<Llista> findByUsuari_UserId(Long userId);

    // Para ver TODAS las públicas de la plataforma
    List<Llista> findByVisibilitat(String visibilitat);

    // Para contar (Panel de usuario)
    long countByUsuari_UserIdAndVisibilitat(Long userId, String visibilitat);
}

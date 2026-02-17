package cat.estalvia.service;

import org.springframework.stereotype.Service;

import cat.estalvia.entity.Visibilitat;
import cat.estalvia.repository.LlistaRepository;
import cat.estalvia.repository.UsuariRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuariService {

    private final UsuariRepository usuariRepo;
    private final LlistaRepository llistaRepo;
    private static final Long USER_SISTEMA_ID = 1L;

    public UsuariService(UsuariRepository usuariRepo, LlistaRepository llistaRepo) {
        this.usuariRepo = usuariRepo;
        this.llistaRepo = llistaRepo;
    }

    // Método para el conteo que usará el Controller
    public long contarTodos() {
        // Llamamos al método de la @Query nativa que creaste
        return usuariRepo.countUsuarios();
    }

    @Transactional
    public void eliminarCuenta(Long userId, String modo) {
        // 1. Verificación de seguridad
        if (!usuariRepo.existsById(userId)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // 2. Lógica de listas según el modo
        if ("todo".equalsIgnoreCase(modo)) {
            llistaRepo.deleteByUsuariId(userId);
        } else if ("solo_privadas".equalsIgnoreCase(modo)) {
            llistaRepo.deleteByUsuariIdAndVisibilitat(userId, Visibilitat.PRIVADA.name());
            // Usamos la constante definida arriba
            llistaRepo.reassignPublicLists(userId, USER_SISTEMA_ID);
        }

        // 3. Borrado final del usuario
        usuariRepo.deleteById(userId);
    }
}

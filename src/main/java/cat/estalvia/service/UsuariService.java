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

    @Transactional
    public void eliminarCuenta(Long userId, String modo) {
        if ("todo".equalsIgnoreCase(modo)) {
            llistaRepo.deleteByUsuariId(userId);
        } else if ("solo_privadas".equalsIgnoreCase(modo)) {
            llistaRepo.deleteByUsuariIdAndVisibilitat(userId, Visibilitat.PRIVADA.name());
            llistaRepo.reassignPublicLists(userId, 1L);
        }
        usuariRepo.deleteById(userId);
    }
}

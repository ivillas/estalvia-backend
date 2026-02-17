package cat.estalvia.service;

import org.springframework.stereotype.Service;

import cat.estalvia.entity.Visibilitat;
import cat.estalvia.repository.LlistaRepository;
import cat.estalvia.repository.UsuariRepository;
import jakarta.transaction.Transactional;

/**
 * Clase Service per la contrasenya
 */

@Service
public class UsuariService {

	private final UsuariRepository usuariRepo;
	private final LlistaRepository llistaRepo;
	private static final Long USER_SISTEMA_ID = 1L;

	public UsuariService(UsuariRepository usuariRepo, LlistaRepository llistaRepo) {
		this.usuariRepo = usuariRepo;
		this.llistaRepo = llistaRepo;
	}

	/**
	 * Metode per coneixer el nombre d'usuaris
	 * @return numero total d'usuaris registrats
	 */
	public long contarTodos() {
		return usuariRepo.countUsuarios();
	}


	/**
	 * Metode per eliminar un compte
	 * @param userId
	 * @param modo (tot o deixar les llistes publiques publicades)
	 */
	@Transactional
	public void eliminarCuenta(Long userId, String modo) {
		// Verifiquem l'usuari
		if (!usuariRepo.existsById(userId)) {
			throw new RuntimeException("Usuario no trobat");
		}

		// llogica segons el mode d'eliminacio
		if ("todo".equalsIgnoreCase(modo)) {
			llistaRepo.deleteByUsuariId(userId);
		} else if ("solo_privadas".equalsIgnoreCase(modo)) {
			llistaRepo.deleteByUsuariIdAndVisibilitat(userId, Visibilitat.PRIVADA.name());
			// per cambiar les llistes publiques
			llistaRepo.reassignPublicLists(userId, USER_SISTEMA_ID);
		}

		// borrem l'usuari al final
		usuariRepo.deleteById(userId);
	}
}

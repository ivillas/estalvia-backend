package cat.estalvia.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import cat.estalvia.dto.RegisterRequest;
import cat.estalvia.entity.Rol;
import cat.estalvia.entity.Usuari;
import cat.estalvia.repository.UsuariRepository;

/**
 * Clase Service per l'autentificació
 */

@Service
public class AuthService {

	private final UsuariRepository usuariRepo;
	private final PasswordService passwordService;

	public AuthService(UsuariRepository usuariRepo,
			PasswordService passwordService) {
		this.usuariRepo = usuariRepo;
		this.passwordService = passwordService;
	}


	/**
	 * Metode per autentificarse
	 * @param username
	 * @param password
	 * @return
	 */

	public boolean authenticate(String username, String password) {
		Optional<Usuari> oUsuari = usuariRepo.findByUsername(username);

		if (oUsuari.isPresent()) {
			Usuari u = oUsuari.get();
			return passwordService.verify(password, u.getPasswordHash());
		}

		return false;
	}

	/**
	 * Metode per registrarse
	 * @param req
	 */

	public void register(RegisterRequest req) {

		if (req.getEmail() == null || req.getUsername() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltan campos");
		}

		if (usuariRepo.existsByUsername(req.getUsername())) {
			throw new RuntimeException("Username ya existe");
		}

		if (usuariRepo.existsByEmail(req.getEmail())) {
			throw new RuntimeException("Email ya existe");
		}

		Usuari u = new Usuari();
		u.setUsername(req.getUsername());
		u.setEmail(req.getEmail());
		u.setPasswordHash(passwordService.hash(req.getPassword()));
		u.setRol(Rol.USER);
		u.setActivo(true);
		u.setDataCreacio(LocalDateTime.now());

		usuariRepo.save(u);
	}
}
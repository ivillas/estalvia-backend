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
	private final EmailService emailService; 
	
    public AuthService(UsuariRepository usuariRepo, 
            PasswordService passwordService, 
            EmailService emailService) {
this.usuariRepo = usuariRepo;
this.passwordService = passwordService;
this.emailService = emailService;
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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falten camps obligatoris");
		}

		if (usuariRepo.existsByUsername(req.getUsername())) {
			throw new RuntimeException("Usuari ja existeix");
		}

		if (usuariRepo.existsByEmail(req.getEmail())) {
			throw new RuntimeException("Email ja existeix");
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
	
	 /**
     * CANVI DE CONTRASENYA (Usuari ja loguejat)
     * Verifiquem la contrasenya antiga per seguretat.
     */
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        Usuari u = usuariRepo.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuari no trobat"));

        if (!passwordService.verify(oldPassword, u.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "La contrasenya actual no és correcta");
        }

        u.setPasswordHash(passwordService.hash(newPassword));
        usuariRepo.save(u);
    }

    /**
     * RECUPERACIÓ - PAS 1 (Generar codi temporal)
     */
    public void generateRecoveryCode(String email) {
        Usuari u = usuariRepo.findByEmail(email)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email no registrat"));

        // Generem un codi de 6 dígits aleatoris
        String code = String.format("%06d", new java.util.Random().nextInt(999999));
        u.setRecoveryCode(code);
        u.setRecoveryExpiration(LocalDateTime.now().plusMinutes(15)); // Caduca en 15 min
        
        usuariRepo.save(u);
        
        emailService.enviarCodiRecuperacio(u.getEmail(), code);
        // TODO: En el futur, aquí cridarem al servei d'enviament de correu
        System.out.println("DEBUG: Codi de recuperació per a " + email + ": " + code); 
    }

    /**
     * ESCENARI 2: RECUPERACIÓ - PAS 2 (Validar codi i restablir)
     */
    public void resetPassword(String email, String code, String newPassword) {
        Usuari u = usuariRepo.findByEmail(email)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuari no trobat"));

        // Validacions de seguretat del codi
        if (u.getRecoveryCode() == null || !u.getRecoveryCode().equals(code)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El codi és incorrecte");
        }
        if (u.getRecoveryExpiration().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El codi ha caducat");
        }

        // Tot correcte: actualitzem i netegem els camps de recuperació
        u.setPasswordHash(passwordService.hash(newPassword));
        u.setRecoveryCode(null);
        u.setRecoveryExpiration(null);
        
        usuariRepo.save(u);
    }
	
}
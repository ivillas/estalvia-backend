package cat.estalvia.controller;

/**
 * Clase per controller per accions d'inici de sessió
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cat.estalvia.dto.LoginRequest;
import cat.estalvia.dto.RegisterRequest;
import cat.estalvia.repository.UsuariRepository;
import cat.estalvia.service.AuthService;
import cat.estalvia.service.PasswordService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;
	private final UsuariRepository usuariRepo; 
	private final PasswordService passwordService; 

	public AuthController(AuthService authService, UsuariRepository usuariRepo, PasswordService passwordService) {
		this.authService = authService;
		this.usuariRepo = usuariRepo;
		this.passwordService = passwordService;
	}

	/*
	 * Login usuari
	 */

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		//busquem a l'usuari per el nom
		return usuariRepo.findByUsername(req.getUsername())
				.map(user -> {
					// verifiquem la contrasenya
					if (passwordService.verify(req.getPassword(), user.getPasswordHash())) {
						return ResponseEntity.ok(user); // Retorna lobjete usuario complert
					}
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password incorrecte");
				})
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuari no t'robat"));
	}

	/*
	 * Registre d'usuari
	 */

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
		authService.register(req);
		return ResponseEntity.ok("Usuari creat");
	}
}


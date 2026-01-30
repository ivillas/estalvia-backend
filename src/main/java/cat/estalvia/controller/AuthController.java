package cat.estalvia.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.estalvia.dto.LoginRequest;
import cat.estalvia.dto.RegisterRequest;
import cat.estalvia.entity.Usuari;
import cat.estalvia.repository.UsuariRepository;
import cat.estalvia.service.AuthService;
import cat.estalvia.service.PasswordService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuariRepository usuariRepo; // <--- 1. Añade esta línea
    private final PasswordService passwordService; // <--- 2. Y esta para verificar

    public AuthController(AuthService authService, UsuariRepository usuariRepo, PasswordService passwordService) {
        this.authService = authService;
        this.usuariRepo = usuariRepo;
        this.passwordService = passwordService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        // Buscamos al usuario por nombre
        return usuariRepo.findByUsername(req.getUsername())
            .map(user -> {
                // Verificamos la contraseña
                if (passwordService.verify(req.getPassword(), user.getPasswordHash())) {
                    return ResponseEntity.ok(user); // Retorna el objeto usuario completo
                }
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password incorrecto");
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        authService.register(req);
        return ResponseEntity.ok("Usuario creado");
    }
}


package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


/**
 * Entitat Usuari
 */

@Entity
@Table( name = "usuaris")
public class Usuari {

	public Usuari() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name="username", length=50, nullable=false, unique=true)
	private String username;

	@Column(name="email", length=150, nullable=false, unique=true)
	private String email;

	@Column(name="password_hash", length=255, nullable=false)
	private String passwordHash;

	@Enumerated(EnumType.STRING)
	@Column(name="rol")
	private Rol rol;

	@Column(name="activo")
	private Boolean activo;

	@Column(name="data_creacio")
	private LocalDateTime dataCreacio;

	@Column(name="recovery_code", length=6)
	private String recoveryCode;

	@Column(name="recovery_expiration")
	private LocalDateTime recoveryExpiration;

	// ===== GETTERS & SETTERS =====

	public Long getUserId() { return userId; }
	public void setUserId(Long userId) { this.userId = userId; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPasswordHash() { return passwordHash; }
	public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

	public Rol getRol() { return rol; }
	public void setRol(Rol rol) { this.rol = rol; }

	public Boolean getActivo() { return activo; }
	public void setActivo(Boolean activo) { this.activo = activo; }

	public LocalDateTime getDataCreacio() { return dataCreacio; }
	public void setDataCreacio(LocalDateTime dataCreacio) { this.dataCreacio = dataCreacio; }

	public String getRecoveryCode() { return recoveryCode; }
	public void setRecoveryCode(String recoveryCode) { this.recoveryCode = recoveryCode; }

	public LocalDateTime getRecoveryExpiration() { return recoveryExpiration; }
	public void setRecoveryExpiration(LocalDateTime recoveryExpiration) { this.recoveryExpiration = recoveryExpiration; }
}
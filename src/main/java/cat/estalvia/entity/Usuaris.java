package cat.estalvia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(
   name = "usuaris"
)
public class Usuaris {
    @EmbeddedId
    @Column(name = "user_id", nullable=false)
    private BigDecimal user_id;
    
    @Column(name="username", length=50, nullable=false, unique=true)
    private String username;
    
    @Column(name="email", length=150, nullable=false, unique=true)
    private String email;
    
    @Column(name="password_hash", length=255, nullable=false, unique=false)
    private String password_hash;

    @Column(name="rol", length=25, nullable=false, unique=false)
    private String rol;
   
    @Column(name = "activo")
    private Boolean activo;

	@Column(name = "data_creacio", nullable=true,unique=false)
	private Date data_creacio;

	public BigDecimal getUser_id() {
		return user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getData_creacio() {
		return data_creacio;
	}

	public void setData_creacio(Date data_creacio) {
		this.data_creacio = data_creacio;
	}

	
 
    
  
}

package cat.estalvia.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * DTO per els usuaris
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuariDTO {
	private Long userId;
	private String username;
	private String email;
	private String dataCreacio; 

	// Constructor vacío para Jackson
	public UsuariDTO() {}

	// Getters y Setters
	public Long getUserId() { return userId; }
	public void setUserId(Long userId) { this.userId = userId; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getDataCreacio() { return dataCreacio; }
	public void setDataCreacio(String dataCreacio) { this.dataCreacio = dataCreacio; }
}
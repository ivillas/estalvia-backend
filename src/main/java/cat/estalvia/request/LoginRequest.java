package cat.estalvia.request;


/**
 * Request del login d'usuari
 */


public class LoginRequest {
	private String username;
	private String password;

	public LoginRequest() {}


	// getters & setters

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}
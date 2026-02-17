package cat.estalvia.request;


/**
 * Request de Recuperar contrasenya
 */


public class ForgotRequest {
	private String email;

	public ForgotRequest() {}

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}

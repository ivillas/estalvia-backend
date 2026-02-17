package cat.estalvia.request;


/**
 * Request del reset de contrasenya
 */

public class ResetRequest {
	private String email;
	private String newPassword;

	public ResetRequest() {}

	//Getters & Setters

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getNewPassword() { return newPassword; }
	public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
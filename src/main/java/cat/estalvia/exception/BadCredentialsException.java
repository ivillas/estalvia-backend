package cat.estalvia.exception;

/**
 * Exepcions de les credencials dels usuaris
 */

public class BadCredentialsException extends RuntimeException {

	public BadCredentialsException(String message) {
		super(message);
	}
}

package cat.estalvia.exception;


/**
 * Exepcions dels nombsUsuaris
 */


public class UsernameNotFoundException extends RuntimeException {

	public UsernameNotFoundException(String message) {
		super(message);
	}
}
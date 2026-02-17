package cat.estalvia.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * Clase Service per la contrasenya
 */

@Service
public class PasswordService {


	/**
	 * Metode per convertir el paswor en el hask encriptat
	 * @param rawPassword
	 * @return pasword hasheat amb BCrypt
	 */
	public String hash(String rawPassword) {
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
	}

	/**
	 * Metode per verificar el pasword en text pla amb el hasheat
	 * @param rawPassword
	 * @param hashed
	 * @return  (true o False)
	 */
	public boolean verify(String rawPassword, String hashed) {
		return BCrypt.checkpw(rawPassword, hashed);
	}
}
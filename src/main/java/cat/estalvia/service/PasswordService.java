package cat.estalvia.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public String hash(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }
    
    public boolean verify(String rawPassword, String hashed) {
        return BCrypt.checkpw(rawPassword, hashed);
    }
}
package cat.estalvia.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCodiRecuperacio(String to, String codi) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Codi de recuperació - EstalviaApp");
        message.setText("El teu codi de recuperació és: " + codi + 
                        "\n\nAquest codi caducarà en 15 minuts.");
        
        mailSender.send(message);
    }
}
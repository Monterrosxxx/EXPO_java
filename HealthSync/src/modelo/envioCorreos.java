package modelo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class envioCorreos {
    
    public static void enviarCorreo(String recipient, String subject, String codigo) {
        // Propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        // Credenciales de la cuenta de correo
        final String myAccountEmail = "somos.healthsync@gmail.com";
        final String password = "f mi w f x k b m u d j b r k g";
        
        // Crear sesión
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(InternetAddress.parse(myAccountEmail)[0]);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            
            // Contenido HTML
            String htmlContent = "<html>"
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0;\">"
                + "    <div style=\"max-width: 600px; margin: auto; padding: 20px; background-color: #ffffff; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">"
                + "        <h1 style=\"color: #6a1b9a; text-align: center;\">HealthSync</h1>"
                + "        <h2 style=\"color: #6a1b9a; text-align: center;\">Recuperación de Contraseña</h2>"
                + "        <p style=\"color: #333333;\">Hola,</p>"
                + "        <p style=\"color: #333333;\">Has solicitado la recuperación de tu contraseña. Utiliza el siguiente código de verificación:</p>"
                + "        <div style=\"background-color: #6a1b9a; color: #ffffff; padding: 20px; text-align: center; border-radius: 5px;\">"
                + "            <h2>" + codigo + "</h2>"
                + "        </div>"
                + "        <p style=\"color: #333333;\">Por favor, ingresa este código en la aplicación para continuar con el proceso de recuperación.</p>"
                + "        <p style=\"color: #333333;\">Saludos,</p>"
                + "        <p style=\"color: #333333;\">El equipo de HealthSync</p>"
                + "    </div>"
                + "</body>"
                + "</html>";
            
            // Establecer el contenido HTML
            message.setContent(htmlContent, "text/html; charset=utf-8");
            
            // Enviar mensaje
            Transport.send(message);
            System.out.println("Correo enviado con éxito");
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
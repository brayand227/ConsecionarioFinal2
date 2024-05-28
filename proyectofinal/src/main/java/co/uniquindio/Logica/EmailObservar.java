package co.uniquindio.Logica;

import javax.mail.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailObservar implements Observador {
    private String emailDestino;

    public EmailObservar(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    @Override
    public void actualizar(String tipo, String mensaje) {
        enviarEmail(tipo, mensaje);
    }

    private void enviarEmail(String tipo, String mensaje) {
        // Configura las propiedades de la conexión
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Gmail
        props.put("mail.smtp.port", "587"); // Puerto del servidor SMTP
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticación
        String nombreUsuario = "concesionariouniversidadq@gmail.com";
        String contrasena = "wrfc aekj owoh txxt"; // Usa la contraseña de la aplicación si tienes 2FA habilitado

        Session sesion = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(nombreUsuario, contrasena);
            }
        });

        try {
            // Crear el mensaje de correo
            Message mensajeEmail = new MimeMessage(sesion);
            mensajeEmail.setFrom(new InternetAddress("concesionariouniversidadq@gmail.com"));
            mensajeEmail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
            mensajeEmail.setSubject("Ofertas de " + tipo);
            mensajeEmail.setText(mensaje);

            // Enviar el correo
            Transport.send(mensajeEmail);

            System.out.println("Correo enviado a " + emailDestino);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

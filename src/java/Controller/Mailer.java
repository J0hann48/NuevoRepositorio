package Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer {

    public static void send(String para, String sujeto, String mensaje) throws UnsupportedEncodingException {

        final String user = "proyectojardinweb17@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "proyectojardinweb2017";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {

//            File archivo = new File("Documents/pruebaMail.txt");
//            BodyPart adjunto = new MimeBodyPart();
            String[] destinatatios = null;

            //Se utilizo split para que separarà la cadena cuando encuentre un punto y coma (;) y los carga en un array
            destinatatios = para.split(";");
            InternetAddress[] destino = new InternetAddress[destinatatios.length];
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
//            if (archivo.exists()) {
//                adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
//                adjunto.setFileName("pruebaMail.txt");
//                multiparte.addBodyPart(adjunto);
//            } else {
//                System.out.println("No existe el archivo");
//            }

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user, "Prueba jardin"));
//            InternetAddress destinatario = new InternetAddress(destinatatios[1]);

            for (int i = 0; i < destinatatios.length; i++) {
                destino[i] = new InternetAddress(destinatatios[i]);
            }
//InternetAddress[] destinatarios={
//    new InternetAddress(para),
//    new InternetAddress("nelrodrigueza@misena.edu.co"),
//    new InternetAddress("kelyen2039@gmail.com"),
//    new InternetAddress("nelherson@hotmail.com")
//};
            message.addRecipients(Message.RecipientType.TO, destino);
//            message.addRecipients(Message.RecipientType.TO, destino);
            message.setSubject(sujeto);
            message.setContent(multiparte, "text/html; charset=utf-8");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.pismirer.utilities;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    
    public static boolean enviarEmail(String destinatario, String asunto, String cuerpo){
        String remitente = "jamartinez6000@misena.edu.co";
        
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //Protocolo estandar para envio de correos de manera segura
        props.put("mail.smtp.host", "smtp.gmail.com"); //Host por donde sale el correo, En este caso SMTP de Gmail
        props.put("mail.smtp.ssl.trust", "*"); //Permite o confirma que todo lo que se envia sera seguro
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "rgtsnqqbarmhhfxl"); //Clave de aplicacion de la cuenta
        props.put("mail.smtp.auth", "true"); //Autentificar mediante el correo del remitente y la clave
        props.put("mail.smtp.starttls.enable", "true"); //Conexion de manera segura el servidor SMTP
        props.put("mail.smtp.port", "587"); //Puerto seguro de Google
        
        Session session = Session.getDefaultInstance(props); //Se inicia sesion
        MimeMessage message = new MimeMessage(session); //Se crea el objeto para envio de mensajes una vez iniciada la Sesion
        
        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            String clave = "rgtsnqqbarmhhfxl";
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;   
        } catch (MessagingException me) {
            me.printStackTrace();
            System.out.println("####" + me.getMessage());
            return false;
        }
        
    }
    
}

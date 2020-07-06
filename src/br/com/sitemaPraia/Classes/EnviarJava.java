/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sitemaPraia.Classes;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author PC
 */
public class EnviarJava {

    public void envioAnexo(String nomeRemetente, String assunto, String mensagem, String destinatario, String imagem) throws UnsupportedEncodingException {
        try {
            String host = "smtp.gmail.com";
            String usuario = "";
            String senha = "";
            String remetente = "";
            
            boolean sessionDebug = true;

            Properties props = System.getProperties();            
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            
             props.setProperty("mail.debug", "true");

//            jdk > 8
//            java.security.Security.addProvider(new Provider(host, remetente, senha) {
//            });

//            jdk == 8
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(remetente, nomeRemetente));             msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(assunto);
            msg.setSentDate(new Date());

            // cria a primeira parte da mensagem
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent(mensagem, "text/html;charset=UTF-8");

            // cria a segunda parte da mensage
            MimeBodyPart mbp2 = new MimeBodyPart();

            // anexa o arquivo na mensagem
            FileDataSource fds = new FileDataSource(imagem);
            mbp2.setDataHandler(new DataHandler(fds));
            mbp2.setFileName(fds.getName());

            // cria a Multipart
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);

            // adiciona a Multipart na mensagem
            msg.setContent(mp);

            // configura a data: cabecalho
            msg.setSentDate(new Date());

            // envia a mensagem
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, usuario, senha);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("Enviado com Sucesso");
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }

    
    
}
package com.pos.demo.Controllers;

import com.pos.demo.Services.AdminService;
import com.pos.demo.models.AdminLoginRequest;
import com.pos.demo.models.AdminRegisterRequest;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    /*................. registerAdmin..............*/

    @RequestMapping("/registerAdmin")
    public ResponseEntity<Object> register(@RequestBody @Valid AdminRegisterRequest adminRegisterRequest){
        Map<String, Object> response= new HashMap<>();
        response=adminService.register(adminRegisterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    /*................. loginAdmin..............*/
    @RequestMapping("/Adminlogin")
    public ResponseEntity<Object> login(@RequestBody @Valid AdminLoginRequest adminLoginRequest){
        Map<String,Object> response= new HashMap<>();
        response=adminService.login(adminLoginRequest);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    /*................. send email..............*/

    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws javax.mail.MessagingException, MessagingException, IOException {
        sendmail();
        return "Email sent successfully";
    }
    private void sendmail() throws javax.mail.MessagingException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tutorialspoint@gmail.com", "<your password>");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tutorialspoint@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

    }

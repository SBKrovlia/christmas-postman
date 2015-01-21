package com.gmail.berdnik.stanislav.service.impl;

import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Service for sending mails
 *
 * Build message, attaches into message required elements and sends it
 *
 * Created by Berdniky on 28.12.2014.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    private static final String SENDER_MAIL = "christmas.postman.app@gmail.com";
    private static final String CONGRATULATION_SUBJECT = "HAPPY NEW YEAR!";

    @Autowired
    @Qualifier("congratulationMailSender")
    private JavaMailSender mailSender;

    @Async
    public void sendMail(Congratulation congratulation, String msg) throws MailParseException {
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(SENDER_MAIL);
            helper.setTo(congratulation.getEmail());
            helper.setSubject(CONGRATULATION_SUBJECT);
            helper.setText(msg);
            if(congratulation.getPicture()!= null) {                 //todo: get rid of hardcoding
                FileSystemResource filePicture = new FileSystemResource(congratulation.getPicture());
                helper.addAttachment(filePicture.getFilename(), filePicture);
            }
            if(congratulation.getAudio()!= null) {
                FileSystemResource fileAudio = new FileSystemResource(congratulation.getAudio());
                helper.addAttachment(fileAudio.getFilename(), fileAudio);
            }
            if(congratulation.getVideo()!= null) {
                FileSystemResource fileVideo = new FileSystemResource(congratulation.getVideo());
                helper.addAttachment(fileVideo.getFilename(), fileVideo);
            }
        }catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(message);

    }

    @Async
    public void sendCongratulationMail(Congratulation congratulation) throws IOException, TemplateException {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(MailServiceImpl.class, "/");
            Template emailTemplate = config.getTemplate("templates/congratulationMail.ftl");
            final StringWriter writer = new StringWriter();
            final Map<String, Object> templateMap = new HashMap<String, Object>();
            templateMap.put("congratulation", congratulation.getText());
            emailTemplate.process(templateMap, writer);
            sendMail(congratulation, writer.toString());
    }
}

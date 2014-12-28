package com.gmail.berdnik.stanislav.service.impl;

import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Berdniky on 28.12.2014.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    private static final String SENDER_MAIL = "stanislav.berdnik@gmail.com";
    private static final String CONGRATULATION_SUBJECT = "HAPPY NEW YEAR!";

    @Autowired
    @Qualifier("congratulationMailSender")
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendMail(String from, String to, String subject, String msg) {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    @Async
    public void sendMail(SimpleMailMessage msg) {
        mailSender.send(msg);
    }

    @Async
    public void sendCongratulationMail(Congratulation congratulation) {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(MailServiceImpl.class, "/");
        try {
            Template emailTemplate;
            emailTemplate = config.getTemplate("templates/congratulationMail.ftl");
            final StringWriter writer = new StringWriter();
            final Map<String, Object> templateMap = new HashMap<String, Object>();
            templateMap.put("congratulation", congratulation.getText());
            emailTemplate.process(templateMap, writer);
            sendMail(SENDER_MAIL, congratulation.getEmail(), CONGRATULATION_SUBJECT, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}

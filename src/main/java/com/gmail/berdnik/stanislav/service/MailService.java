package com.gmail.berdnik.stanislav.service;

import com.gmail.berdnik.stanislav.model.Congratulation;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Berdniky on 28.12.2014.
 */
public interface MailService {
    /**
     *
     * @param from -
     * @param to
     * @param subject
     * @param msg -
     */
    void sendMail(String from, String to, String subject, String msg);

    void sendMail(SimpleMailMessage msg);

    void sendCongratulationMail(Congratulation congratulation);

}

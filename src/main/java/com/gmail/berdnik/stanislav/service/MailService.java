package com.gmail.berdnik.stanislav.service;

import com.gmail.berdnik.stanislav.model.Congratulation;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Created by Berdniky on 28.12.2014.
 */
public interface MailService {

    void sendCongratulationMail(Congratulation congratulation) throws IOException, TemplateException;
}

package com.gmail.berdnik.stanislav.service;

import com.gmail.berdnik.stanislav.model.Congratulation;

/**
 * Created by Berdniky on 28.12.2014.
 */
public interface MailService {

    void sendCongratulationMail(Congratulation congratulation);

}

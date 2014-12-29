package com.gmail.berdnik.stanislav.utils;

import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.CongratulationService;
import com.gmail.berdnik.stanislav.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Berdniky on 28.12.2014.
 */
@Component
public class CongratulationSender {
    public static final int JOB_DELAY = 60000;

    @Autowired
    MailService mailService;
    @Autowired
    CongratulationQueue congratulationQueue;
    @Autowired
    CongratulationService congratulationService;

    @Scheduled(fixedDelay = JOB_DELAY)
    public void congratulationSend() throws InterruptedException {
        while (!congratulationQueue.isEmpty()) {
            long id = congratulationQueue.getCongratulationId();
            Congratulation congrat = congratulationService.getById(id);
            mailService.sendCongratulationMail(congrat);
//            if (congrat.getPicture() != null) {
//                final File file = new File(congrat.getPicture());
//                if (file.exists()) file.delete();
//            }
//            if (congrat.getAudio() != null) {
//                final File file = new File(congrat.getAudio());
//                if (file.exists()) file.delete();
//            }
//            if(congrat.getVideo() != null) {
//                final File file = new File(congrat.getVideo());
//                if (file.exists()) file.delete();
//            }
//            congratulationService.delete(congrat);
            System.out.println(id);
            System.out.println(congrat);
        }
    }
}

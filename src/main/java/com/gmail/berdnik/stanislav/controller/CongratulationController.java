package com.gmail.berdnik.stanislav.controller;

import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.CongratulationService;
import com.gmail.berdnik.stanislav.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Berdniky on 27.12.2014.
 */
@Controller
@RequestMapping("/")
public class CongratulationController {

    @Autowired
    CongratulationService congratulationService;
    @Autowired
    MailService mailService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCongratulationPage() {
        final ModelAndView mav = new ModelAndView("/congratulationPage");
        mav.addObject("congratulation", new Congratulation());
        return mav;
    }

    @RequestMapping(value = "/saveCongratulation", method = RequestMethod.POST)
    public String saveCongratulation (@ModelAttribute("congratulation") Congratulation congratulation) {
        congratulationService.create(congratulation);
        mailService.sendCongratulationMail(congratulation);
        return "redirect:/";
    }
}

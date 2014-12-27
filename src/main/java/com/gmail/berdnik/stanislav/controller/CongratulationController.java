package com.gmail.berdnik.stanislav.controller;

import com.gmail.berdnik.stanislav.model.Congratulation;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCongratulationPage() {
        final ModelAndView mav = new ModelAndView("/congratulationPage");
        mav.addObject("congratulation", new Congratulation());
        return mav;
    }

    @RequestMapping(value = "/saveCongratulation", method = RequestMethod.POST)
    public String saveCongratulation (@ModelAttribute("congratulation") Congratulation congratulation) {
        Session session =  new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(congratulation);
        session.getTransaction().commit();
        return "/congratulationPage";
    }
}

package com.gmail.berdnik.stanislav.controller;

import org.springframework.stereotype.Controller;
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
        mav.addObject("message", "Hello!");
        return mav;
    }
}

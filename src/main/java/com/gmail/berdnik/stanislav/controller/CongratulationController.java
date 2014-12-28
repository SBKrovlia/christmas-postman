package com.gmail.berdnik.stanislav.controller;

import com.gmail.berdnik.stanislav.model.Congratulation;
import com.gmail.berdnik.stanislav.service.CongratulationService;
import com.gmail.berdnik.stanislav.service.MailService;
import com.gmail.berdnik.stanislav.utils.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    @Autowired
    FileUploader fileUploader;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCongratulationPage() {
        final ModelAndView mav = new ModelAndView("/congratulationPage");
        mav.addObject("congratulation", new Congratulation());
        return mav;
    }

    @RequestMapping(value = "/saveCongratulation",  method = RequestMethod.POST)
    public String saveCongratulation(@ModelAttribute("congratulation") Congratulation congratulation,
                                     @RequestParam(value = "uploadPicture", required = false) MultipartFile picture,
                                     @RequestParam(value = "uploadAudio", required = false) MultipartFile audio,
                                     @RequestParam(value = "uploadVideo", required = false) MultipartFile video) {
        congratulationService.create(congratulation);
        final String congratulationId = ((Long)congratulation.getId()).toString();
        if((!picture.isEmpty()) || (!audio.isEmpty()) || (!video.isEmpty())) {
            if (!picture.isEmpty()) {
                String congratulationsPicturePath = fileUploader.saveFile(congratulationId, picture, "jpg");
                congratulation.setPicture(congratulationsPicturePath);
            }
            if (!audio.isEmpty()) {
                String congratulationsAudioPath = fileUploader.saveFile(congratulationId, audio, "mp3");
                congratulation.setAudio(congratulationsAudioPath);
            }
            if (!video.isEmpty()) {
                String congratulationsVideoPath = fileUploader.saveFile(congratulationId, video, "mp4");
                congratulation.setVideo(congratulationsVideoPath);
            }
            congratulationService.update(congratulation);
        }

        mailService.sendCongratulationMail(congratulation);

        return "redirect:/";
    }
}

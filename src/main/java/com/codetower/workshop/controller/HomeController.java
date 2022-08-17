package com.codetower.workshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@AllArgsConstructor
class HomeController {

    @GetMapping("")
    public ModelAndView home(){
        var modelAndView = new ModelAndView("Home");
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }
}

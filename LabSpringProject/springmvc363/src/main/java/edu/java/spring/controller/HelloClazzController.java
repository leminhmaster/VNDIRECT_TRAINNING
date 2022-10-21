package edu.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
//@RequestMapping(value = "/hello")
public class HelloClazzController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView hello1(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message","MINH");
        return mv;
    }
}

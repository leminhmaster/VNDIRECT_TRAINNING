package edu.hanoi.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

//    @RequestMapping(value = "/")
//    @ResponseBody String home1(){
//        return "Hello Word!";
//    }
    @RequestMapping(value = {"/","/home"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message","Hello Java Clazz");
        logger.info("HomeController da duoc truy cap");
        return mv;
    }
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value = "error" , required = false) String error){
        ModelAndView mv = new ModelAndView("login");
        if (error !=  null) mv.addObject("error", "Sai ten hoac mat khau");
        return mv;
    }
    @RequestMapping(value = "/nguoi-dung" )
    public ModelAndView forUser(){
        ModelAndView mv = new ModelAndView("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        mv.addObject("message","Hello User " + auth.getName());
        return mv;
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request , HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/";
    }
}

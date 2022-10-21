package edu.hanoi.jazz.controller;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.impl.GroupDAOImpl;
import edu.hanoi.jazz.dao.impl.UserDAOImpl;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/account")
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/add")
    public ModelAndView addForm(){
        ModelAndView mv = new ModelAndView("user.form","command", new User());
        mv.addObject("groups",toGroupMap(groupDAO.getAllGroups()));
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute(value = "command") User user, BindingResult result){
        if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("user.form","command",new User());
            mv.addObject("groups",toGroupMap(groupDAO.getAllGroups()));
            mv.addObject("errors",result);
            return mv;
        }
        LOGGER.info("========Add new User=======");
        userDAO.insert(user);
        return new ModelAndView("redirect:/account/list?groupId="+user.getGroupId());

    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "groupId",required = false) Integer groupId){
        ModelAndView mv = new ModelAndView("user.list");
//        mv.addObject("users",userDAO.getUsersByGroup(groupId));
//        mv.addObject("users",userDAO.page(1));
        mv.addObject("users",userDAO.listUserByNativeSql());
        mv.addObject("average", ((UserDAOImpl)userDAO).averageAge());
        return mv;
    }
    @RequestMapping(value = "/detail/{username}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable String username){
        ModelAndView mv = new ModelAndView("user.detail");
        mv.addObject("user",userDAO.get(username));
        return mv;
    }
    private Map<Integer,String> toGroupMap(List<Group> groups){
        Map<Integer,String> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getId(),group.getName()));
        return map;
    }
    @RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
    public String delete(@PathVariable String username){
        userDAO.delete(username);
        return "redirect:/account/list";
    }
    @RequestMapping(value = "/older")
    public ModelAndView older(){
        ModelAndView mv = new ModelAndView("user.list");
        mv.addObject("users",userDAO.listOlder());
        return mv;
    }
    @RequestMapping(value = "/addmore")
    public String addRandom(){
        userDAO.addBatch();
        return "redirect:/account/list";
    }

}

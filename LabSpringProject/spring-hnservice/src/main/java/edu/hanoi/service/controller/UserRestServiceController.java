package edu.hanoi.service.controller;

import edu.hanoi.service.dao.GroupDAO;
import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserRestServiceController {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private GroupDAO groupDAO;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
//    @PostFilter("filterObject.username == 'username-random1'")
    @PostFilter("hasPermission(filterObject,'read')")
    public List<User> listUser(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("\n--------------> "+auth.getAuthorities());
//        if (!request.isUserInRole("ROLE_USER")) {
//            throw new RuntimeException("Access Denied!");
//        }
        return userDAO.list();
    }

    @RequestMapping(value = "/user/addmore" , method = RequestMethod.GET)
    public String addmore(){
        userDAO.addMore();
        return "them user";
    }
    @RequestMapping(value = "/group/list")
    public Group[] listGroup(){
        return groupDAO.list().toArray(new Group[0]);
    }
    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return userDAO.insert(user);
    }
    @RequestMapping(value = "user/edit", method = RequestMethod.POST)
    public String editUser(@RequestBody User user){
        return "Chua co";
    }

    @RequestMapping(value = "/user/get/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name){
        return userDAO.get(name);
    }

    @RequestMapping(value = "/user/delete/{name}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable String name){
        userDAO.delete(name);
    }
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public void updateUser(@RequestBody User user){
        userDAO.update(user);
    }

    @RequestMapping(value = "/admin/list",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    @PostFilter("hasPermission(filterObject,'read')")
    public List<User> getListAdminUsers(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("\n--------------> "+auth.getAuthorities());
        if (!request.isUserInRole("ROLE_ADMIN")) {
            throw new RuntimeException("Access Denied!");
        }
        return userDAO.list();
    }
}

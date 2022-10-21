package edu.hanoi.jazz.service;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

public class JazzConnectionSignUp implements ConnectionSignUp {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private UserDAO userDAO;

    @Override
    public String execute(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        LOGGER.info("======== > id "+userProfile.getId() + " name: "+userProfile.getName());
        User user = userDAO.get(userProfile.getEmail());
        if (user != null) {return user.getUsername();}
        user = new User();
        user.setUsername(userProfile.getEmail());
        user.setPassword("123");
        user.setGroupId(1601);
        user.setEmail(userProfile.getEmail());
        userDAO.insert(user);
        return user.getUsername();
    }
}

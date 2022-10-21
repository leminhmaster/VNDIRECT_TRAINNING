package edu.hanoi.service;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HNServicePermissionEvaluator implements PermissionEvaluator {

    private final Logger LOGGER = Logger.getLogger(this.getClass());




    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (targetDomainObject.getClass().equals(User.class)){
            User user = (User) targetDomainObject;
            LOGGER.info("------->"+targetDomainObject+" : "+permission+" ---- "+user.getUsername()+" || "+user.getAge());

            return user.getAge() > 50;
        }
//        if (targetDomainObject instanceof User)
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        LOGGER.info("-------->"+targetType+" : "+permission);
        return true;
    }
}

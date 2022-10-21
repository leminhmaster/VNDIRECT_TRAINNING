package edu.hanoi.message.service;

import edu.hanoi.data.GroupDAO;
import edu.hanoi.message.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private static final Logger LOGGER = Logger.getLogger(GroupService.class);

    @Autowired
    @Qualifier("groupDAO")
    private GroupDAO groupDAO;

//    public String add(Group group){
//        LOGGER.info("-------> Add group"+group.getName());
//        return "Found "+groupDAO.add(group);
//    }

    private List<Group> groups;

    public Group add(Group group){
        LOGGER.info("-------> Add group"+group.getName());
        return group;
    }

    public void handleMessage(List<Group> groups){
        this.groups = groups;
        groups.forEach(group -> {
            System.out.println(group.getId()+" : "+group.getName());
        });
    }
}

package edu.hanoi.data;

import edu.hanoi.message.model.Group;

import java.util.List;

public interface GroupDAO {
    String add(Group group);

    List<Group> list();
}

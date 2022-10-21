package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;

import java.util.List;

public interface GroupDAO {
    public void insert(Group group);
    public void update(Group group);
    public void delete(int groupId);
    public Group getGroupById(int groupId);
    public List<Group> getAllGroups();
    public List<Group> searchByName(String name);
}

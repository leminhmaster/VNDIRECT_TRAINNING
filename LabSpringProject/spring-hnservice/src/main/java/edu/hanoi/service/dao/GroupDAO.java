package edu.hanoi.service.dao;

import edu.hanoi.service.model.Group;

import java.util.List;

public interface GroupDAO {
    public void insertRandom();
    public List<Group> list();
}

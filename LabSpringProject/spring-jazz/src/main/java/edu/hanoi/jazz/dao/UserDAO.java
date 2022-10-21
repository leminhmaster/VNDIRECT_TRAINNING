package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserDAO {
    public void insert(User user);
    public void update(User user);
    public void delete(String username);
    public List<User> getAllUser();
    public List<User> getUsersByGroup(Integer group);
    public User get(String username);
    public List<User> listOlder();
    public List<User> page(int page);
    public List<User> listUserByNativeSql();

    void addBatch();
}

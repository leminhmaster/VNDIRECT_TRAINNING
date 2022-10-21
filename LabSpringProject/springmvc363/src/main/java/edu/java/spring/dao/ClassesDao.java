package edu.java.spring.dao;

import edu.java.spring.model.Classes;
import edu.java.spring.model.Student;

import java.util.List;

public interface ClassesDao {
    public void insert(Classes student);
    public List<Classes> list();
    public void delete(int id);
    public Classes get(int id);
    public void update(Student student);
    public List<Classes> searchByName(String name);
}

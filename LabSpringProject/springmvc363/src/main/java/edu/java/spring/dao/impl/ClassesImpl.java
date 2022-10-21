package edu.java.spring.dao.impl;

import edu.java.spring.dao.ClassesDao;
import edu.java.spring.model.Classes;
import edu.java.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ClassesImpl implements ClassesDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;



    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Classes student) {

    }

    @Override
    public List<Classes> list() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Classes get(int id) {
        return null;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Classes> searchByName(String name) {
        return null;
    }
}

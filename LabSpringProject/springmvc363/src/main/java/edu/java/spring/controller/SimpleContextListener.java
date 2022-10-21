package edu.java.spring.controller;

import edu.java.spring.dao.CreateTable;
import org.apache.derby.jdbc.EmbeddedDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class SimpleContextListener implements ServletContextListener {

    private CreateTable tbl = new CreateTable();
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("khoi tao web thanh cong");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(EmbeddedDriver.class.getName());
            dataSource.setUrl("jdbc:derby:D:/LabSpringProject/springmvc363/student_db;create=true");
            tbl.setDataSource(dataSource);
            tbl.InitTableIfnotExists();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("huy servlet");
        ServletContextListener.super.contextDestroyed(sce);
    }
}

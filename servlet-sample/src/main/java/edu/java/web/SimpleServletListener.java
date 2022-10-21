package edu.java.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

//@WebListener()
public class SimpleServletListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        try {
            ConnectionSQL.getSingeltonPatern().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n\n ServletContextListener destroyed\n\n");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionSQL.getSingeltonPatern();
        ServletContextListener.super.contextInitialized(sce);
        System.out.println("\n\n ServletContextListener started\n\n");
    }


}

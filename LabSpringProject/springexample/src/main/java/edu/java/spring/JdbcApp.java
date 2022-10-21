package edu.java.spring;

import edu.java.spring.jdbc.Student;
import edu.java.spring.jdbc.StudentJdbcDAO;
import org.apache.log4j.Logger;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcApp {
    private final static Logger LOGGER = Logger.getLogger(JdbcApp.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");

        LOGGER.info(" create bean "+jdbc);
        jdbc.insert("Nguyen Van A2",24);
        jdbc.insert("Nguyen Van A3",23);
        jdbc.updateAgeByNameSQL("Nguyen Van A", 60);
        jdbc.deleteStudentByName("Nguyen Van A1");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Thi A",17));
        students.add(new Student("Le VAn L",20));
        students.add(new Student("Phan Thi Z",25));
        int[] values = jdbc.add(students);
        for (int i=0;i< values.length;i++){
            LOGGER.info("add record "+i+" : "+ (values[i] == 0 ? "failed":"success"));;
        }
        LOGGER.info("Total students is "+jdbc.totalRecord());
        jdbc.save("Tran Thi A",23);
        LOGGER.info("Total students is "+jdbc.totalRecord());
        jdbc.loadStudent("").forEach(student -> LOGGER.info(student));
    }
}

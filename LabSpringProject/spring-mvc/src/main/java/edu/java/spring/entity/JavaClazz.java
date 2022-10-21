package edu.java.spring.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clazz1")
public class JavaClazz {

    private List<Student> students1;

    public JavaClazz() {
    }

    public JavaClazz(List<Student> students) {
        this.students1 = students;
    }

    @XmlElements(@XmlElement(name = "student1",type = Student.class))
    public List<Student> getStudents(){return students1;}

    public void setStudents(List<Student> students) {
        this.students1 = students;
    }
}

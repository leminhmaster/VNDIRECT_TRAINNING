package edu.java.spring.model;

public class Student {
    private int id;
    private String name;
    private Integer age;
    private Classes classes;

    public Student() {
    }

    public Student(int id, String name, Integer age, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classes = classes;
    }

    public Student(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

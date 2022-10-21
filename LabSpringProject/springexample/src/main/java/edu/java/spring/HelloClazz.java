package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("helloJavaClazz2")
public class HelloClazz implements DisposableBean {
    String message ;
    private List<JavaClazz> clazzes;
    public void printMessage(){
        System.out.println("Your Message: "+message);
    }
    private void initMessage(){
        System.out.println("Calling init method......");
        message ="From init method: Say hello bean!";
    }

    public HelloClazz() {
        this.message = "From constructor method: Say hello everyone!";
    }

    private void release(){
        message = null;
        System.out.println("Message is null!");
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null!");
    }

    public HelloClazz(int persons) {
        System.out.println("Calling constructor int method.....");
        this.message = "From Constructor: Say hello to "+persons+" persons!";
    }

    public HelloClazz(HelloClazz clazz){
        System.out.println("Calling constructor clazz method.....");
        message = clazz.message;
    }

    public void setMessage(String message) {
        this.message = "Call From Setter: "+message;
    }

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }
}

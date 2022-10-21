package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class HelloWord {
    private final static Logger LOGGER = Logger.getLogger(HelloWord.class);
    @Autowired(required = true)
    @Qualifier("helloJavaClazz")
    private HelloClazz clazz;
    String message;
    public void sayHello() {
        clazz.printMessage();
        LOGGER.info("From HelloWord : "+message);
    }
    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWord(String name, HelloClazz clazz) {
        message="From HelloWorld constructor: "+name+" : "+clazz.message;

    }
    public HelloWord(){

    }

    public HelloClazz getClazz() {
        return clazz;
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz = clazz;
    }
}

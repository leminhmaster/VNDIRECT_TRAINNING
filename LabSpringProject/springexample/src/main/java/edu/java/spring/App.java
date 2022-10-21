package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger LOGGER = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        context.start();
        //context.registerShutdownHook();
        ((HelloWord) context.getBean("helloWorld6")).sayHello();
       // context.stop();
//        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
//        LOGGER.info("Map Implementation is "+clazz.getStudents().getClass());
//        LOGGER.info("There are "+clazz.getStudents().size()+" in the class");
//        HelloClazz clazz1 = (HelloClazz) context.getBean("helloJavaClazz2");
//        LOGGER.info("Total classes is "+clazz1.getClazzes().size());
//        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz2");
//        obj.printMessage();
//        System.out.println(obj);
//
//        HelloClazz obj2 = (HelloClazz) context.getBean("HelloClazz");
//        obj2.printMessage();
//        System.out.println(obj2);
//
//        HelloClazz obj3 = (HelloClazz) context.getBean("HelloClazz2");
//        obj3.printMessage();
//        System.out.println(obj3);
//
//        HelloClazz obj4 = (HelloClazz) context.getBean("HelloClazz3");
//        obj4.printMessage();
//        System.out.println(obj4);
    }
}

package edu.java.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        HelloClazz myBean1 = (HelloClazz) ctx.getBean("bean2");
        myBean1.printMessage();
        System.out.println(myBean1);

        HelloClazz myBean2 = (HelloClazz) ctx.getBean("bean2");
        myBean2.printMessage();
        System.out.println(myBean2);

    }
}

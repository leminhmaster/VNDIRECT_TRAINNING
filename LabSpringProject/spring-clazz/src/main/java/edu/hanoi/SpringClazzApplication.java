package edu.hanoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"edu.java.web.config","edu.hanoi.controller","edu.hanoi"})
//@ComponentScan(basePackages = "edu.*")
public class SpringClazzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClazzApplication.class, args);
	}

//	@Bean
//	public InternalResourceViewResolver viewResolver(){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/jsp/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
}

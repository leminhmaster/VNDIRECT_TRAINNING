package edu.hanoi.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@EnableWebMvc
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {


//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
}

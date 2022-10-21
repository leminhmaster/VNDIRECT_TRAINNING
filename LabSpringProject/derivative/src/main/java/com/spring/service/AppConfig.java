package com.spring.service;

import com.spring.service.model.entity.Derivative;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/application.properties")
public class AppConfig implements WebMvcConfigurer {

    private Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("=========================start application =========================");
        LOGGER.info("======Context start application "+dataSource());


        try {
            createTable("derivative","CREATE TABLE derivative ( " +
                    "deri_composite_code VARCHAR(20) NOT NULL, " +
                    "derivative_code VARCHAR(20) NOT NULL primary key, " +
                    "effective_date datetime, " +
                    "expiration_date datetime, " +
                    "created_date datetime, " +
                    "created_by VARCHAR(10), " +
                    "modified_date datetime, " +
                    "modified_by VARCHAR(10), " +
                    "underlying_type VARCHAR(20))");

        }catch (Exception e){
            LOGGER.error(e,e);
        }
    }

    @Bean
    public DataSource dataSource(){
        String url = env.getProperty("jdbc.url");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url);
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.spring.service.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
        return properties;
    }

    private void createTable(String name, String script) throws Exception{
        DatabaseMetaData dbmd = dataSource().getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null,null,name,null);
        if (rs.next()){
            LOGGER.info("======TABLE "+rs.getString("TABLE_NAME")+ " already exists !");
            return;
        }
        dataSource().getConnection().createStatement().executeUpdate(script);
    }
}

package edu.hanoi.message;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;


public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private final Logger LOGGER = Logger.getLogger(this.getClass());
    @Autowired
//    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info("==================================Context start application "+dataSource);
        try{
            createTable("HN_GROUP"," create table HN_GROUP(id bigint primary key generated always as identity (start with 1 , increment by 1), name varchar(100) ) ");
            createTable("HN_USER"," create table HN_USER(username varchar(100) primary key, password varchar(100), email varchar(100),age integer, groupId bigint, constraint group_fk FOREIGN KEY (groupId) REFERENCES HN_GROUP(id))");
        }catch (Exception e){
            LOGGER.error(e,e);
        }
    }

    private void createTable(String name, String script) throws Exception{
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null,null,name,null);
        if (rs.next()){
            LOGGER.info("======TABLE "+rs.getString("TABLE_NAME")+ " already exists !");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
    }

}

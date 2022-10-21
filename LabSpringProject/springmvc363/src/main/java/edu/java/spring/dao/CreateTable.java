package edu.java.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.FileCopyUtils;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {

    private static Logger LOGGER = Logger.getLogger(CreateTable.class);
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String tblclasses;
    private String tblstudent;
    public void setCreateTable(){
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resourceclasses = loader.getResource("classpath:/tblclasses.sql");
        Resource resourcestudent = loader.getResource("classpath:/tblstudent.sql");
        String sql = "";
        try {
            Reader readerclasses = new InputStreamReader(resourceclasses.getInputStream(), StandardCharsets.UTF_8);
            Reader readerstudent = new InputStreamReader(resourcestudent.getInputStream(), StandardCharsets.UTF_8);

            this.tblclasses = FileCopyUtils.copyToString(readerclasses);
            this.tblstudent = FileCopyUtils.copyToString(readerstudent);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }



    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        setCreateTable();
    }

    public void InitTableIfnotExists() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null,"APP",null,null);
        int c =0;
        while (rs.next()){
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
            c++;
        }
        if (c==0){
            jdbcTemplate.execute(tblclasses);
            jdbcTemplate.execute(tblstudent);
        } else {
            System.out.println("da co table");
        }

    }
}

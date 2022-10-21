package edu.java.spring.jdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private void createTableIfNotExists() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }
        jdbcTemplate.execute("CREATE TABLE STUDENT ( id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , name VARCHAR(1000) , age INTEGER )");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private String insertQuery;

    public String getInsertQuery() {
        return insertQuery;
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public void insert(String name, int age){
        jdbcTemplate.update(insertQuery,name,age);
        LOGGER.info("Created Record Name = "+name+" Age = "+age);
    }

    public int totalRecord(){
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM STUDENT");

                return rs.next()? rs.getInt(1):0;
            }
        });
    }
    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) {
            try {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                return student;
            }catch (Exception e){
                LOGGER.error(e,e);
                return null;
            }

        }


    }
    public List<Student> loadStudent(String name){
        return this.jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%"+name+"%'",new StudentRowMapper());
    }

    private String updateAgeByNameSQL = "UPDATE STUDENT SET age = ? WHERE name = ?";

    public String getUpdateAgeByNameSQL() {
        return updateAgeByNameSQL;
    }

    public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
        this.updateAgeByNameSQL = updateAgeByNameSQL;
    }

    public void updateAgeByNameSQL(String name , int age){
        this.jdbcTemplate.update(updateAgeByNameSQL,age,name);
        LOGGER.info("Update Record Name = "+name+" Age = "+age);
    }

    private String deleteStudentByName = " DELETE FROM STUDENT WHERE name = ? ";

    public String getDeleteStudentByName() {
        return deleteStudentByName;
    }

    public void setDeleteStudentByName(String deleteStudentByName) {
        this.deleteStudentByName = deleteStudentByName;
    }

    public void deleteStudentByName(String name) {
        this.jdbcTemplate.update(deleteStudentByName,name);
        LOGGER.info("DELETE Record Name = "+name);
    }
    public int[] add(List<Student> students){
        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> {
            batch.add(new Object[]{student.getName(),student.getAge()});
        });
        return jdbcTemplate.batchUpdate(insertQuery,batch);
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void save(String name, int age){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        String countQuery = " SELECT COUNT(*) FROM STUDENT ";
        Integer total =0;
        try {
            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("before save data, total record is "+total);

            String sql = " INSERT INTO STUDENT (name,age) VALUES ( ? , ? ) ";
            jdbcTemplate.update(sql,name,age);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after save data, total record is "+total);

            String countQuery2 = "SELECT COUNT(* FROM STUDENT ";
            total = jdbcTemplate.queryForObject(countQuery2, Integer.class);

            transactionManager.commit(status);
        }catch (Exception e) {
            transactionManager.rollback(status);
            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after rollback data, total record is "+total);
            //throw e;
        }
    }
}

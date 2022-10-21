package com.spring.service.dao.impl;

import com.spring.service.dao.DerivativeDAO;
import com.spring.service.model.entity.Derivative;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DerivativeDAOImpl implements DerivativeDAO {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    private int totalPages;
    private int totalElements;

    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Derivative> filterDerivative(Integer page, Integer size ,String sortField, String sort ,String qField, String [] qValue) {
        Session session = sessionFactory.getObject().openSession();
        try {
            String orderby = "";
            String condition="";
            if (sortField!=null){
                orderby = makeorderby(sortField,sort);
            }
            if (qField!=null){
                condition = makecondition(qField);
            }
            Query query;

            if (qValue != null){
                query = session.createQuery("from Derivative "+condition+" :qval "+orderby);
                query.setParameter("qval", Arrays.stream(qValue).toList());
            }else{
                query = session.createQuery("from Derivative "+orderby);
            }
            int totalResult = query.list().size();
            this.totalElements = totalResult;
//            System.out.println(totalResult/size);
            this.totalPages = (int) Math.ceil(((double) totalElements/(double) size));
            int offset = (page-1)*size;
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return (List<Derivative>) query.list();
        }finally {
            session.close();
        }
    }

    private String makeorderby(String sortField, String sort ){
        String sortstr = "";
        Field[] fields = Derivative.class.getDeclaredFields();
        ArrayList<String> nameField = new ArrayList<>();
        Arrays.stream(fields).forEach(field -> nameField.add(field.getName()));
        if (nameField.contains(sortField)){
            sortstr = " order by "+sortField;
            if (sort.toLowerCase().compareTo("desc") == 0){
                sortstr += " "+sort;
            }else{
                sortstr += " asc";
            }
            return sortstr;

        }else return "";
    }
    private String makecondition(String qField){
        String condition = "";
        Field[] fields = Derivative.class.getDeclaredFields();
        ArrayList<String> nameField = new ArrayList<>();
        Arrays.stream(fields).forEach(field -> nameField.add(field.getName()));
        if (nameField.contains(qField)){
            condition = " where "+qField+ " in ";
            return condition;
        }
        return "";
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}

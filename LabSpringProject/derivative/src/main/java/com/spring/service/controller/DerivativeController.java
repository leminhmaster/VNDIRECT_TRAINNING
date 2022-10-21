package com.spring.service.controller;

import com.spring.service.dao.DerivativeDAO;
import com.spring.service.dao.impl.DerivativeDAOImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DerivativeController {

    @Autowired
    private DerivativeDAO derivativeDAO;

    @RequestMapping(value = "/{username}/derivative")//minh.leduc/derivative
    public String filterDerivative(
            @PathVariable(name = "username") String username,
            @RequestParam(name = "page" , defaultValue = "1", required = false) Integer page,
            @RequestParam(name = "size" , defaultValue = "2", required = false) Integer size,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "q", required = false) String q){

//        System.out.println(sort);
        String sortField = null;
        String sortval = null;
        if (sort != null){
            String [] sorts = sort.split(":");
            sortField = sorts[0];
            if (sorts.length == 1){
                sortval = "asc";
            }else{
                sortval = sorts[1];
            }
        }

        String qField = null;
        String [] qVal = null;
//        System.out.println(q);
        if (q!=null){
            String [] qs = q.split(":");
            qField = qs[0];
            if (qs.length == 1){
                qVal = null;
            }else{
                qVal = qs[1].split(",");
            }
        }
//        System.out.println(qField);

        DerivativeDAOImpl dao = (DerivativeDAOImpl) derivativeDAO;
        JSONObject object = new JSONObject();
        object.put("data",derivativeDAO.filterDerivative(page,size,sortField,sortval,qField,qVal));
        object.put("size",size);
        object.put("current_page",String.valueOf(page));
        object.put("totalPages",String.valueOf(dao.getTotalPages()));
        object.put("totalElements",dao.getTotalElements());
        return object.toString();
    }
}

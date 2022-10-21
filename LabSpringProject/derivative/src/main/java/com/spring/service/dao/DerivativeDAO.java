package com.spring.service.dao;

import com.spring.service.model.entity.Derivative;

import java.util.List;

public interface DerivativeDAO {
    public List<Derivative> filterDerivative(Integer page, Integer size ,String sortField, String sort ,String qField, String [] qValue);


}

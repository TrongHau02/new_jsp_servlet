package com.example.dao;

import com.example.model.NewModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewModel>{
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);
    NewModel findOne(Long id);
    void update(NewModel updateNew);
    void delete(long id);
    List<NewModel> findAll();
    int getTotalItem();
}

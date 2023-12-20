package com.example.service;

import com.example.model.NewModel;

import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryId);
    NewModel save(NewModel newModel);
    NewModel update(NewModel updateNew);
    void delete(Long[] ids);
    List<NewModel> findAll();
    int getTotalItem();
}

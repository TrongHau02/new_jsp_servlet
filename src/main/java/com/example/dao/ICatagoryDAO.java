package com.example.dao;

import com.example.model.CategoryModel;
import com.example.model.NewModel;

import java.util.List;

public interface ICatagoryDAO extends GenericDAO<CategoryModel> {
    List<CategoryModel> findAll();
}

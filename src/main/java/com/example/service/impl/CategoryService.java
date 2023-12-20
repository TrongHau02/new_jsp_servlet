package com.example.service.impl;

import com.example.dao.ICatagoryDAO;
import com.example.dao.impl.CategoryDAO;
import com.example.model.CategoryModel;
import com.example.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICatagoryDAO catagoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return catagoryDAO.findAll();
    }
}

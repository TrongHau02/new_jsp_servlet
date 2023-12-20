package com.example.dao.impl;

import com.example.dao.ICatagoryDAO;
import com.example.mapper.CategoryMapper;
import com.example.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICatagoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }
}

package com.example.dao.impl;

import com.example.dao.INewDAO;
import com.example.mapper.NewMapper;
import com.example.model.NewModel;

import java.util.List;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewModel newModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
        sql.append(" categoryid, thumbnail, shortdescription, createddate, createdby)");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
                newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCreatedDate(), newModel.getCreatedBy());
    }

    @Override
    public NewModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ");
        sql.append("shortdescription = ?, content = ?, categoryid = ?, ");
        sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ?  WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(),
                updateNew.getCreatedBy(), updateNew.getModifiedDate(), updateNew.getCreatedBy(), updateNew.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<NewModel> findAll() {
        String sql = "SELECT * FROM news";
        return query(sql, new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM news";
        return count(sql);
    }
}

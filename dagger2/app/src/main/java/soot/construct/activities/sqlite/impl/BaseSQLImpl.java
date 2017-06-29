package soot.construct.activities.sqlite.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import soot.construct.activities.sqlite.repository.BaseRepository;

/**
 * Created by Lapcio on 2017-06-28.
 */

// Tutaj znajduje się implementacja wszystkich metod z interfejsu BaseRepository
public class BaseSQLImpl <T, I> implements BaseRepository<T, I> {

    protected Dao<T,I> mDao;
    @Override
    public List<T> findAll() {
        try{
            return mDao.queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public T findById(I id) {
        try{
            return id != null ? mDao.queryForId(id): null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(T r) {
        try{
            return mDao.create(r) > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        try{
            return mDao.queryForAll().size() == 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(T r) {
        try {
            return mDao.update(r) >0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(T r) {
        try {
            return mDao.delete(r) > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAll(T r) {
        try{
            if (count() != 0){
                TableUtils.dropTable(mDao, false);
                TableUtils.createTable(mDao);
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long count() {
        try{
            return mDao.countOf();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}

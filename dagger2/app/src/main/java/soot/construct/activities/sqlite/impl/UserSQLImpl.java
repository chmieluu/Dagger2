package soot.construct.activities.sqlite.impl;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import soot.construct.activities.sqlite.repository.UserRepository;
import soot.construct.models.User;

/**
 * Created by Lapcio on 2017-06-28.
 */

// W klasie BaseSQLImpl znajdują się implementacje metod podstawowych z BaseRepository
// Tutaj znajdują się implementacje metod z interfejsu UserRepository
public class UserSQLImpl extends BaseSQLImpl<User, UUID> implements UserRepository{
    public UserSQLImpl(ConnectionSource connectionSource) {
        try {
            mDao = DaoManager.createDao(connectionSource, User.class); //DAO - Database Access Object
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //Zwraca ostatnio zalogowanego uzytkownika
    public User findLastLoginUser() {
        try{
            List<User> users = mDao.queryForAll();
            return (users != null && !users.isEmpty()) ? users.get(0) : null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    // Metoda, która ma wyszukać użytkownika po loginie
    public User findUserByLogin(String login) {
        try{
            List <User> users = mDao.queryBuilder().where().eq("LOGIN", login).query();
            return (users != null && !users.isEmpty()) ? users.get(0) : null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

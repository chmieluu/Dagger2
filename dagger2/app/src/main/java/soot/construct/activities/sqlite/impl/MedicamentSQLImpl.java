package soot.construct.activities.sqlite.impl;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import soot.construct.activities.sqlite.repository.MedicamentRepository;
import soot.construct.models.Medicament;

/**
 * Created by Lapcio on 2017-06-28.
 */
    // W klasie BaseSQLImpl znajdują się implementacje metod podstawowych z BaseRepository
    // Tutaj znajdują się implementacje metod z interfejsu MedicamentRepository
public class MedicamentSQLImpl extends BaseSQLImpl<Medicament, UUID> implements MedicamentRepository {
    public MedicamentSQLImpl(ConnectionSource connectionSource) {
        try {
            mDao = DaoManager.createDao(connectionSource, Medicament.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    //findAllExpired znajdzie liste leków, których data ważności już mineła
    public List<Medicament> findAllExpired() {
        try{
            return mDao.queryBuilder().where().eq("WAZNOSC", true).query();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

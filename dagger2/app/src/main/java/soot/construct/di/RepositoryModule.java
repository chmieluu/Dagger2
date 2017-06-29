package soot.construct.di;

import android.app.Application;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import soot.construct.activities.sqlite.DatabaseHelper;
import soot.construct.activities.sqlite.impl.MedicamentSQLImpl;
import soot.construct.activities.sqlite.impl.UserSQLImpl;
import soot.construct.activities.sqlite.repository.MedicamentRepository;
import soot.construct.activities.sqlite.repository.UserRepository;

/**
 * Created by Lapcio on 2017-06-28.
 */
@Module
public class RepositoryModule {
    @Provides
    @Singleton  //Singleton - wzorzec projektowy, który zakłada że tylko jeden obiekt powstanie
    ConnectionSource providesConnectionSource(Application app){
        return new AndroidConnectionSource(new DatabaseHelper(app));
    }

    @Provides
    @Singleton
    MedicamentRepository providesMedicamentRepository(ConnectionSource connectionSource){
        return new MedicamentSQLImpl(connectionSource);
    }

    UserRepository providesUserRepository(ConnectionSource connectionSource){
        return new UserSQLImpl(connectionSource);
    }
}

package soot.construct.activities.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import soot.construct.models.Medicament;
import soot.construct.models.User;

/**
 * Created by Lapcio on 2017-06-28.
 */

    //Wszystkie klasy odpowiedzialne za obsługe SQL powinny być napisane w pakiecie sqlite.
    // Klasa niezbędna do obsługi bazy danych. Wymagana jest implementacja zdarzeń onCreate i onUpgrade by mogła działać.

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME ="Database.db";
    private static final int DATABAASE_VERSION =0;

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABAASE_VERSION);
    }

    @Override
    // OnCreate odpowiada za utworzenie tabel z klas modelu.
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Log.i(DatabaseHelper.class.getName(), "OnCreate");
        try {
            // Ważna jest kolejność dodawania tabel. Jeśli dodajemy tabele, która korzysta z kluczy obcych (innych tabel)
            // trzeba najpierw zadbać by te inne tabele już istniały w bazie.
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Medicament.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    // OnUpdate pozwala zaktualizować baze na zasadzie "Usuń stare tabele i utwórz ponownie nowe"
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.i(DatabaseHelper.class.getName(), "OnUpgrade");
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Medicament.class, true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }
}

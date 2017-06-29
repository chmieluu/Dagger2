package soot.construct.activities.sqlite.repository;

import java.util.List;
import java.util.UUID;

import soot.construct.models.Medicament;

/**
 * Created by Lapcio on 2017-06-28.
 */
    // poszczegolne repozytoria wzbohacamy o metody, ktore dla nich sa charakterystyczne (unikatowe)
public interface MedicamentRepository extends BaseRepository<Medicament, UUID> {
    //findAllExpired znajdzie liste leków, których data ważności już mineła
    List<Medicament> findAllExpired();

}

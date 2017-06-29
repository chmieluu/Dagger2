package soot.construct.activities.sqlite.repository;

import java.util.List;

/**
 * Created by Lapcio on 2017-06-28.
 */

// podstawowy interface dla repozytoriów wszystkie kolejne repozytoria opierają się na metodach z tej klasy bazowej
public interface BaseRepository<T, I> {
    List<T> findAll();

    T findById(I id);

    boolean create(T r);

    boolean isEmpty();

    boolean update(T r);

    boolean delete(T r);

    boolean deleteAll(T r);

    long count();
}

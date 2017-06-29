package soot.construct.activities.sqlite.repository;

import java.util.UUID;

import soot.construct.models.User;

/**
 * Created by Lapcio on 2017-06-28.
 */

public interface UserRepository extends BaseRepository <User, UUID> {
    User findLastLoginUser();       // Zwraca ostatnio zalogowanego uzytkownika
    User findUserByLogin(String login);     //Metoda, która ma wyszukać użytkownika po loginie
}

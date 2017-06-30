package soot.construct.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

/**
 * Created by Lapcio on 2017-06-28.
 */

// W Modelowych klasach nalezy dodać znaczniki, aby móc przetworzyć klase na tabele, a pola na atrybuty bazy.
@DatabaseTable(tableName = "uzytkownik")
public class User {
    @DatabaseField(id = true)
    private UUID id;                // Klasa UUID pozwala wykorzystywać właściwości pola ID tak jak w bazach danych.
    @DatabaseField
    @SerializedName("LOGIN")        //Same pola należy również serializować, nadając im nazwe atrybutu
    private String login;
    @DatabaseField
    @SerializedName("PASSWORD")
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


}

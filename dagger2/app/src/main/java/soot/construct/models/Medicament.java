package soot.construct.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.UUID;

/**
 * Created by Kuba on 10.05.2017.
 */
@DatabaseTable(tableName = "lekarstwo")
public class Medicament {

    @DatabaseField(id = true)
    private UUID id;
    @DatabaseField
    @SerializedName("NAZWA")
    private String name;
    @DatabaseField
    @SerializedName("KOD")
    private String code;
    @DatabaseField
    @SerializedName("OPIS")
    private String description;
    @DatabaseField
    @SerializedName("DAWKA")
    private String dosage;
    @DatabaseField
    @SerializedName("DATA")
    private Long date;
    @DatabaseField
    @SerializedName("NUMER_SERYJNY")
    private int number;
    @DatabaseField
    @SerializedName("WAZNOSC")
    private boolean expired;
    public Medicament(){}

    public Medicament(String name, String code, @Nullable String description, String dosage, Long date, int number, boolean expired) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.dosage = dosage;
        this.date = date;
        this.number = number;
        this.expired = expired;
    }



    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    @Nullable
    public String getDescription() {
        return description;
    }

    public String getDosage() {
        return dosage;
    }

    public Long getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", dosage='" + dosage + '\'' +
                ", date=" + date +
                ", number=" + number +
                '}';
    }
}

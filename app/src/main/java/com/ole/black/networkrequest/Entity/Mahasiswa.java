package com.ole.black.networkrequest.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "mahasiswa")
public class Mahasiswa implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String nim;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}

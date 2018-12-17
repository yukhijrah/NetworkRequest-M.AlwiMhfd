package com.ole.black.networkrequest.Entity;

import java.io.Serializable;

public class Mahasiswa implements Serializable {
    public int getId() {
        return id;
    }

    private int id;
    private String name;
    private String nim;

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

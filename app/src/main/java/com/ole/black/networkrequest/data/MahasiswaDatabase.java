package com.ole.black.networkrequest.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ole.black.networkrequest.Entity.Mahasiswa;

/**
 * Created by ole on 1/7/19.
 */
@Database(entities = {Mahasiswa.class},version = 1,exportSchema = false)
public abstract class MahasiswaDatabase extends RoomDatabase {
    public abstract MahasiswaDao MahasiswaDao();
}

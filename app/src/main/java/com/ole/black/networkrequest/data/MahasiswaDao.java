package com.ole.black.networkrequest.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ole.black.networkrequest.Entity.Mahasiswa;

import java.util.List;

import retrofit2.http.DELETE;

/**
 * Created by ole on 1/7/19.
 */
@Dao
public interface MahasiswaDao {
    @Insert
    void insert(Mahasiswa mahasiswa);

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getMahasiswa();

    @Update
    void update(Mahasiswa mahasiswa);

    @DELETE
    void delete(Mahasiswa mahasiswa);
}

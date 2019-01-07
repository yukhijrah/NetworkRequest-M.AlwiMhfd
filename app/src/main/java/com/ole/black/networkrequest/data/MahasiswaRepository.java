package com.ole.black.networkrequest.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.ole.black.networkrequest.Entity.Mahasiswa;

import java.util.List;

/**
 * Created by ole on 1/7/19.
 */

public class MahasiswaRepository {
    private final static String DB_NAME = "datalokal";
    private MahasiswaDatabase mahasiswaDatabase;

    public MahasiswaRepository(Context context){
        mahasiswaDatabase= Room.databaseBuilder(context,MahasiswaDatabase.class,DB_NAME).build();
    }

    public void insertMahasiswa(final Mahasiswa mahasiswa){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                mahasiswaDatabase.MahasiswaDao().insert(mahasiswa);
                return null;
            }
        }.execute();
    }

    public List<Mahasiswa> getMahasiswa(){
        return mahasiswaDatabase.MahasiswaDao().getMahasiswa();
    }
}

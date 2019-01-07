package com.ole.black.networkrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ole.black.networkrequest.Adapter.MahasiswaAdapter;
import com.ole.black.networkrequest.Entity.Mahasiswa;
import com.ole.black.networkrequest.data.MahasiswaRepository;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    private RecyclerView lstFav;
    private MahasiswaRepository mhsRepository;
    private MahasiswaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        lstFav=(RecyclerView)findViewById(R.id.lst_favorite);

        mhsRepository=new MahasiswaRepository(this);
        List<Mahasiswa> mahasiswas=mhsRepository.getMahasiswa();
        if (mahasiswas.size()>0){
            adapter=new MahasiswaAdapter(mahasiswas);
            lstFav.setAdapter(adapter);
        }else {
            Toast.makeText(FavoriteActivity.this,"Tidak ada item favorite",Toast.LENGTH_LONG).show();
        }

    }
}

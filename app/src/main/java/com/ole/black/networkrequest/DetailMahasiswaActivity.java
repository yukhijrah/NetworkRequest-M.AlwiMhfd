package com.ole.black.networkrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ole.black.networkrequest.Entity.Mahasiswa;
import com.ole.black.networkrequest.Network.Network;
import com.ole.black.networkrequest.Network.Router;
import com.ole.black.networkrequest.Util.Consts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {

    private EditText edtName, edtNim;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        edtName=(EditText)findViewById(R.id.edt_name);
        edtNim=(EditText)findViewById(R.id.edt_nim);
        btnAdd=(Button)findViewById(R.id.btn_add);

        String action=getIntent().getStringExtra(Consts.KEY_ACTION_DETAIL);
        switch (action){
            case Consts.INTENT_ADD:
                btnAdd.setText("TAMBAH MAHASISWA");
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String nim = edtNim.getText().toString();
                        if (!name.isEmpty()&&!nim.isEmpty()) {
                            addNewMahasiswa(name, nim);
                        }else {
                            Toast.makeText(DetailMahasiswaActivity.this,"maaf, nama dan nim tidak boleh kosong",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            case Consts.INTENT_EDIT:
                final Mahasiswa mahasiswa=(Mahasiswa) getIntent().getSerializableExtra("mahasiswa");
                edtName.setText(mahasiswa.getName());
                edtNim.setText(mahasiswa.getNim());

                btnAdd.setText("UPDATE DATA");
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mahasiswa.setName(edtName.getText().toString());
                        mahasiswa.setNim(edtNim.getText().toString());
                        updateMahasiswa(mahasiswa);
                    }
                });
                break;
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String nim = edtNim.getText().toString();
                addNewMahasiswa(name, nim);
            }
        });
    }

    private void addNewMahasiswa(String name, String nim) {
        Router services = Network.request().create(Router.class);

        services.postMahasiswa(name, nim).enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                if (response.isSuccessful()) {
                    finish();
                } else {
                    Toast.makeText(DetailMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                Toast.makeText(DetailMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateMahasiswa(Mahasiswa mahasiswa){
        Router services=Network.request().create(Router.class);

        String mahasiswaId=String.valueOf(mahasiswa.getId());
        String name=mahasiswa.getName();
        String nim=mahasiswa.getNim();

        services.updateMAhasiswa(mahasiswaId,name,nim).enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                if (response.isSuccessful()){
                    Toast.makeText(DetailMahasiswaActivity.this,
                            "update berhasil",
                            Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    onErrorAddMahasiswa();
                }
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                onErrorAddMahasiswa();
            }
        });
    }
    private void onErrorAddMahasiswa() {
        Toast.makeText(DetailMahasiswaActivity.this,
                "Maaf, terjadi kesalahan",
                Toast.LENGTH_LONG).show();
    }
}

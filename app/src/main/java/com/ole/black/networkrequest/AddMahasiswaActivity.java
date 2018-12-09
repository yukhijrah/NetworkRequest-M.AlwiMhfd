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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMahasiswaActivity extends AppCompatActivity {

    private EditText edtName, edtNim;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);

        edtName=(EditText)findViewById(R.id.edt_name);
        edtNim=(EditText)findViewById(R.id.edt_nim);
        btnAdd=(Button)findViewById(R.id.btn_add);

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
                    Toast.makeText(AddMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {
                Toast.makeText(AddMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
            }
        });
    }
}

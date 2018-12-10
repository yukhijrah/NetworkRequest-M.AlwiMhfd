package com.ole.black.networkrequest.Network;

import com.ole.black.networkrequest.Entity.DaftarMahasiswa;
import com.ole.black.networkrequest.Entity.Mahasiswa;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Router {
    @GET("dev/list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();

    @POST("dev/insert_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );

    @DELETE("mahasiswatest/{mhsId}")
    Call<Mahasiswa> deleteMahasiswa(
            @Path("mhsId") String mhsId
    );
}

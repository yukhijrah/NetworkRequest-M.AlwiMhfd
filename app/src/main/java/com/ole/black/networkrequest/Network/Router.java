package com.ole.black.networkrequest.Network;

import com.ole.black.networkrequest.Entity.DaftarMahasiswa;
import com.ole.black.networkrequest.Entity.Mahasiswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Router {
    @GET("list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();

    @POST("post_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );
}

package com.example.xxxxxx.adnroidretrofitmysql.api;

import com.example.xxxxxx.adnroidretrofitmysql.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @FormUrlEncoded
    @POST("create_data.php")
    Call<ResponseModel> sendData(@Field("npm") String npm,
                                 @Field("nama") String nama,
                                 @Field("prodi") String prodi,
                                 @Field("fakeultas") String fakeultas);

    @GET("view_data.php")
    Call<ResponseModel> getData();

    @FormUrlEncoded
    @POST("update_data.php")
    Call<ResponseModel> updateData(@Field("npm") String npm,
                                 @Field("nama") String nama,
                                 @Field("prodi") String prodi,
                                 @Field("fakeultas") String fakeultas);
}

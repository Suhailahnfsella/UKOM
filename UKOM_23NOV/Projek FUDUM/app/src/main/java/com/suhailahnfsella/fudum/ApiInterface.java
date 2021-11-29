package com.suhailahnfsella.fudum;

/**
 * Created by root on 2/3/17.
 */

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/menu")
    Call<GetMenu> getMenu();

    @GET("/api/user")
    Call<GetUser> getUser();

    @POST("/api/register")
    Call<GetDaftar> daftarUser(@Body DaftarModel daftarModel);

    @POST("/api/login")
    Call<GetLogin> loginUser(@Body LoginModel loginModel);

    @Multipart
    @POST("/api/toko")
    Call<GetToko> insertToko(@Part("idtoko") RequestBody idtoko,
                             @Part("namatoko") RequestBody namatoko,
                             @Part("fototoko") MultipartBody.Part fototoko,
                            @Part("alamattoko") RequestBody alamattoko,
                            @Part("kecamatan") RequestBody kecamatan,
                            @Part("kabupaten") RequestBody kabupaten,
                            @Part("tahuntoko") RequestBody tahuntoko,
                            @Part("sosmed") RequestBody sosmed,
                            @Part("whatsapp") RequestBody whatsapp,
                            @Part("email") RequestBody email);

//    @FormUrlEncoded
//    @POST("kontak")
//    Call<PostPutDelKontak> postKontak(@Field("nama") String nama,
//                                      @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @PUT("kontak")
//    Call<PostPutDelKontak> putKontak(@Field("id") String id,
//                                     @Field("nama") String nama,
//                                     @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}

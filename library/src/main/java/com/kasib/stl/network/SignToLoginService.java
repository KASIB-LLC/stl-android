package com.kasib.stl.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kasib.stl.network.models.AuthResponse;
import com.kasib.stl.network.models.DocumentHistoryResponse;
import com.kasib.stl.network.models.LoginResponse;
import com.kasib.stl.network.models.OpenDocumentResponse;
import com.kasib.stl.network.models.RegisterResponse;
import com.kasib.stl.network.models.SaveDocumentResponse;
import com.kasib.stl.network.parameters.Location;
import com.kasib.stl.network.parameters.Resolution;
import com.kasib.stl.network.parameters.Sign;
import com.kasib.stl.network.parameters.SignsBundle;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public interface SignToLoginService {

    int
            GENDER_MALE = 1,
            GENDER_FEMALE = 0;

    @FormUrlEncoded
    @POST("register/")
    Call<RegisterResponse> register(
            @NonNull @Field("email") String email,
            @NonNull @Field("username") String username,
            @NonNull @Field("os_version") String os_version,
            @NonNull @Field("device_version") String device_version,
            @Field("time") long time,
            @NonNull @Field("resolution") Resolution resolution,
            @Field("pressure") int pressure,
            @NonNull @Field("signatures") SignsBundle signatures,
            @Nullable @Field("uid") String uid,
            @Nullable @Field("company_name") String company_name,
            @Nullable @Field("position") String position,
            @Nullable @Field("phone_number") String phone_number,
            @Nullable @Field("age") String age,
            @Field("gender") int gender,
            @Nullable @Field("location") Location location,
            @Nullable @Field("country") String country,
            @Nullable @Field("city") String city,
            @Nullable @Field("address") String address
    );

    @FormUrlEncoded
    @POST("login/")
    Call<LoginResponse> login(
            @NonNull @Field("email") String email,
            @NonNull @Field("os_version") String os_version,
            @NonNull @Field("device_version") String device_version
    );

    @FormUrlEncoded
    @POST("authenticate/")
    Call<AuthResponse> authenticate(
            @NonNull @Field("email") String email,
            @NonNull @Field("os_version") String os_version,
            @NonNull @Field("device_version") String device_version,
            @Field("time") long time,
            @NonNull @Field("resolution") Resolution resolution,
            @Field("pressure") int pressure,
            @NonNull @Field("signature") Sign signature,
            @Nullable @Field("photo") String photo,
            @Nullable @Field("location") Location location,
            @Nullable @Field("country") String country,
            @Nullable @Field("city") String city,
            @Nullable @Field("address") String address
    );

    @FormUrlEncoded
    @POST("savedocument/")
    Call<SaveDocumentResponse> saveDocument(
            @NonNull @Field("email") String email,
            @NonNull @Field("os_version") String os_version,
            @NonNull @Field("device_version") String device_version,
            @Field("time") long time,
            @NonNull @Field("resolution") Resolution resolution,
            @Field("pressure") int pressure,
            @NonNull @Field("signature") Sign signature,
            @NonNull @Field("previous_hash") String previous_hash,
            @NonNull @Field("document_hash") String document_hash,
            @Nullable @Field("document_id") String document_id,
            @Nullable @Field("photo") String photo,
            @Nullable @Field("location") Location location,
            @Nullable @Field("country") String country,
            @Nullable @Field("city") String city,
            @Nullable @Field("address") String address
    );

    @FormUrlEncoded
    @POST("opendocument/")
    Call<OpenDocumentResponse> openDocument(
            @NonNull @Field("email") String email,
            @NonNull @Field("document_id") String document_id,
            @NonNull @Field("document_hash") String document_hash
    );

    @FormUrlEncoded
    @POST("documenthistory/")
    Call<DocumentHistoryResponse> documentHistory(
            @NonNull @Field("email") String email,
            @NonNull @Field("document_id") String document_id
    );
}

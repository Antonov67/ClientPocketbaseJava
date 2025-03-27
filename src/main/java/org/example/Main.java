package org.example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {
    private static final String BASE_URL = "http://192.168.11.164:8090/api/";
    private static Retrofit retrofit;

    public static void main(String[] args) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<ResponseByClass> call = api.getAllClasses();
        call.enqueue(new Callback<ResponseByClass>() {
            @Override
            public void onResponse(Call<ResponseByClass> call, Response<ResponseByClass> response) {
                if (response.isSuccessful()){
                    ResponseByClass responseByClass = response.body();
                    for (Classroom classroom : responseByClass.items) {
                        System.out.println(classroom.name);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseByClass> call, Throwable throwable) {

            }
        });


    }
}
package org.example.service;

import org.example.API;
import org.example.Classroom;
import org.example.ResponseByClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String
            BASE_URL = "http://192.168.11.164:8090/api/";
    private static API api;

    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(API.class);
    }

    public void getAllClassrooms(SimpleDataCallback<ResponseByClass> callback) {
        Call<ResponseByClass> call = api.getAllClasses();
        call.enqueue(new Callback<ResponseByClass>() {
            @Override
            public void onResponse(Call<ResponseByClass> call, Response<ResponseByClass> response) {
                if (response.isSuccessful()) {
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseByClass> call, Throwable throwable) {

            }
        });
    }

    public void createClassroom(Classroom classroom,
                                SimpleDataCallback<Classroom> callback) {

        Call<Classroom> call = api.createClassroom(classroom);
        call.enqueue(new Callback<Classroom>() {
            @Override
            public void onResponse(Call<Classroom> call, Response<Classroom> response) {
                if (response.isSuccessful()){
                    callback.load(response.body());
                }
            }

            @Override
            public void onFailure(Call<Classroom> call, Throwable throwable) {

            }
        });


    }

    public void deleteClassroom(String id,
                                SimpleDataCallback<String> callback){
        Call<Void> call = api.deleteClassroom(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    callback.load("успешное удаление");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {

            }
        });
    }

}

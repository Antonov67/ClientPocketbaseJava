package org.example;

import org.example.service.RetrofitService;
import org.example.service.SimpleDataCallback;

public class Main {

    private static RetrofitService retrofitService;

    public static void main(String[] args) {

        retrofitService = new RetrofitService();

        retrofitService.getAllClassrooms(
                new SimpleDataCallback<ResponseByClass>() {
            @Override
            public void load(ResponseByClass data) {
                for (Classroom classroom : data.items){
                    System.out.println(classroom.name);
                }
            }
        });

    }
}
package org.example;

import org.example.presentation.MainForm;
import org.example.service.RetrofitService;
import org.example.service.SimpleDataCallback;

public class Main {

    private static RetrofitService retrofitService;
    private static MainForm mainForm;

    public static void main(String[] args) {

        retrofitService = new RetrofitService();
        mainForm = new MainForm();

        retrofitService.getAllClassrooms(
                new SimpleDataCallback<ResponseByClass>() {
            @Override
            public void load(ResponseByClass data) {
                for (Classroom classroom : data.items){
                    System.out.println(classroom.getName());
                }
            }
        });


    }
}
package org.example.data.service;

import org.example.data.classroom.Classroom;
import org.example.data.classroom.ResponseByClass;
import org.example.data.student.ResponseByStudent;
import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @GET("collections/class/records")
    Call<ResponseByClass> getAllClasses();

    @POST("collections/class/records")
    Call<Classroom> createClassroom(@Body Classroom classroom);

    @DELETE("collections/class/records/{id}")
    Call<Void> deleteClassroom(@Path("id") String id);

    @GET("collections/class/records")
    Call<ResponseByClass> getClassesByName(@Query("filter") String filter);

    @GET("collections/students/records")
    Call<ResponseByStudent> getAllStudents();
}

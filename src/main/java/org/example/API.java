package org.example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @GET("collections/class/records")
    Call<ResponseByClass> getAllClasses();

    @POST("collections/class/records")
    Call<Classroom> createClassroom(@Body Classroom classroom);

}

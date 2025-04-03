package org.example;

import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @GET("collections/class/records")
    Call<ResponseByClass> getAllClasses();

    @POST("collections/class/records")
    Call<Classroom> createClassroom(@Body Classroom classroom);

    @DELETE("collections/class/records/{id}")
    Call<Void> deleteClassroom(@Path("id") String id);
}

package org.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("collections/class/records")
    Call<ResponseByClass> getAllClasses();

}

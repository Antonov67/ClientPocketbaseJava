package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseByClass {
    @SerializedName("items")
    public List<Classroom> items;
}

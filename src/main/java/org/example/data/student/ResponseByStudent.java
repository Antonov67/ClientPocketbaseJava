package org.example.data.student;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseByStudent {
    @SerializedName("items")
    public List<Student> items;
}

package org.example.data.student;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("weight")
    private int weight;

    @SerializedName("height")
    private int height;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}

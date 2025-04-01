package org.example;

import com.google.gson.annotations.SerializedName;

public class Classroom {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    public Classroom(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

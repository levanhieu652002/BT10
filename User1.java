package com.example.levanhieu_2050531200143;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User1 {
    private String name;
    private String email;
    private String age;

    public User1() {
    }

    public User1(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }
}

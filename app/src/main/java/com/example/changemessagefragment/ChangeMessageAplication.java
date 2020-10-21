package com.example.changemessagefragment;

import android.app.Application;

import com.example.changemessagefragment.model.User;

public class ChangeMessageAplication extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("juanjo", "dam.juanjo.lago.sanchez@gmail.com");
    }
}

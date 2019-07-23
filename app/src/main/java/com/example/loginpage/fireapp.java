package com.example.loginpage;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

/**
 * Created by Burhan Infinity on 11/30/2017.
 */

public class fireapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}

package com.example.loginpage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loginActivity extends AppCompatActivity {
    private int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void back(View view) {


        Intent i=new Intent(loginActivity.this,MainActivity.class);

        startActivity(i);
    }
}

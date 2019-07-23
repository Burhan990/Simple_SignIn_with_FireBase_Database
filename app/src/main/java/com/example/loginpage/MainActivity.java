package com.example.loginpage;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private EditText ed1,ed2;
    private Button bn1;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.edit1);
        ed2=(EditText)findViewById(R.id.edit2);

        bn1=(Button)findViewById(R.id.login);

        mAuth=FirebaseAuth.getInstance();
        Intent i=getIntent();




        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });



    }
    //@Override
   // protected void onStart() {
       // super.onStart();

      //  mAuth.addAuthStateListener(mAuthListener);
   // }


    public void startSignIn(){

        String email=ed1.getText().toString();
        String password=ed2.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();

        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if (!task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "E-mail or Password is wrong!\nTry Again!", Toast.LENGTH_SHORT).show();
                    }
                    else if(task.isSuccessful()){

                        Intent i=new Intent(MainActivity.this,loginActivity.class);
                        startActivity(i);

                    }

                }
            });
        }



    }
}

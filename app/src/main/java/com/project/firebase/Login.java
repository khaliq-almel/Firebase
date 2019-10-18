package com.project.firebase;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText t_user,t_password;
    Button btn_login;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        t_user =(EditText)findViewById(R.id.userid);
        t_password=(EditText)findViewById(R.id.pass);
        btn_login=(Button)findViewById(R.id.signin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user=t_user.getText().toString().trim();
                final String password=t_password.getText().toString().trim();


                mAuth.signInWithEmailAndPassword(user, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(Login.this,"Sucessfully Registered",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    //FirebaseUser user = mAuth.getCurrentUser();
                                    //updateUI(user);

                                } else {
                                    // If sign in fails, display a message to the user.

                                }

                                // ...
                            }
                        });

            }
        });

    }

    private void updateUI(FirebaseUser user) {
    }

    public void gotoSignup(View view) {

        startActivity(new Intent(getApplicationContext(),SignupForm.class));
    }
}


/*
String user=t_user.getText().toString().trim();
                String pass=t_password.getText().toString().trim();
 */




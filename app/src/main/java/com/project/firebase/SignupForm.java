package com.project.firebase;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupForm extends AppCompatActivity {

    EditText t_fullname,t_user,t_email,t_password,t_phone;
    Button btn_register;
    RadioButton rmale,rfemale;
    String gender ="";

    private FirebaseAuth mAuth;

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        t_fullname= (EditText)findViewById(R.id.fullname);
        t_user=(EditText)findViewById(R.id.user);
        t_email=(EditText)findViewById(R.id.email);
        t_password=(EditText)findViewById(R.id.password);
        t_phone=(EditText)findViewById(R.id.phone);
        btn_register=(Button)findViewById(R.id.register);
        rmale=(RadioButton)findViewById(R.id.male);
        rfemale=(RadioButton)findViewById(R.id.female);


        mAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fname=t_fullname.getText().toString().trim();
                final String uname=t_user.getText().toString().trim();
                final String email=t_email.getText().toString().trim();
                final String phone=t_phone.getText().toString().trim();
                String password=t_password.getText().toString().trim();

                if(rmale.isChecked()){
                    gender="male";
                }
                if(rfemale.isChecked()){
                    gender="female";
                }

                if(TextUtils.isEmpty(fname)){
                    Toast.makeText(SignupForm.this,"Enter your name",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(uname)){
                    Toast.makeText(SignupForm.this,"Enter your Username",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(SignupForm.this,"Enter your email",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(SignupForm.this,"Enter your phone",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SignupForm.this,"Enter your password",Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(SignupForm.this,"Enter your password",Toast.LENGTH_SHORT).show();


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupForm.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupForm.this,"Sucessfully Registered",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    //FirebaseUser user = mAuth.getCurrentUser();
                                    //updateUI(user);






                                } else {

                                    Toast.makeText(SignupForm.this,"registration failed",Toast.LENGTH_SHORT).show();


                                }

                                // ...
                            }
                        });





            }
        });



    }

    private void updateUI(FirebaseUser user) {

    }
}

/*
final String fname=t_fullname.getText().toString().trim();
                final String uname=t_user.getText().toString().trim();
                final String email=t_email.getText().toString().trim();
                final String phone=t_phone.getText().toString().trim();
                String pass=t_password.getText().toString().trim();


                t_fullname= (EditText)findViewById(R.id.fullname);
        t_user=(EditText)findViewById(R.id.user);
        t_email=(EditText)findViewById(R.id.email);
        t_password=(EditText)findViewById(R.id.password);
        t_phone=(EditText)findViewById(R.id.phone);
        btn_register=(Button)findViewById(R.id.register);
        rmale=(RadioButton)findViewById(R.id.male);
        rfemale=(RadioButton)findViewById(R.id.female);
 */




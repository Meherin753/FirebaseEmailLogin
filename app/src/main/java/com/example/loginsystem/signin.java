package com.example.loginsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    FirebaseAuth fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        final EditText ed1= findViewById(R.id.editTextEmail);
        final EditText ed2 = findViewById(R.id.editTextpassword);
        Button but = findViewById(R.id.login);
        fire = FirebaseAuth.getInstance();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed1.getText().toString();
                String password = ed2.getText().toString();
               fire.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {

                       if(task.isSuccessful())
                       {
                          Toast.makeText(signin.this,"SignIn Successfull",Toast.LENGTH_LONG).show();
                          startActivity(new Intent(signin.this,homepage.class));
                       }

                       else
                       {
                           Toast.makeText(signin.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                       }

                   }
               });



            }
        });
    }
}
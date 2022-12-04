package com.example.restaurante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_fire extends AppCompatActivity {
    Button btnlogin;
    EditText email, contras;
    FirebaseAuth  mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fire);
        mAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.correo);
        contras=findViewById(R.id.contraseña);
        btnlogin=findViewById(R.id.btningresar);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = email.getText().toString().trim();
                String passUser = contras.getText().toString().trim();

                if(emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(login_fire.this, "Ingrese sus datos", Toast.LENGTH_SHORT).show();

                }else{
                    loginUser(emailUser, passUser);
                }
            }
        });{
            Toast.makeText(login_fire.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private void loginUser(String emailUser, String passUser){
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 finish();
                 startActivity(new Intent(login_fire.this, crearUsuario.class));
                 Toast.makeText(login_fire.this, "Bievenido", Toast.LENGTH_SHORT).show();
             }

        //}).addOnFailureListener(new OnFailureListener() {
           // @Override
           // public void onFailure(@NonNull Exception e) {
               // Toast.makeText(login_fire.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class crearUsuario extends AppCompatActivity {
EditText ednombre, edapellido, edcorreo, edcontraseña;
Button btnRegistrar;

private String nameUser= "";
private String apUser = "";
private String correoUser = "";
private String passUser ="";
FirebaseAuth mAuth;
DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        ednombre=findViewById(R.id.ednombre);
        edapellido=findViewById(R.id.edapellido);
        edcorreo=findViewById(R.id.edcorreo);
        edcontraseña=findViewById(R.id.edcontraseña);
        btnRegistrar=findViewById(R.id.btnRegistrar);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameUser=ednombre.getText().toString();
                apUser=edapellido.getText().toString();
                correoUser=edcorreo.getText().toString();
                passUser=edcontraseña.getText().toString();

                if (nameUser.isEmpty() && apUser.isEmpty() && correoUser.isEmpty() && passUser.isEmpty()) {
                    if (passUser.length() >= 6) {
                        registrarUsuario();
                    }
                    else {
                        Toast.makeText(crearUsuario.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(crearUsuario.this, "Complete los datos", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void registrarUsuario(){
        mAuth.createUserWithEmailAndPassword(correoUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map= new HashMap<>();
                    map.put("nombre", nameUser);
                    map.put("apellido", apUser);
                    map.put("correo", correoUser);
                    map.put("password", passUser);
                    String id=mAuth.getCurrentUser().getUid();
                    mDatabase.child("users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                Toast.makeText(crearUsuario.this, "Registrado con exito", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(crearUsuario.this, login_fire.class));
                            }else{
                                Toast.makeText(crearUsuario.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{ Toast.makeText(crearUsuario.this, "No se pudo crear los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}



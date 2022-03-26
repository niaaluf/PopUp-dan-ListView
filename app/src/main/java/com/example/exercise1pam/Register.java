package com.example.exercise1pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    
    TextInputEditText rgNama, rgemail, rgpass, rgrepass;
    
    Button btnreg;
    
    String nama, email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        rgNama = findViewById(R.id.regnama);
        rgemail = findViewById(R.id.regemail);
        rgpass = findViewById(R.id.regpass);
        rgrepass = findViewById(R.id.regrepass);
        
        btnreg = findViewById(R.id.regregis);
        
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                nama = rgNama.getText().toString();
                email = rgemail.getText().toString();
                password = rgpass.getText().toString();
                repassword = rgrepass.getText().toString();
                
                if(nama.length()==0){
                    rgNama.setError("Nama Harus Diisi");

                    Toast.makeText(getApplicationContext(), "Data Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if(email.length()==0){
                    rgemail.setError("Email Harus Diisi");

                    Toast.makeText(getApplicationContext(), "Data Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()||repassword.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(repassword)){
                        Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                        
                        Bundle j = new Bundle();
                        
                        j.putString("nama",nama.trim());

                        Intent a = new Intent(getApplicationContext(),Task1.class);
                        a.putExtras(j);
                        startActivity(a);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password harus sama!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
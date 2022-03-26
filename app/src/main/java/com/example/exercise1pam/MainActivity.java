package com.example.exercise1pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView regis;

    TextInputEditText TxNama, TxPass;

    Button BtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxNama = findViewById(R.id.mainNama);
        TxPass = findViewById(R.id.mainPass);

        BtnSignIn = findViewById(R.id.mainSignin);

        regis = findViewById(R.id.mainreg);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent N = new Intent(getApplicationContext(), Register.class);
                startActivity(N);

            }
        });

        BtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TxNama.getText().toString().length()==0){
                    TxNama.setError("Username Tidak Boleh Kosong!");
                    Toast.makeText(getApplicationContext(), "Data Harus Diisi!", Toast.LENGTH_SHORT).show();
                }
                else if(TxPass.getText().toString().length()==0){
                    TxPass.setError("Password Tidak Boleh Kosong");
                    Toast.makeText(getApplicationContext(), "Data Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if(TxNama.getText().toString().equals("Nia")&& TxPass.getText().toString().equals("12345")){
                    Toast.makeText(getApplicationContext(), "Login Berhasil !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
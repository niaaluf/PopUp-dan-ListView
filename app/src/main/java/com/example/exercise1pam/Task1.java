package com.example.exercise1pam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Task1 extends AppCompatActivity {
    EditText TskNama, TskJenis, TskLama;

    TextView tskKamu;

    FloatingActionButton btnAct;

    String stNama, stTask, stJenis, stLama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        TskNama = findViewById(R.id.TaskNama);
        TskJenis = findViewById(R.id.TaskJenis);
        TskLama = findViewById(R.id.TaskTime);

        btnAct = findViewById(R.id.btnFloat);

        tskKamu = findViewById(R.id.kamu);

        Bundle datareg = getIntent().getExtras();

        stNama = datareg.getString("nama");

        tskKamu.setText(stNama);

        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stTask = TskNama.getText().toString();
                stJenis = TskJenis.getText().toString();
                stLama = TskLama.getText().toString();

                if(stJenis.length()==0){
                    TskJenis.setError("Jenis Task!");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
                }
                else if(stLama.length()==0){
                    TskLama.setError("Jenis Task!");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
                }
                else if(stTask.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle dataTask = new Bundle();

                    dataTask.putString("task", stTask.trim());
                    dataTask.putString("jenis", stJenis.trim());
                    dataTask.putString("lama",stLama.trim());

                    Intent hasil = new Intent(getApplicationContext(),TaskHasil.class);

                    hasil.putExtras(dataTask);
                    startActivity(hasil);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.Add){

            TskNama = findViewById(R.id.TaskNama);
            TskJenis = findViewById(R.id.TaskJenis);
            TskLama = findViewById(R.id.TaskTime);

            stTask = TskNama.getText().toString();
            stJenis = TskJenis.getText().toString();
            stLama = TskLama.getText().toString();

            if(stJenis.length()==0){
                TskJenis.setError("Jenis Task!");
                Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
            }
            else if(stLama.length()==0){
                TskLama.setError("Jenis Task!");
                Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
            }
            else if(stTask.isEmpty()){
                Toast.makeText(getApplicationContext(), "Isi Semua Data!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                Bundle dataTask = new Bundle();

                dataTask.putString("task", stTask.trim());
                dataTask.putString("jenis", stJenis.trim());
                dataTask.putString("lama",stLama.trim());

                Intent hasil = new Intent(getApplicationContext(),TaskHasil.class);

                hasil.putExtras(dataTask);
                startActivity(hasil);
            }
        }
        else {
            Intent hasilakhir = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(hasilakhir);
        }
        return super.onOptionsItemSelected(item);
    }
}
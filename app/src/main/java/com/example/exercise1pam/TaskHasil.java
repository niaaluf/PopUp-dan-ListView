package com.example.exercise1pam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TaskHasil extends AppCompatActivity {

    TextView tskkamu, tskjenis, tsktime;

    String srTask, srJenis, srTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_hasil);

        tskkamu = findViewById(R.id.taskkamu);
        tskjenis = findViewById(R.id.taskJenisKamu);
        tsktime = findViewById(R.id.tasktimekamu);

        Bundle akhir = getIntent().getExtras();

        srTask = akhir.getString("task");
        srJenis = akhir.getString("jenis");
        srTime = akhir.getString("lama");

        tskkamu.setText(srTask);
        tskjenis.setText(srJenis);
        tsktime.setText(srTime);
    }
}
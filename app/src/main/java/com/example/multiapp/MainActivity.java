package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMegaSena = findViewById(R.id.btnMegaSena);
        Button btnImc = findViewById(R.id.btnImc);
        Button btnJokenpo = findViewById(R.id.btnJokenpo);
        Button btnFelicidade = findViewById(R.id.btnFelicidade);

        btnMegaSena.setOnClickListener(v -> startActivity(new Intent(this, com.example.multiapp.MegasenaActivity.class)));
        btnImc.setOnClickListener(v -> startActivity(new Intent(this, ImcActivity.class)));
        btnJokenpo.setOnClickListener(v -> startActivity(new Intent(this, JokenpoActivity.class)));
        btnFelicidade.setOnClickListener(v -> startActivity(new Intent(this, QuestionarioActivity.class)));
    }
}
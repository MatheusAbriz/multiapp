package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionarioActivity extends AppCompatActivity {

    private RadioGroup rgSono, rgEstresse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionario);

        rgSono = findViewById(R.id.rgSono);
        rgEstresse = findViewById(R.id.rgEstresse);
        Button btnCalcular = findViewById(R.id.btnCalcularFelicidade);
        Button btnVoltar = findViewById(R.id.btnVoltarQuestionario);

        btnVoltar.setOnClickListener(v -> finish()); // Retorna ao Menu Principal

        btnCalcular.setOnClickListener(v -> {
            if (rgSono.getCheckedRadioButtonId() == -1 || rgEstresse.getCheckedRadioButtonId() == -1) {
                Toast. makeText(this, "Por favor, responda todas as perguntas.", Toast.LENGTH_SHORT).show();
                return;
            }

            double s = 0;
            int idSono = rgSono.getCheckedRadioButtonId();
            if (idSono == R.id.rbSono1) s = 1.0;
            else if (idSono == R.id.rbSono2) s = 3.0;
            else if (idSono == R.id.rbSono3) s = 2.0;

            double e = 0;
            int idEstresse = rgEstresse.getCheckedRadioButtonId();
            if (idEstresse == R.id.rbEstresse1) e = 3.0;
            else if (idEstresse == R.id.rbEstresse2) e = 2.0;
            else if (idEstresse == R.id.rbEstresse3) e = 1.0;

            // Cálculo: Felicidade = [(S + E)/6] * 10
            double felicidade = ((s + e) / 6.0) * 10.0;

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("PONTUACAO_FELICIDADE", felicidade);
            startActivity(intent);
            // Ao chamar a tela de resultado, fechamos esta para que o botão voltar de lá vá direto ao Menu
            finish();
        });
    }
}
package com.example.multiapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.multiapp.R;

import java.util.Random;

public class MegasenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megasena);

        // Botão para voltar ao Menu Principal
        Button btnVoltar = findViewById(R.id.btnVoltarMegaSena);
        if (btnVoltar != null) {
            btnVoltar.setOnClickListener(v -> finish());
        }
    }

    @SuppressLint("SetTextI18n")
    public void sorteioNumero(View view) {
        TextView resultado = findViewById(R.id.textResultado);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);
        TextView tv6 = findViewById(R.id.tv6);

        Random random = new Random();
        tv1.setText(String.valueOf(random.nextInt(60) + 1));
        tv2.setText(String.valueOf(random.nextInt(60) + 1));
        tv3.setText(String.valueOf(random.nextInt(60) + 1));
        tv4.setText(String.valueOf(random.nextInt(60) + 1));
        tv5.setText(String.valueOf(random.nextInt(60) + 1));
        tv6.setText(String.valueOf(random.nextInt(60) + 1));

        resultado.setText("Números sorteados!");
    }

    public void limpaNumeros(View view) {
        TextView resultado = findViewById(R.id.textResultado);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);
        TextView tv6 = findViewById(R.id.tv6);

        tv1.setText("-"); tv2.setText("-"); tv3.setText("-");
        tv4.setText("-"); tv5.setText("-"); tv6.setText("-");
        resultado.setText("Resultado");
    }
}
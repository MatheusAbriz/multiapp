package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView txtPontuacao = findViewById(R.id.txtPontuacao);
        TextView txtClassificacao = findViewById(R.id.txtClassificacao);
        Button btnVoltarMenu = findViewById(R.id.btnVoltarMenu);

        // Recupera o valor passado pela Intent
        double pontuacao = getIntent().getDoubleExtra("PONTUACAO_FELICIDADE", 0.0);

        // Formata para 1 casa decimal
        txtPontuacao.setText(String.format("Pontuação: %.1f", pontuacao));

        // Lógica da Tabela de Classificação
        String classificacao;
        if (pontuacao <= 2.0) {
            classificacao = "Muito Baixa (Alerta crítico)";
        } else if (pontuacao <= 4.0) {
            classificacao = "Baixa (Equilíbrio precário)";
        } else if (pontuacao <= 6.0) {
            classificacao = "Moderada (Estado neutro)";
        } else if (pontuacao <= 8.0) {
            classificacao = "Alta (Bom equilíbrio)";
        } else {
            classificacao = "Plena (Estado ideal)";
        }

        txtClassificacao.setText(classificacao);

        // Como finalizamos a QuestionarioActivity antes de vir pra cá,
        // o finish() aqui vai revelar a MainActivity automaticamente.
        btnVoltarMenu.setOnClickListener(v -> finish());
    }
}
package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class ImcResultadoActivity extends AppCompatActivity {

    TextView nome, peso, altura, imc, classificacao, mensagem;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Aqui ele "puxa" o segundo XML que você mandou
        setContentView(R.layout.activity_imc_resultado);

        nome = findViewById(R.id.txtNome);
        peso = findViewById(R.id.txtPeso);
        altura = findViewById(R.id.txtAltura);
        imc = findViewById(R.id.txtIMC);
        classificacao = findViewById(R.id.txtClassificacao);
        mensagem = findViewById(R.id.txtMensagem);
        voltar = findViewById(R.id.btnVoltar);

        Intent dados = getIntent();

        String n = dados.getStringExtra("nome");
        double p = dados.getDoubleExtra("peso",0);
        double a = dados.getDoubleExtra("altura",0);
        double i = dados.getDoubleExtra("imc",0);

        nome.setText("Nome: " + n);
        peso.setText("Peso: " + p);
        altura.setText("Altura: " + a);
        imc.setText("IMC: " + String.format("%.2f", i));

        String classif;
        String msg;

        if(i < 18.5){
            classif = "Abaixo do peso";
            msg = "Você pode melhorar sua alimentação!";
        }
        else if(i < 25){
            classif = "Peso Normal";
            msg = "Parabéns! Continue assim!";
        }
        else if(i < 30){
            classif = "Sobrepeso";
            msg = "Atenção com a saúde!";
        }
        else{
            classif = "Obesidade";
            msg = "Procure hábitos mais saudáveis!";
        }

        classificacao.setText("Classificação: " + classif);
        mensagem.setText(msg);

        // Quando clicar em voltar, fecha o Resultado e volta para a tela de Entrada do IMC
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
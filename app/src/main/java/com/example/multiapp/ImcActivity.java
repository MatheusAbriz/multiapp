package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImcActivity extends AppCompatActivity {

    EditText nome, peso, altura;
    Button calcular, limpar, voltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Aqui ele "puxa" o primeiro XML que você mandou
        setContentView(R.layout.activity_imc);

        nome = findViewById(R.id.editNome);
        peso = findViewById(R.id.editPeso);
        altura = findViewById(R.id.editAltura);

        calcular = findViewById(R.id.btnCalcular);
        limpar = findViewById(R.id.btnLimpar);
        voltarMenu = findViewById(R.id.btnVoltarMenuImc);

        // Voltar ao Menu Principal
        voltarMenu.setOnClickListener(v -> finish());

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Prevenção de erro caso o usuário não digite nada
                if(peso.getText().toString().isEmpty() || altura.getText().toString().isEmpty()) {
                    Toast.makeText(ImcActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String n = nome.getText().toString();
                double p = Double.parseDouble(peso.getText().toString());
                double a = Double.parseDouble(altura.getText().toString());

                double imc = p / (a * a);

                // Vai chamar a segunda tela do IMC
                Intent tela2 = new Intent(ImcActivity.this, ImcResultadoActivity.class);

                tela2.putExtra("nome", n);
                tela2.putExtra("peso", p);
                tela2.putExtra("altura", a);
                tela2.putExtra("imc", imc);

                startActivity(tela2);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                peso.setText("");
                altura.setText("");
            }
        });
    }
}
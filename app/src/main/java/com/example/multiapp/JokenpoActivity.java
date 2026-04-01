package com.example.multiapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    private TextView textPlacar, textResultado;
    private ImageView imageEscolhaPc;
    private ImageButton btnPedra, btnPapel, btnTesoura;
    private Button btnReiniciar, btnVoltarMenu;

    // Variáveis de Lógica
    private int pontosPC = 0;
    private int pontosYou = 0;
    private boolean partidaFinalizada = false;
    private final int PONTOS_PARA_VENCER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        textPlacar = findViewById(R.id.textPlacar);
        textResultado = findViewById(R.id.textResultado);
        imageEscolhaPc = findViewById(R.id.imageEscolhaPc);

        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnReiniciar = findViewById(R.id.btnReiniciar);

        // Adicione um botão no XML do Jokenpo para voltar
        btnVoltarMenu = findViewById(R.id.btnVoltarJokenpo);
        if(btnVoltarMenu != null) btnVoltarMenu.setOnClickListener(v -> finish());

        btnPedra.setOnClickListener(view -> jogar("Pedra"));
        btnPapel.setOnClickListener(view -> jogar("Papel"));
        btnTesoura.setOnClickListener(view -> jogar("Tesoura"));

        btnReiniciar.setOnClickListener(view -> reiniciarPartida());
    }

    private void jogar(String escolhaUsuario) {
        if (partidaFinalizada) return;

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3); // 0, 1 ou 2
        String escolhaPc = opcoes[numeroAleatorio];

        switch (escolhaPc) {
            case "Pedra":
                imageEscolhaPc.setImageResource(R.drawable.pedra); // Garanta que essas imagens estão na pasta drawable do novo projeto
                break;
            case "Papel":
                imageEscolhaPc.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageEscolhaPc.setImageResource(R.drawable.tesoura);
                break;
        }

        verificarVencedorRodada(escolhaUsuario, escolhaPc);
        atualizarPlacar();
        verificarFimDeJogo();
    }

    private void verificarVencedorRodada(String usuario, String pc) {
        if (usuario.equals(pc)) {
            textResultado.setText("Empate na rodada!");
        } else if (
                (usuario.equals("Pedra") && pc.equals("Tesoura")) ||
                        (usuario.equals("Papel") && pc.equals("Pedra")) ||
                        (usuario.equals("Tesoura") && pc.equals("Papel"))
        ) {
            textResultado.setText("Você venceu a rodada!");
            pontosYou++;
        } else {
            textResultado.setText("PC venceu a rodada!");
            pontosPC++;
        }
    }

    private void atualizarPlacar() {
        textPlacar.setText("PC " + pontosPC + " x " + pontosYou + " Jogador");
    }

    private void verificarFimDeJogo() {
        if (pontosPC == PONTOS_PARA_VENCER) {
            textResultado.setText("FIM DE JOGO!\nO Computador é o GRANDE VENCEDOR!");
            partidaFinalizada = true;
        } else if (pontosYou == PONTOS_PARA_VENCER) {
            textResultado.setText("PARABÉNS!\nVocê é o GRANDE VENCEDOR!");
            partidaFinalizada = true;
        }
    }

    private void reiniciarPartida() {
        pontosPC = 0;
        pontosYou = 0;
        partidaFinalizada = false;

        textPlacar.setText("PC x Jogador");
        imageEscolhaPc.setImageResource(R.drawable.padrao); // Garanta que esta imagem existe
        textResultado.setText("Escolha uma opção para começar!");
    }
}
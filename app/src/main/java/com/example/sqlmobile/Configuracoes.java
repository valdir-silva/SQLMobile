package com.example.sqlmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Configuracoes extends AppCompatActivity {

    EditText nomePlayer1, nomePlayer2, tempoTravado;
    Button btnConfirma;

    Usuario player1 = new Usuario();
    Usuario player2 = new Usuario();
    Controlador controlador = new Controlador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Retira a Action Bar
        setContentView(R.layout.activity_configuracoes);

        nomePlayer1 = findViewById(R.id.nomePlayer1);
        nomePlayer2 = findViewById(R.id.nomePlayer2);
        tempoTravado = findViewById(R.id.tempoTravado);

        btnConfirma = findViewById(R.id.btnConfirma);

        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMultiplayer = new Intent(Configuracoes.this, Multiplayer.class);

                player1.setNome(nomePlayer1.getText().toString());
                player2.setNome(nomePlayer2.getText().toString());
                controlador.setTempoTravado(Integer.parseInt(tempoTravado.getText().toString()));
                Bundle bundle = new Bundle();
                bundle.putParcelable("player1", player1);
                bundle.putParcelable("player2", player2);
                bundle.putParcelable("controlador", controlador);
                abreMultiplayer.putExtras(bundle);

                startActivity(abreMultiplayer);
            }
        });
    }
}

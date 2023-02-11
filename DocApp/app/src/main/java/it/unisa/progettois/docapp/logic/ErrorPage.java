package it.unisa.progettois.docapp.logic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import it.unisa.progettois.docapp.R;

public class ErrorPage extends AppCompatActivity {
    ImageView iconaHome, iconaCarica, iconaChat, iconaProfilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pagina_errore_lista_vuota);

        iconaHome = findViewById(R.id.iconaHome);
        iconaCarica = findViewById(R.id.iconaCarica);
        iconaChat = findViewById(R.id.iconaChat);
        iconaProfilo = findViewById(R.id.iconaProfilo);

        iconaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(intent);
            }
        });

        iconaCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CaricaDocumentoActivity.class);
                startActivity(intent);
            }
        });

        iconaChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(intent);
            }
        });

        iconaProfilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfiloActivity.class);
                startActivity(intent);
            }
        });
    }
}

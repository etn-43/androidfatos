package com.codecademy.fatosesquecidosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatos);
    }



    public void registroFatos(View v){

        //recuperar fato
        TextView causaFato = findViewById(R.id.nomeFatos);
        String outro = causaFato.getText().toString();

        AdicionarLista addFato = new AdicionarLista(outro);
        ListaFatos.novaLista.add(addFato);

        Toast.makeText(this, "Fato  "+outro+" registrado!", Toast.LENGTH_SHORT).show();

    }

    public void irListaFatos(View v){

        startActivity(new Intent(this, ListaFatos.class));
    }


}
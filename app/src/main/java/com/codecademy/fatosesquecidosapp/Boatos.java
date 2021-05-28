package com.codecademy.fatosesquecidosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Boatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boatos);
        gravarBoato(null);
    }

    static int contarTotal;
    static int contarBruxos = 1;
    static int contarTrouxas = 1;


    public void registrarBoatos(View v){
        Spinner spinner = findViewById(R.id.spinnerBoatos);
        Object obj = spinner.getSelectedItem();
        String escolha = obj.toString();

        if (escolha.equals("Bruxos")){

            Toast.makeText(this, ""+contarBruxos+" Boato(os) registrado(os) do (os) "+escolha, Toast.LENGTH_SHORT).show();

            contarBruxos++;
        } else {
            Toast.makeText(this, ""+contarTrouxas+" Boato(os) registrado(os) do(os) "+escolha, Toast.LENGTH_SHORT).show();

            contarTrouxas++;
        }
        contarTotal = contarBruxos + contarTrouxas;
        
    }
    public static final String KEY_NOME = "nome";
    public static final String KEY_DATA = "data";
    public static final String KEY_BOATO = "boato";
    public static final String KEY_TROUXAS = "trouxas";

    public void gravarBoato(View v){
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String nomeP = sp.getString(KEY_NOME, "");
        String dataP = sp.getString(KEY_DATA, "");
        String boatoP = sp.getString(KEY_BOATO, "");
        String trouxasP = sp.getString(KEY_TROUXAS, "");

        EditText nome = findViewById(R.id.Nome);
        EditText data = findViewById(R.id.Data);
        EditText boato = findViewById(R.id.Boato);
        EditText trouxas = findViewById(R.id.Trouxas);

        nome.setText(nomeP);
        data.setText(dataP);
        boato.setText(boatoP);
        trouxas.setText(trouxasP);

    }

    public void salvar(View v) {
        EditText nome = findViewById(R.id.Nome);
        EditText data = findViewById(R.id.Data);
        EditText boato = findViewById(R.id.Boato);
        EditText trouxas = findViewById(R.id.Trouxas);

        String nomeP = nome.getText().toString();
        String dataP = data.getText().toString();
        String boatoP = boato.getText().toString();
        String trouxasP = trouxas.getText().toString();


        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_NOME, nomeP);
        editor.putString(KEY_DATA, dataP);
        editor.putString(KEY_BOATO, boatoP);
        editor.putString(KEY_TROUXAS, trouxasP);
        editor.commit();
    }
}

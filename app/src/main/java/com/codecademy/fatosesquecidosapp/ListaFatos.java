package com.codecademy.fatosesquecidosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaFatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_fatos);
        SppinerOrrganiza();

    }

    static ArrayList<AdicionarLista> novaLista = new ArrayList<>();

    public void SppinerOrrganiza(){
/*
        ArrayAdapter<AdicionarLista> adapter = new ArrayAdapter<AdicionarLista>(this,
                R.layout.support_simple_spinner_dropdown_item, novaLista);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinnerListaFatos);
        spinner.setAdapter(adapter);*/

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_checked, novaLista);

        ListView listView = findViewById(R.id.listaMulFatos);
        listView.setAdapter(adapter);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);

    }

    public void mostrarSelecionados(View v) {
        ListView listView = findViewById(R.id.listaMulFatos);

        SparseBooleanArray checar = listView.getCheckedItemPositions();
        String selecaoFatos = "";
        for (int i = 0; i < checar.size(); i++) {
            int position = checar.keyAt(i);

            if (checar.valueAt(i)) {
                Object getAdaptador = listView.getAdapter().getItem(position);
                selecaoFatos += getAdaptador +", ";
            }
        }
        TextView exibicao = findViewById(R.id.exibicaoFatos);
        exibicao.setText(selecaoFatos);
    }

    public void removeLista(View v){


        ListView listView = findViewById(R.id.listaMulFatos);
        SparseBooleanArray checar = listView.getCheckedItemPositions();

        for (int i = 0; i < checar.size(); i++) {
            int position = checar.keyAt(i);
            if (checar.valueAt(i)) {
                Object obj = listView.getAdapter().getItem(position);
                ListaFatos.novaLista.remove(obj);
            }
        }
        startActivity(new Intent(this,Fatos.class));
        Toast.makeText(this, "Fato removido com sucesso!", Toast.LENGTH_SHORT).show();
    }
    public void voltarMain(View v){
        startActivity(new Intent(this,MainActivity.class));
    }
}
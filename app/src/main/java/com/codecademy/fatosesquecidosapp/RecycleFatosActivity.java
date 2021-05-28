package com.codecademy.fatosesquecidosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecycleFatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_fatos);
        recycleFatos();
    }


    public void recycleFatos(){
        RecyclerView recyclerViewLista = findViewById(R.id.fatosListaRecycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerViewLista.setAdapter(new AdapterFatos());

    }

}
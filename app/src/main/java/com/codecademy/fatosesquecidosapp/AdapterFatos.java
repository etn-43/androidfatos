package com.codecademy.fatosesquecidosapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterFatos extends RecyclerView.Adapter<AdapterFatos.FatosViewHolder> {

    public class FatosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFato;
        public FatosViewHolder(@NonNull View view) {
            super(view);
            textViewFato = view.findViewById(R.id.textViewFato);
        }
    }
    
    @NonNull
    @Override
    public FatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ricycle_lista_fatos, parent, false);
        FatosViewHolder vh = new FatosViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FatosViewHolder holder, int position) {
        Recycler lista = Listafixa.getInstance().getTotal().get(position);
        holder.textViewFato.setText(lista.fatos);
    }

    @Override
    public int getItemCount() {
        return Listafixa.getInstance().getTotal().size();
    }

}

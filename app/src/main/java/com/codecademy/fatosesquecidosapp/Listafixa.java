package com.codecademy.fatosesquecidosapp;

import java.util.ArrayList;
import java.util.List;

public class Listafixa {

    List<Recycler> listaFixa = new ArrayList<>();

    public Listafixa() {
        for (int i = 0; i < 100; i++){

            listaFixa.add(new Recycler("Fatos"+i));
        }

    }

    static Listafixa instance;

    public static Listafixa getInstance() {
        if (instance==null){
            instance = new Listafixa();
        }
        return instance;
    }
    public List<Recycler> getTotal(){
        return listaFixa;
    }
}

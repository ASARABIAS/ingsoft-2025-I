package org.example.open_close;

import org.example.open_close.Factura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenciaFactura {
    private static List<Factura> lista = new ArrayList();
    private static Map<Integer, Factura> mapa = new HashMap<>();

    private static void guardarEnLista(Factura f){
        lista.add(f);
    }

    private static void guardarEnMapa(Factura f){
        int n = mapa.size() + 1;
        mapa.put(n, f);
    }

    public static void almacenarFactura(TipoPersistencia tipo, Factura f){
        switch(tipo){
            case tipo.LISTA -> guardarEnLista(f);
            case tipo.MAPA -> guardarEnMapa(f);
        }

    }
}

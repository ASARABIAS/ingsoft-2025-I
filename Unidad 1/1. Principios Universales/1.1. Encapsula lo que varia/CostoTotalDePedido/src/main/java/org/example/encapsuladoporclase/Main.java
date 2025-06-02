package org.example.encapsuladoporclase;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ItemPedido> items=Arrays.asList(new ItemPedido(2000,5), new ItemPedido(5000,3));;
        Pedido pedido = new Pedido("US", items);
        System.out.println("Total Pedido: " + pedido.getTotalPedido());

    }
}
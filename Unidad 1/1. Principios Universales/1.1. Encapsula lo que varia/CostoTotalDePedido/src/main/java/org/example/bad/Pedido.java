package org.example.bad;

import java.util.*;

public class Pedido {
    private List<ItemPedido> listItemPedido;
    private String pais;

    public Pedido() {
        this.listItemPedido = new ArrayList();
    }

    public Pedido(String pais, List<ItemPedido> items) {
        this.listItemPedido=items;
        this.pais = pais;
    }

    public List<ItemPedido> getListItemPedido() {
        return listItemPedido;
    }

    public void setListItemPedido(List<ItemPedido> listItemPedido) {
        this.listItemPedido = listItemPedido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public double getTotalPedido(){

        double total = 0;
        for(ItemPedido i: this.listItemPedido){
           total += i.getTotalItem();
        }

        if(this.pais.equals("US")){
               total += total * 0.07;
        }
        else if(this.pais.equals("EU")){

            total += total * 0.05;

        }
        else if(this.pais.equals("CH")){
            total += total * 0.03;
        }

        return total;

    }


}

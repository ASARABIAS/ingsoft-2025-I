package com.mycompany.catalogozapatos.good;

public class Main {
    public static void main(String[] args) {

        Calzado casual = new Calzado("Calzado casual", new Cordon(), new Tela());
        System.out.println(casual.getDescripcion());
        
    }
}

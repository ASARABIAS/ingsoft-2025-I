package org.example.bad;

public class Main {
    public static void main(String[] args) {

        Compania compania = new Compania(new Arquitecto(), new Tester(), new Programador());
        System.out.println(compania.desarrollarProyecto());
    }
}
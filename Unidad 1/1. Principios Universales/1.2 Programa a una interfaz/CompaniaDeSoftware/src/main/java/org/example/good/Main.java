package org.example.good;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<IEquipoProyecto> equipo = new ArrayList<>();
        equipo.add(new Arquitecto());
        equipo.add(new Tester());
        equipo.add(new Programador());
        Compania compania = new Compania(equipo);
        System.out.println(compania.desarrollarProyecto());
    }
}
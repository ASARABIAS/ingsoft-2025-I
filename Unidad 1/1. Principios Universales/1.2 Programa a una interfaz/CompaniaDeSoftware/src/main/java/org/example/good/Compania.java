package org.example.good;

import org.example.bad.Arquitecto;
import org.example.bad.Programador;
import org.example.bad.Tester;

import java.util.ArrayList;
import java.util.List;

public class Compania {

   private List<IEquipoProyecto> equipo;

    public Compania(List<IEquipoProyecto> equipo) {
        this.equipo = equipo;
    }

    public String desarrollarProyecto(){

       StringBuilder tareasProyecto= new StringBuilder();
        for(IEquipoProyecto e: this.equipo){
           tareasProyecto.append(e.realizarTarea());
           tareasProyecto.append("\n");
        }
       return tareasProyecto.toString();

    }
}

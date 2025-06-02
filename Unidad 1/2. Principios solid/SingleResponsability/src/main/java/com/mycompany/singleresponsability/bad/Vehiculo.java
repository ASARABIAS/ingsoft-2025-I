/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleresponsability.bad;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author JAIRO
 */
public class Vehiculo {
    
    private String matricula;
    private String tipo;
    public static final double TARIFA = 2000;

    public Vehiculo(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public double calcularCostoParqueo(LocalTime ingreso, LocalTime salida){
        long horas = ChronoUnit.HOURS.between(salida, ingreso);
        return  TARIFA * horas;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleresponsability.bad;

import java.time.LocalTime;

/**
 *
 * @author JAIRO
 */
public class Main {
    public static void main(String[] args) {
        
        Vehiculo v = new Vehiculo("ABC", "Automovil");
        System.out.println("Valor Parqueo: " + v.calcularCostoParqueo(LocalTime.now(), LocalTime.now().plusHours(5)));
        
    }
}

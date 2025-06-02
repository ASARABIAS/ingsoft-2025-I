/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Precondiciones.good;



/**
 *
 * @author JAIRO
 */
public class Main {
    
    public static void main(String[] args) {
        
        CuentaLibre cuenta = new CuentaLibre(1000);
        cuenta.retirar(400);
        System.out.println("Saldo: " + cuenta.getSaldo());
        
    }
    
}

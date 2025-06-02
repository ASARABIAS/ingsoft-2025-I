/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Precondiciones.bad;

/**
 *
 * @author JAIRO
 */
public class Main {
    
    public static void main(String[] args) {
        
        CuentaProtegida cuenta = new CuentaProtegida(1000);
        cuenta.retirar(600);
        System.out.println("Saldo: " + cuenta.getSaldo());
        
    }
    
}

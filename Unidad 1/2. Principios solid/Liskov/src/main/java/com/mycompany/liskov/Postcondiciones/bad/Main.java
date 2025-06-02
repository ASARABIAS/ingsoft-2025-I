/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Postcondiciones.bad;

/**
 *
 * @author JAIRO
 */
public class Main {
    
    public static void main(String[] args) {
        
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.depositar(5000);
        cuenta.retirar(500);
        System.out.println("Saldo: " + cuenta.getSaldo());
        
    }
    
}

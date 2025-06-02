/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Precondiciones.good;


/**
 *
 * @author JAIRO
 */
public class CuentaBancaria {
    
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void retirar(double monto){
        
        if(monto<=0 || monto>=500)
            throw new IllegalArgumentException("Monto no permitido");
        
        this.saldo-=monto;
    
    }
    
}

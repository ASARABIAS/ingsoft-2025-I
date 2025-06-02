/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Precondiciones.good;


/**
 *
 * @author JAIRO
 */
public class CuentaLibre extends CuentaBancaria {
    
    public CuentaLibre(double saldo) {
        super(saldo);
    }

    @Override
    public void retirar(double monto) {
        if(monto<=0)
            throw new IllegalArgumentException("Monto no permitido");
        this.setSaldo(this.getSaldo()-monto);
    }
    
    
    
}

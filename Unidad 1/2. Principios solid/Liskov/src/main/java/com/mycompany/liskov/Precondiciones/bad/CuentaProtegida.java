/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liskov.Precondiciones.bad;

/**
 *
 * @author JAIRO
 */
public class CuentaProtegida extends CuentaBancaria {
    
    public CuentaProtegida(double saldo) {
        super(saldo);
    }

    @Override
    public void retirar(double monto) {
        if(monto>=500)
            throw new IllegalArgumentException("monto no permitido");
        
        super.retirar(monto); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

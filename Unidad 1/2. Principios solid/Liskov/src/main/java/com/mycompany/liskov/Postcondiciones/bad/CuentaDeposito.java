/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.liskov.Postcondiciones.bad;


/**
 *
 * @author JAIRO
 */
public class CuentaDeposito extends CuentaBancaria {
    public CuentaDeposito(double saldo) {
        super(saldo);
    }

    public CuentaDeposito() {
    }

    @Override
    public void retirar(double monto) {
        this.setSaldo(this.getSaldo()-0);
    }

    
    
    
    
    
}

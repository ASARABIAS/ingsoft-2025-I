package com.mycompany.liskov.Postcondiciones.good;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo=saldo;
    }

        public CuentaBancaria() {
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto){
        this.saldo+=monto;
    }
}

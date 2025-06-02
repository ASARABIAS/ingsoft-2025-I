package org.example.isp;

public class ParqueaderoPrivado implements IParqueadero {
    private int puestosParqueo;

    public ParqueaderoPrivado(int puestosParqueo) {
        this.puestosParqueo = puestosParqueo;
    }

    public ParqueaderoPrivado() {
        this(10);
    }

    @Override
    public void aparcarCoche() {
        if(this.puestosParqueo==0)
           throw new ExcepcionParqueadero("No hay puestos disponibles");

        this.puestosParqueo--;

    }

    @Override
    public void sacarCoche() {

        this.puestosParqueo++;

    }

    @Override
    public void getCapacidad() {
        System.out.println(this.puestosParqueo + " disponibles");
    }

    @Override
    public void calcularCosto(int minutos) {
        System.out.println("Valor a pagar: " + IParqueadero.TARIFA_POR_MINUTOS*minutos);
    }
}

package org.example.isp;

public class ParqueaderoGratis implements IParqueadero{
    private int puestosParqueo;

    public ParqueaderoGratis(int puestosParqueo) {
        this.puestosParqueo = puestosParqueo;
    }

    public ParqueaderoGratis() {
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
        throw new ExcepcionParqueadero("El parquedero es gratis");
    }
}

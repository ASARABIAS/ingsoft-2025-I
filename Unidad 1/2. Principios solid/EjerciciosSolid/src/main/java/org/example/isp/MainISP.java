package org.example.isp;

public class MainISP {
    public static void main(String[] args) {

        ParqueaderoPrivado privado = new ParqueaderoPrivado(10);
        privado.aparcarCoche();
        privado.getCapacidad();
        privado.sacarCoche();
        privado.calcularCosto(5);

        ParqueaderoGratis gratis = new ParqueaderoGratis(5);
        gratis.aparcarCoche();
        gratis.getCapacidad();
        gratis.sacarCoche();
        gratis.calcularCosto(10);


    }
}

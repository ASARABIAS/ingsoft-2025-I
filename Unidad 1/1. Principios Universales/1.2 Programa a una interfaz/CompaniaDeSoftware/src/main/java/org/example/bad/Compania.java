package org.example.bad;

public class Compania {

    private Arquitecto arquitecto;
    private Tester tester;
    private Programador programador;

    public Compania(Arquitecto arquitecto, Tester tester, Programador programador) {
        this.arquitecto = arquitecto;
        this.tester = tester;
        this.programador = programador;
    }

    public String desarrollarProyecto(){

        return  arquitecto.diseñarArquitectura() +"\n" +
                programador.crearPrograma() + "\n" +
                tester.realizarTest() +  "\n";

    }
}

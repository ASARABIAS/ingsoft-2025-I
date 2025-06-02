package org.example.srp;

import java.util.ArrayList;
import java.util.List;

public class MainSRP {
    public static void main(String[] args) {

        Libro libro = new Libro("patrones de diseño", "GoF", 1995, 100000, "XXX-XX-XX");
        Factura factura = new Factura(libro, 2, 0.2, 0.19);
        List<Factura> archivo = new ArrayList();
        factura.guardarArchivo(archivo);
        factura.imprimeFactura();

    }
}

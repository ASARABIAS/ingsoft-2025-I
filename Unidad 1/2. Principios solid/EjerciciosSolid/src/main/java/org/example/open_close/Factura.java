package org.example.open_close;

import java.util.List;

public class Factura {

    private Libro libro;
    private int cantidad;
    private double tasaDescuento;
    private double tasaImpuesto;
    private double total;

    public Factura(Libro libro, int cantidad, double tasaDescuento, double tasaImpuesto) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.tasaDescuento = tasaDescuento;
        this.tasaImpuesto = tasaImpuesto;
        this.total = this.calculaTotal();
    }

    public double calculaTotal() {
        double precio = ((libro.getPrecio() - libro.getPrecio() * tasaDescuento) * this.cantidad);

        double precioConImpuestos = precio * (1 + tasaImpuesto);

        return precioConImpuestos;
    }

    public void imprimeFactura() {
        System.out.println(cantidad + " x " + libro.getNombre() + " * $" +          libro.getPrecio() );
        System.out.println("Tasa de Descuento: " + tasaDescuento);
        System.out.println("Tasa de Impuesto: " + tasaImpuesto);
        System.out.println("Total: " + total);
    }

    public void guardarArchivo(List<Factura> archivo) {
        archivo.add(this);
    }

}

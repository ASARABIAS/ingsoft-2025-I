package org.example.bad;

public class ItemPedido {
    private double precio;
    private int cantidad;

    public ItemPedido(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalItem(){
        return this.cantidad * this.precio;
    }
}

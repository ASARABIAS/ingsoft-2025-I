package org.example.open_close;

public class Libro {
    private String nombre;
    private String nombreAutor;
    private int anyo;
    private int precio;
    private String isbn;

    public Libro(String nombre, String nombreAutor, int anyo, int precio, String isbn) {
        this.nombre = nombre;
        this.nombreAutor = nombreAutor;
        this.anyo = anyo;
        this.precio = precio;
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}

package org.example.isp;

public interface IParqueadero {
    double TARIFA_POR_MINUTOS = 100;
    void aparcarCoche(); // Reducir el recuento de puntos vacíos en 1
    void sacarCoche(); // Aumenta los espacios vacíos en 1
    void getCapacidad(); // Devuelve la capacidad del coche
    void calcularCosto(int minutos); // Devuelve el precio en función del número de horas.

}

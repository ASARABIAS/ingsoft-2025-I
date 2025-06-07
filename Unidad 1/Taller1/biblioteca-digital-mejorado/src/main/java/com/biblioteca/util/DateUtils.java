package com.biblioteca.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class DateUtils {
    private static final Logger logger = Logger.getLogger(DateUtils.class.getName());

    // VIOLACIÓN SRP: Mezcla formateo, cálculos Y logging
    public static String formatearFecha(LocalDateTime fecha) {
        logger.info("Formateando fecha: " + fecha);
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static long calcularDiasEntre(LocalDateTime inicio, LocalDateTime fin) {
        logger.info("Calculando días entre: " + inicio + " y " + fin);
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    // VIOLACIÓN OCP: Lógica hardcodeada para tipos de usuario
    public static LocalDateTime calcularFechaDevolucion(LocalDateTime fechaPrestamo, String tipoUsuario) {
        logger.info("Calculando fecha devolución para: " + tipoUsuario);

        switch (tipoUsuario) {
            case "ESTUDIANTE":
                return fechaPrestamo.plusDays(15);
            case "PROFESOR":
                return fechaPrestamo.plusDays(30);
            case "ADMINISTRATIVO":
                return fechaPrestamo.plusDays(20);
            default:
                return fechaPrestamo.plusDays(7);
        }
    }

    // VIOLACIÓN SRP: Validación mezclada con utilidades de fecha
    public static boolean esFechaValida(LocalDateTime fecha) {
        boolean valida = fecha != null && fecha.isAfter(LocalDateTime.now().minusYears(1));
        logger.info("Validación de fecha: " + valida);
        return valida;
    }

    // VIOLACIÓN: Lógica de negocio en clase de utilidades
    public static boolean esPrestamoProlongable(LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, LocalDateTime.now());
        logger.info("Días de préstamo actual: " + diasPrestamo);
        return diasPrestamo < 30; // Lógica de negocio hardcodeada
    }
}

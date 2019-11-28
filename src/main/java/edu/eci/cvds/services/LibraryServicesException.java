package edu.eci.cvds.services;

public class LibraryServicesException extends Exception {
    public static final String CAPACIDAD_NEGATIVA="La capacidad no puede ser negativa";
    public static final String RECURSO_RESERVADO_EN_HORA="El recurso ya se encuentra reservado a esa hora";
    public static  final String RESERVA_MAYOR_A_DOS_HORAS="Una reserva no puede ser mayor a dos horas";
    public static final String RESERVA_FUERA_DE_HORA="La reserva no se puede realizar fuera de horario";
    public static final String RESERVA_FUERA_DE_FECHA="La reserva no se puede hacer antes de la fecha actual";

    /**
     * Constructor de la clase LibraryServicesException
     * @param Message String el mensaje del error
     */
    public LibraryServicesException(String Message){
        super(Message);
    }
}

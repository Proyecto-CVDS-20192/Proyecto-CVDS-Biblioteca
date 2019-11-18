package edu.eci.cvds.services;

public class LibraryServicesException extends Exception {
    public static final String CAPACIDAD_NEGATIVA="La capacidad no puede ser negativa";

    /**
     * Constructor de la clase LibraryServicesException
     * @param Message String el mensaje del error
     */
    public LibraryServicesException(String Message){
        super(Message);
    }
}

package edu.eci.cvds.services;

public class LibraryServicesException extends RuntimeException {
    public static final String CAPACIDAD_NEGATIVA="La cantidad de un recurso no puede ser negativa";

    public LibraryServicesException(String message){
        super(message);
    }
}

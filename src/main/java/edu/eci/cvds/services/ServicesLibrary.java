package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;

import java.util.List;


public interface ServicesLibrary {
    /**
     * Consulta todos los recursos
     * @return una lista con todos los recursos
     */
    public List<Recurso> consultarRecursos() throws LibraryServicesException;

    /**
     * Consulta un unico recurso
     * @param id la id interna del recurso
     * @return El recurso consultado
     */
    public Recurso consultarRecurso(int id) throws LibraryServicesException;
}

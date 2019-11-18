package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;

import java.sql.Timestamp;
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

    void reservarRecurso(Recurso recurso, Usuario usuario,Timestamp fechaIni,Timestamp fechaFin) throws LibraryServicesException;

    void reservaRecursorecurrente(Recurso recurso, Usuario usuario, Timestamp fechaIni,Timestamp fechaFin) throws  LibraryServicesException;

    List<Reserva> consultarReservasUsuario(String id) throws LibraryServicesException;

    List<Reserva> consultarReservas() throws LibraryServicesException;

    List<Horario> horariosRecursos() throws LibraryServicesException;

}

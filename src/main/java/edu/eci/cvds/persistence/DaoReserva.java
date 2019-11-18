package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.LibraryServicesException;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface DaoReserva {
    /**
     * Reserva un recurso
     * @param recurso El recurso a reservar
     * @param usuario El usuario que reserva
     * @param fechaIni La fecha de inicio de la reserva
     * @param fechaFin La fecha de final de la reserva
     * @throws LibraryServicesException
     */
    void reservarRecurso(Recurso recurso, Usuario usuario, Timestamp fechaIni, Timestamp fechaFin) throws LibraryServicesException;

    /**
     * Consulta las reservas de un usuario
     * @param id El id del usuario
     * @return Una lista con las reservas del usuario
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservasUsuario(String id) throws LibraryServicesException;

    /**
     * Consulta todas las reservas existentes
     * @return Una lista con todas las reservas existentes
     * @throws LibraryServicesException
     */
    List<Reserva> consultarReservas() throws LibraryServicesException;

    /**
     * Consulta la reserva de un recurso
     * @param recurso El recurso a consultar la reserva
     * @return La reserva de ese recurso
     * @throws LibraryServicesException
     */
    Reserva consultarReservaRecurso(Recurso recurso)throws  LibraryServicesException;

    /**
     * Elimina una reserva
     * @param reserva la reserva a eliminar
     */
    void eliminarReserva(Reserva reserva) throws LibraryServicesException;
}

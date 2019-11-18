package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ReservaMapper {
    /**
     * Reserva un recurso
     * @param recurso El recurso a reservar
     * @param usuario El usuario que realiza la reserva
     * @param fechaIni La fecha de inicio de la reserva
     * @param fechaFin La fecha de finalizacion de la reserva
     */
    void reservarRecurso(@Param("recurso") Recurso recurso, @Param("usuario")Usuario usuario, @Param("fechaIni") Timestamp fechaIni,@Param("fechaFin") Timestamp fechaFin);

    /**
     * Consulta las reservas de un usuario
     * @param id El id del usuario que consulta las reservas
     * @return
     */
    List<Reserva> consultarReservasUsuario(@Param("id") String id);

    /**
     * Consulta todas las reservas activas
     * @return
     */
    List<Reserva> consultarReservas();


    /**
     * Consulta la reserva de un recurso
     * @param recurso El recurso del que se desea consultar la reserva
     * @return
     */
    Reserva consultarReservaRecurso(@Param("recurso") Recurso recurso);

    /**
     * Eliminar una reserva
     * @param reserva La reserva a eliminar
     */
    void eliminarReserva(@Param("reserva") Reserva reserva);
}

package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;

import edu.eci.cvds.persistence.DaoReserva;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;
import java.sql.Timestamp;

public class MyBatisDaoReserva implements DaoReserva {

    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario) throws LibraryServicesException{
        Timestamp fechaIni=new Timestamp(System.currentTimeMillis());
        Timestamp fechaFin=new Timestamp(System.currentTimeMillis());
        try {
            reservaMapper.reservarRecurso(recurso, usuario, fechaIni, fechaFin);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new LibraryServicesException(e.getMessage());
        }
    }
}

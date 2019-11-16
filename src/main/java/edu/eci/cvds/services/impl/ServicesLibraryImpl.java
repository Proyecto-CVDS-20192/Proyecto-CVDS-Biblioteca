package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.DaoHorario;
import edu.eci.cvds.persistence.DaoReserva;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import edu.eci.cvds.persistence.DaoRecurso;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;


public class ServicesLibraryImpl implements ServicesLibrary {
    @Inject
    private DaoRecurso recursoDao;
    @Inject
    private DaoReserva reservaDao;
    //@Inject
    //private DaoHorario horarioDao;

    public List<Recurso> consultarRecursos() throws LibraryServicesException {
        return recursoDao.consultarRecursos();
    }

    @Override
    public Recurso consultarRecurso(int id) throws LibraryServicesException {
        return recursoDao.consultarRecurso(id);
    }

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario) throws LibraryServicesException {
        reservaDao.reservarRecurso(recurso,usuario);
    }

    @Override
    public void reservaRecursorecurrente(Recurso recurso, Usuario usuario, Timestamp fechaIni, Timestamp fechaFin) {
        //Implementar la logica aca con reservaRecurso
    }
    /*
    @Override
    public List<Horario> horariosRecursos() throws LibraryServicesException{
        return horarioDao.horarios();
    }
    */

}

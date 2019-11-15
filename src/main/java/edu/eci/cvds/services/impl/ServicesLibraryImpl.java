package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import edu.eci.cvds.persistence.DaoRecurso;
import javax.inject.Inject;
import java.util.List;


public class ServicesLibraryImpl implements ServicesLibrary {
    @Inject
    private DaoRecurso recursoDao;

    public List<Recurso> consultarRecursos() throws LibraryServicesException {
        return recursoDao.consultarRecursos();
    }

    @Override
    public Recurso consultarRecurso(int id) throws LibraryServicesException {
        return recursoDao.consultarRecurso(id);
    }
}

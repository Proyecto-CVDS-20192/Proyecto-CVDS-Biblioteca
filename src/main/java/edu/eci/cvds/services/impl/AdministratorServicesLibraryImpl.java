package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.ServicesLibraryFactory;

import javax.inject.Inject;

public class AdministratorServicesLibraryImpl implements AdministratorServicesLibrary {

    @Inject
    private DaoRecurso recursoDao;

    @Override
    public void registrarRecurso(Recurso recurso) {
        recursoDao.registraNuevoRecurso(recurso);
    }

    @Override
    public void eliminarUnRecursoPermanente(Recurso recurso) {
        recursoDao.eliminarPermanente(recurso);
    }

    @Override
    public void eliminarUnRecursoTemporal(Recurso recurso) {
        recursoDao.eliminarTemporal(recurso);
    }

    @Override
    public void volverAAdmitirElRecurso(Recurso recurso) {
        recursoDao.volverAAdmitirRecurso(recurso);
    }
}

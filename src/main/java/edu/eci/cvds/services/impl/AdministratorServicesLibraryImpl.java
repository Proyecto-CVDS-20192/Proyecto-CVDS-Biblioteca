package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.persistence.DaoTipoRecurso;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibraryFactory;

import javax.inject.Inject;

public class AdministratorServicesLibraryImpl implements AdministratorServicesLibrary {

    @Inject
    private DaoRecurso recursoDao;
    @Inject
    private DaoTipoRecurso tipoRecursoDao;

    @Override
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException {
        tipoRecursoDao.registrarTipoRecurso(tipoRecurso);
    }

    @Override
    public void registrarRecurso(Recurso recurso) throws LibraryServicesException {
        recursoDao.registraNuevoRecurso(recurso);
    }

    @Override
    public void eliminarUnRecursoPermanente(Recurso recurso) throws LibraryServicesException {
        recursoDao.eliminarPermanente(recurso);
    }

    @Override
    public void eliminarUnRecursoTemporal(Recurso recurso) throws LibraryServicesException {
        recursoDao.eliminarTemporal(recurso);
    }

    @Override
    public void volverAAdmitirElRecurso(Recurso recurso) throws LibraryServicesException {
        recursoDao.volverAAdmitirRecurso(recurso);
    }

}

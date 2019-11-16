package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.LibraryServicesException;

public interface DaoReserva {
    void reservarRecurso(Recurso recurso, Usuario usuario) throws LibraryServicesException;
}

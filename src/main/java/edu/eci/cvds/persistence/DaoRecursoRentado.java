package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;

public interface DaoRecursoRentado {
    void reservarRecurso(Recurso recurso, Usuario usuario);
}

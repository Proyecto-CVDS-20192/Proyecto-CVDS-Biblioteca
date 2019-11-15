package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.DaoRecursoRentado;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoRentadoMapper;

import javax.inject.Inject;

public class MyBatisDaoRecursoRentado implements DaoRecursoRentado {

    @Inject
    private RecursoRentadoMapper recursoRentadoMapper;

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario) {
        //recursoRentadoMapper.reservarRecurso(recurso,usuario);
    }
}

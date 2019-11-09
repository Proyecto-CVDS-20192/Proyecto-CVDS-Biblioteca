package edu.eci.cvds.persistence.mybatisimpl;


import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.persistence.DaoTipoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.TipoRecursoMapper;

import javax.inject.Inject;

public class MyBatisTipoRecurso implements DaoTipoRecurso {

    @Inject
    TipoRecursoMapper tiporecursoMapper;

    @Override
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) {
        try {
            tiporecursoMapper.registrarTipoRecurso(tipoRecurso);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            e.printStackTrace();
        }
    }
}

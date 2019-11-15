package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface ReservaMapper {
    void reservarRecurso(@Param("recurso") Recurso recurso, @Param("usuario")Usuario usuario, @Param("fechaIni") Timestamp fechaIni,@Param("fechaFin") Timestamp fechaFin);
}

package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.DaoUsuario;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.services.LibraryServicesException;

import javax.inject.Inject;

public class MyBatisDaoUsuario implements DaoUsuario {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario consultarUsuario(String username) throws LibraryServicesException {
        return usuarioMapper.consultarUsuario(username);
    }
}
package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;

import java.util.List;

public interface AdministratorServicesLibrary {
    /**
     * Registra un nuevo tipo de recurso
     * @param tipoRecurso el nuevo tipo de recurso
     */
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException;

    /**
     * Regustra un recurso
     * @param recurso el recurso a registrar
     */
    public void registrarRecurso(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina un recurso de forma permanente
     * @param recurso el recurso a eliminar
     */
    public void eliminarUnRecursoPermanente(Recurso recurso) throws LibraryServicesException;

    /**
     * Elimina un recurso de forma temporal
     * @param recurso el recurso
     */
    public void eliminarUnRecursoTemporal(Recurso recurso) throws LibraryServicesException;

    /**
     * Vuelve a admitir un recurso
     * @param recurso el recurso
     */
    public void volverAAdmitirElRecurso(Recurso recurso) throws LibraryServicesException;

    List<Recurso> consultarRecursosAdmin() throws LibraryServicesException;
}

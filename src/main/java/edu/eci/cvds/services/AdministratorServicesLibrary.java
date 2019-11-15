package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;

public interface AdministratorServicesLibrary {
    /**
     * Registra un nuevo tipo de recurso
     * @param tipoRecurso el nuevo tipo de recurso
     */
    public void registrarTipoRecurso(TipoRecurso tipoRecurso);

    /**
     * Regustra un recurso
     * @param recurso el recurso a registrar
     */
    public void registrarRecurso(Recurso recurso);

    /**
     * Elimina un recurso de forma permanente
     * @param recurso el recurso a eliminar
     */
    public void eliminarUnRecursoPermanente(Recurso recurso);

    /**
     * Elimina un recurso de forma temporal
     * @param recurso el recurso
     */
    public void eliminarUnRecursoTemporal(Recurso recurso);

    /**
     * Vuelve a admitir un recurso
     * @param recurso el recurso
     */
    public void volverAAdmitirElRecurso(Recurso recurso);
}

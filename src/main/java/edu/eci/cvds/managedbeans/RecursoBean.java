package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Recurso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

@Named
@Stateless
@ViewScoped
@ManagedBean(name = "recursoBean", eager = true)
public class RecursoBean implements Serializable {

    private static final transient Logger log = LoggerFactory.getLogger(UserBean.class);

    private String nombre;
    private int capacidad;
    private String ubicacion;
    private boolean estado;
    private int id;

    public RecursoBean() {
    }

    public List<Recurso> getRecursos() {
        return null;
    }

    public void reservarRecurso() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

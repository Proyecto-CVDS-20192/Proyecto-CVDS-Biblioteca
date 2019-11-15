package edu.eci.cvds.entities;

import com.google.inject.internal.cglib.proxy.$InvocationHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recurso implements Serializable {
    private String nombre;
    private String ubicacion;
    private TipoRecurso tipoRecurso;
    private int identificadorInterno;
    private Integer capacidad;
    private String estado;
    private List<String> estados;

    /**
     * Constructor de la clase recurso
     * @param identificadorInterno id interno
     * @param nombre nombre
     * @param ubicacion ubicacion
     * @param capacidad capacidad
     * @param estado estado
     * @param idT id del tipoRecurso
     * @param tipo tipo del tipoRecurso
     */
    public Recurso(int identificadorInterno,String nombre,String ubicacion,Integer capacidad,String estado,int idT,String tipo){
        this.nombre=nombre;
        this.identificadorInterno=identificadorInterno;
        this.ubicacion=ubicacion;
        this.capacidad=capacidad;
        this.estado=estado;
        this.tipoRecurso=new TipoRecurso(idT,tipo);
        estados = new ArrayList<String>();
        estados.add("Disponible");
        estados.add("No Disponible");
        estados.add("Mantenimiento");
    }

    /**
     * Constructor de la clase Recurso
     * @param identificadorInterno id interno
     * @param nombre nombre
     * @param ubicacion ubicacion
     * @param capacidad capacidad
     * @param estado estado
     * @param tipo tipo del recurso
     */
    public Recurso(int identificadorInterno,String nombre,String ubicacion,Integer capacidad,String estado,TipoRecurso tipo){
        this.nombre=nombre;
        this.identificadorInterno=identificadorInterno;
        this.ubicacion=ubicacion;
        this.capacidad=capacidad;
        this.estado=estado;
        this.tipoRecurso=tipo;
        estados = new ArrayList<String>();
        estados.add("Disponible");
        estados.add("No Disponible");
        estados.add("Mantenimiento");
    }


    /**
     * Getter de la capacidad
     * @return la capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * Getter del identificado interno
     * @return el identificador interno
     */
    public int getIdentificadorInterno() {
        return identificadorInterno;
    }

    /**
     * Getter del nombre
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de la ubicacion
     * @return la ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Getter del tipo del recurso
     * @return el tipo del recurso
     */
    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    /**
     * Setter de la capacidad
     * @param capacidad la nueva capacidad
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Setter del identificador interno
     * @param identificadorInterno el nuevo identificador interno
     */
    public void setIdentificadorInterno(int identificadorInterno) {
        this.identificadorInterno = identificadorInterno;
    }

    /**
     * Setter del nombre
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter del tipo de recurso
     * @param tipoRecurso el tipo del recurso
     */
    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    /**
     * Setter de la ubicacion
     * @param ubicacion la nueva ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Setter del estado
     * @param estado el nuevo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtenedor del estado
     * @return el estado
     */
    public String getEstado() {
        return estado;
    }

    public List<String> getEstados() {
        return estados;
    }
    public void setEstados(List<String> estados){
        this.estados = estados;
    }
    @Override
    public String toString() {
        try{
            return this.nombre+" "+this.ubicacion+" "+this.identificadorInterno+" "+this.tipoRecurso.toString()+" "+this.capacidad.toString();
        }catch (NullPointerException e) {
            return this.nombre+" "+this.ubicacion+" "+this.identificadorInterno+" "+this.tipoRecurso.toString();
        }
    }
}

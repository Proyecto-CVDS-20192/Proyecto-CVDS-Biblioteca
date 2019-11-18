package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Horario implements Serializable {

    private int id;
    private Recurso recurso;
    private Timestamp horaInicio;
    private Timestamp horaFin;


    public Horario(){super();}

    public Horario(int id,Recurso recurso,Timestamp horaInicio, Timestamp horaFin){
        this.id=id;
        this.recurso=recurso;
        this.horaFin=horaFin;
        this.horaInicio=horaInicio;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return horaInicio.toString()+" "+horaFin.toString();
    }
}

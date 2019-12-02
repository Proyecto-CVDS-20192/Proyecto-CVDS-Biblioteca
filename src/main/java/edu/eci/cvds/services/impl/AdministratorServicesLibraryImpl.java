package edu.eci.cvds.services.impl;

import com.sun.javafx.image.IntPixelGetter;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.persistence.DaoHorario;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.persistence.DaoReserva;
import edu.eci.cvds.persistence.DaoTipoRecurso;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import edu.eci.cvds.services.ServicesLibraryFactory;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class AdministratorServicesLibraryImpl extends ServicesLibraryImpl implements AdministratorServicesLibrary {

    @Inject
    private DaoRecurso recursoDao;
    @Inject
    private DaoTipoRecurso tipoRecursoDao;
    @Inject
    private DaoReserva reservaDao;
    @Inject
    private DaoHorario horarioDao;

    @Override
    public void registrarTipoRecurso(TipoRecurso tipoRecurso) throws LibraryServicesException {
        tipoRecursoDao.registrarTipoRecurso(tipoRecurso);
    }

    @Override
    public void registrarRecurso(Recurso recurso) throws LibraryServicesException {
        recursoDao.registraNuevoRecurso(recurso);
    }

    @Override
    public void eliminarUnRecursoPermanente(Recurso recurso) throws LibraryServicesException {
        recursoDao.eliminarPermanente(recurso);
    }

    @Override
    public void eliminarUnRecursoTemporal(Recurso recurso) throws LibraryServicesException {
        recursoDao.eliminarTemporal(recurso);
    }

    @Override
    public void volverAAdmitirElRecurso(Recurso recurso) throws LibraryServicesException {
        recursoDao.volverAAdmitirRecurso(recurso);
    }

    @Override
    public List<Recurso> consultarRecursosAdmin() throws LibraryServicesException {
        return recursoDao.consultarRecursosAdmin();
    }

    @Override
    public void reservarRecurso(Recurso recurso, Usuario usuario, Timestamp fechaIni,Timestamp fechaFin) throws LibraryServicesException {
        reservaDao.reservarRecurso(recurso,usuario,fechaIni,fechaFin,"Normal");
    }

    @Override
    public void ingresarHorario(Recurso recurso, Horario horario) throws LibraryServicesException {
        horarioDao.ingresarHorario(recurso,horario);
    }

    private Map<Integer,Integer> sortByValue(Map<Integer, Integer> map){
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public Map<Integer,Integer> recursosMasYMenosUsados() throws LibraryServicesException {
        List<Reserva> reservas=reservaDao.consultarReservas();
        HashMap<Integer,Integer> recursos=new HashMap<>();
        Map<Integer,Integer> sortRecursos;
        Map<Integer,Integer> dataRecursos=new HashMap<>();
        for(Reserva i:reservas){
            if(i!=null) {
                if (recursos.containsKey(i.getRecurso().getIdentificadorInterno())) {
                    recursos.put(i.getRecurso().getIdentificadorInterno(), recursos.get(i.getRecurso().getIdentificadorInterno()) + 1);
                } else {
                    recursos.put(i.getRecurso().getIdentificadorInterno(), 1);
                }
            }
        }
        sortRecursos= sortByValue(recursos);
        int size=sortRecursos.size();
        int cont=0;
        for(Integer i:sortRecursos.keySet()){
            if(cont<4 || (cont<size && cont>size-5)){
                dataRecursos.put(i,sortRecursos.get(i));
            }
            cont+=1;
        }
        dataRecursos=sortByValue(dataRecursos);
        return dataRecursos;
    }

    private boolean in(Time taken,Time reservaTime){
        if(taken.getHours()<=reservaTime.getHours() && taken.getHours()+1>=reservaTime.getHours()){
            return true;
        }
        return false;
    }

    private Time calculeHora(Reserva reserva) {
        Time horaInicioReserva=new Time(reserva.getFechaInicio().getTime());
        Time ans=null;
        HashMap<Time,Time> tiempos=new HashMap<>();
        tiempos.put(Time.valueOf("07:00:00"),Time.valueOf("08:30:00"));
        tiempos.put(Time.valueOf("08:30:00"),Time.valueOf("10:00:00"));
        tiempos.put(Time.valueOf("10:00:00"),Time.valueOf("11:30:00"));
        tiempos.put(Time.valueOf("11:30:00"),Time.valueOf("13:00:00"));
        tiempos.put(Time.valueOf("13:00:00"),Time.valueOf("14:30:00"));
        tiempos.put(Time.valueOf("14:30:00"),Time.valueOf("16:00:00"));
        tiempos.put(Time.valueOf("16:00:00"),Time.valueOf("17:30:00"));
        tiempos.put(Time.valueOf("17:30:00"),Time.valueOf("19:00:00"));
        Set<Time> values=tiempos.keySet();
        for(Time i:values){
            if(in(i,horaInicioReserva)){
                ans=i;
                break;
            }
        }
        return ans;
    }

    @Override
    public HashMap<Time, Integer> horasMasYMenosSolicitadas() throws LibraryServicesException {
        List<Reserva> reservas=reservaDao.consultarReservas();
        HashMap<Time,Integer> horasMasSolicitadas=new HashMap<>();
        horasMasSolicitadas.put(Time.valueOf("07:00:00"),0);
        horasMasSolicitadas.put(Time.valueOf("08:30:00"),0);
        horasMasSolicitadas.put(Time.valueOf("10:00:00"),0);
        horasMasSolicitadas.put(Time.valueOf("11:30:00"),0);
        horasMasSolicitadas.put(Time.valueOf("13:00:00"),0);
        horasMasSolicitadas.put(Time.valueOf("14:30:00"),0);
        horasMasSolicitadas.put(Time.valueOf("16:00:00"),0);
        horasMasSolicitadas.put(Time.valueOf("17:30:00"),0);
        for(Reserva i:reservas){
            if(i!=null){
                Time time=this.calculeHora(i);
                horasMasSolicitadas.put(time,horasMasSolicitadas.get(time)+1);
            }
        }
        return horasMasSolicitadas;
    }

    public static void main(String[] args) throws LibraryServicesException {
        AdministratorServicesLibrary a= ServicesLibraryFactory.getInstance().getAdministratorServices();
        Map<Time,Integer> a1=a.horasMasYMenosSolicitadas();
        System.out.println(a1);
    }

}

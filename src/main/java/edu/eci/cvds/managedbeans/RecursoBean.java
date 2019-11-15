package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean extends BasePageBean{

    private static final transient Logger log = LoggerFactory.getLogger(UserBean.class);

    @Inject
    private ServicesLibrary servicesL;
    
    private Recurso recurso;
    
    public List<Recurso> getRecursos() throws LibraryServicesException {
        return servicesL.consultarRecursos();
    }
    
    public List<String> getEstados(){
        return recurso.getEstados();
    }
    
    public void editarEstadoRecurso(){
    }
    
    public void registrarRecurso(String nombre, int capacidad){
        Recurso recurso;
        int id = servicesL.consultarRecursos().size()+1;
        try {
            recurso = new Recurso(id,nombre,"Biblioteca",capacidad,"Disponible",1,"PC");
            servicesL.registrarRecurso(recurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.AdministratorServicesLibrary;
import edu.eci.cvds.services.LibraryServicesException;
import edu.eci.cvds.services.ServicesLibrary;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean extends BasePageBean {

    private static final transient Logger log = LoggerFactory.getLogger(UserBean.class);

    @Inject
    private ServicesLibrary servicesL;

    @Inject
    private AdministratorServicesLibrary servicesA;

    private Recurso recurso;

    public List<Recurso> getRecursosAdmin() throws LibraryServicesException {
        return servicesA.consultarRecursosAdmin();
    }

    public List<Recurso> getRecursos() throws LibraryServicesException {
        return servicesL.consultarRecursos();
    }

    public void reservarRecurso(int id) {

    }

    public List<String> getEstados() {
        return recurso.getEstados();
    }

    public void editarEstadoRecurso() {
    }

    public void registrarRecurso(String nombre, int capacidad) throws LibraryServicesException {
        Recurso recurso;
        int id = servicesA.consultarRecursosAdmin().size() + 1;
        try {
            recurso = new Recurso(id, 1, nombre, "Biblioteca", capacidad, "Disponible", 1, "PC");
            servicesA.registrarRecurso(recurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarRecurso(int id) {
        try {
            servicesA.eliminarUnRecursoPermanente(servicesL.consultarRecurso(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadAdmin() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin/pages/cambiarEstadoRecurso.xhtml");
    }
    
    public void reloadUser() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/regular/pages/consultarRecursos.xhtml");
    }

}

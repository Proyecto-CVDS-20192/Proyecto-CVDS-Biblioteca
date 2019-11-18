package edu.eci.cvds.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.TipoRecurso;
import edu.eci.cvds.services.*;
import org.junit.Before;
import org.junit.Test;


public class LibraryServicesTest{

    @Inject
    AdministratorServicesLibrary administratorServices;
    @Inject
    ServicesLibrary servicesLibrary;
    private Recurso recurso=new Recurso("El PC","Central",new TipoRecurso(1,"Computador"),"Disponible",500,null);

    @Before
    public void setUp(){}

    public LibraryServicesTest(){
        administratorServices=ServicesLibraryFactory.getInstance().testAdminServicesLibrary();
        servicesLibrary=ServicesLibraryFactory.getInstance().testServicesLibrary();
    }

    @Test
    public void LaQueEstaObligadaAPasar(){
        boolean ans=true;
    }


    @Test
    public void deberiaConsultarTodosLosRecursos() throws LibraryServicesException {
        assertTrue(servicesLibrary.consultarRecursos() instanceof List);
    }

    @Test
    public void deberiaConsultarTodosLosRecursosComoAdmin() throws LibraryServicesException{
        assertTrue(administratorServices.consultarRecursosAdmin() instanceof List);
    }


    @Test
    public void deberiaEliminareIngresarRecurso() throws LibraryServicesException {
        administratorServices.eliminarUnRecursoPermanente(recurso);
        int length=servicesLibrary.consultarRecursos().size();
        administratorServices.registrarRecurso(recurso);
        assertTrue(servicesLibrary.consultarRecursos().size()>length);
    }

    /*
    @Test
    public void deberiaConsultarUnRecurso() throws LibraryServicesException {
        assertTrue(servicesLibrary.consultarRecurso(500).getNombre().equals("El PC"));
    }
*/
    /*
    @Test
    public void deberiaSacarUnRecursoDeFormaTemporalyDevolverlo() throws LibraryServicesException {
        administratorServices.eliminarUnRecursoTemporal(recurso);
        assertFalse(servicesLibrary.consultarRecurso(500).getEstado().equals("Mantenimiento"));
        administratorServices.volverAAdmitirElRecurso(recurso);
        assertTrue(servicesLibrary.consultarRecurso(500).getEstado().equals("Disponible"));
    }
    */
    @Test
    public void NoDebePermitirUnaCapacidadNegativa(){
        try {
            Recurso recurso=new Recurso("El PC","Central",new TipoRecurso(1,"Computador"),"Disponible",500,-50);
            administratorServices.registrarRecurso(recurso);
            assertTrue(false);
        }catch(LibraryServicesException e){ }
    }

    @Test
    public void debePermitirUnaCapacidadPositiva(){
        try{
            Recurso recurso=new Recurso("El PC","Central",new TipoRecurso(1,"Computador"),"Disponible",500,50);
            administratorServices.eliminarUnRecursoPermanente(recurso);
            administratorServices.registrarRecurso(recurso);
        }catch (LibraryServicesException e){
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
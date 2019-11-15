package edu.eci.cvds.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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

    @Before
    public void setUp(){}

    public LibraryServicesTest(){
        administratorServices=ServicesLibraryFactory.getInstance().getAdministratorServices();
        servicesLibrary=ServicesLibraryFactory.getInstance().getServicesLibrary();
    }

    @Test
    public void LaQueEstaObligadaAPasar(){
        boolean ans=true;
    }


    @Test
    public void deberiaConsultarTodosLosRecursos() throws LibraryServicesException{
        assertTrue(servicesLibrary.consultarRecursos() instanceof List);
    }


    @Test
    public void deberiaEliminareIngresarRecurso() throws LibraryServicesException{
        Recurso recurso=new Recurso(500,"LaCosa","Central",null,"Disponible",new TipoRecurso(1,"Computador"));
        administratorServices.eliminarUnRecursoPermanente(recurso);
        int length=servicesLibrary.consultarRecursos().size();
        administratorServices.registrarRecurso(recurso);
        assertTrue(servicesLibrary.consultarRecursos().size()>length);
    }


    @Test
    public void deberiaConsultarUnRecurso() throws LibraryServicesException{
        assertTrue(servicesLibrary.consultarRecurso(500).getNombre().equals("LaCosa"));
    }


    /*@Test
    public void deberiaSacarUnRecursoDeFormaTemporal() throws LibraryServicesException{
        Recurso recurso=new Recurso(500,"LaCosa","Central",null,"Disponible",new TipoRecurso(1,"Computador"));
        administratorServices.eliminarUnRecursoTemporal(recurso);
        assertFalse(servicesLibrary.consultarRecurso(500).getEstado());
    }


    @Test
    public void deberiaVolverUnRecurso() throws LibraryServicesException{
        Recurso recurso=new Recurso(500,"LaCosa","Central",null,"Disponible",new TipoRecurso(1,"Computador"));
        administratorServices.volverAAdmitirElRecurso(recurso);
        assertTrue(servicesLibrary.consultarRecurso(500).getEstado());
    }*/

    @Test
    public void NoDebePermitirUnaCapacidadNegativa(){
        try {
            Recurso recurso = new Recurso(500, "LaCosa", "Central", -50, "Disponible", new TipoRecurso(1, "Computador"));
            administratorServices.registrarRecurso(recurso);
            assertTrue(false);
        }catch(LibraryServicesException e){ }
    }

    @Test
    public void debePermitirUnaCapacidadPositiva(){
        try{
            Recurso recurso = new Recurso(600, "LaCosa", "Central", 50, "Disponible", new TipoRecurso(1, "Computador"));
            administratorServices.eliminarUnRecursoPermanente(recurso);
            administratorServices.registrarRecurso(recurso);
        }catch (LibraryServicesException e){
            assertTrue(false);
        }
    }

}
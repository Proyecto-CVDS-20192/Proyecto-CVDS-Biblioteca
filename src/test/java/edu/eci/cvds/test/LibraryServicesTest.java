package edu.eci.cvds.test;

import static org.junit.Assert.assertTrue;
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
    public void deberiaConsultarLosClientes(){
        servicesLibrary.consultarRecursos();
    }

    /*@Test
    public void deberiaIngresarRecurso(){
        Recurso recurso=new Recurso("p","library",new TipoRecurso(1,"Computador"),true,"abcd",0);
        administratorServices.registrarRecurso(recurso);
    }

    @Test
    public void deberiaSacarUnRecurso(){
        Recurso recurso=new Recurso("p","library",new TipoRecurso(1,"Computador"),true,"abcd",0);
        administratorServices.eliminarUnRecursoTemporal(recurso);
    }

    @Test
    public void deberiaVolverUnRecurso(){
        Recurso recurso=new Recurso("p","library",new TipoRecurso(1,"Computador"),true,"abcd",0);
        administratorServices.volverAAdmitirElRecurso(recurso);
    }

    @Test
    public void deberiaEliminarUnRecurso(){
        Recurso recurso=new Recurso("p","library",new TipoRecurso(1,"Computador"),true,"abcd",0);
        administratorServices.eliminarUnRecursoPermanente(recurso);
    }*/

}
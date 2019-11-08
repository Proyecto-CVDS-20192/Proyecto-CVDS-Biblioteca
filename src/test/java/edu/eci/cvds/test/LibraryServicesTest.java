package edu.eci.cvds.test;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import com.google.inject.Inject;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.impl.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.sql.Date;

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
    public void deberiaConsultarLosClientes(){
        servicesLibrary.consultarRecursos();
    }

}
package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.persistence.DaoRecursoRentado;
import edu.eci.cvds.persistence.DaoTipoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisDaoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisDaoRecursoRentado;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisTipoRecurso;
import edu.eci.cvds.services.impl.AdministratorServicesLibraryImpl;
import edu.eci.cvds.services.impl.ServicesLibraryImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServicesLibraryFactory {

    private static ServicesLibraryFactory instance=new ServicesLibraryFactory();

    private static Injector injector;

    /**
     * Fabrica de los servicios
     */
    private ServicesLibraryFactory(){
        injector=createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServicesLibrary.class).to(ServicesLibraryImpl.class);
                bind(AdministratorServicesLibrary.class).to(AdministratorServicesLibraryImpl.class);
                bind(DaoRecurso.class).to(MyBatisDaoRecurso.class);
                bind(DaoRecursoRentado.class).to(MyBatisDaoRecursoRentado.class);
                bind(DaoTipoRecurso.class).to(MyBatisTipoRecurso.class);
            }
        });
    }

    /**
     * Get de los servicios de administrador
     * @return AdministratorServices
     */
    public AdministratorServicesLibrary getAdministratorServices(){
        return injector.getInstance(AdministratorServicesLibrary.class);
    }

    /**
     * Get de los serivicios de usuario
     * @return ServicesLibrary
     */
    public ServicesLibrary getServicesLibrary(){
        return injector.getInstance(ServicesLibrary.class);
    }

    /**
     * Get de la instancia de la fabrica
     * @return la fabrica
     */
    public static ServicesLibraryFactory getInstance(){
        return instance;
    }
}

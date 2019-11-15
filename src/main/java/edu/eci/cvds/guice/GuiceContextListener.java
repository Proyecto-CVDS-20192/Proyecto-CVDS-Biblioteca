package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.DaoRecurso;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisDaoRecurso;
import edu.eci.cvds.services.ServicesLibrary;
import edu.eci.cvds.services.impl.ServicesLibraryImpl;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {

                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // Laboratories
                bind(ServicesLibrary.class).to(ServicesLibraryImpl.class);
                bind(DaoRecurso.class).to(MyBatisDaoRecurso.class);
            }
        }
        );

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}

package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.DaoMultimedia;
import edu.eci.cvds.persistence.DaoStudyRoom;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisDaoComputer;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisDaoMultimedia;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisStudyRoom;
import edu.eci.cvds.persistence.mybatisimpl.mappers.DaoComputer;
import edu.eci.cvds.services.impl.ServicesLibraryImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServicesLibraryFactory {

    private static ServicesLibraryFactory instance=new ServicesLibraryFactory();

    private static Injector injector;
    private ServicesLibraryFactory(){
        injector=createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){
                install(JdbcHelper.MySQL); //Revisar si es en postSQl
                setClassPathResource("mybatis-config.xml");
                bind(ServicesLibrary.class).to(ServicesLibraryImpl.class);
                bind(DaoComputer.class).to(MyBatisDaoComputer.class);
                bind(DaoMultimedia.class).to(MyBatisDaoMultimedia.class);
                bind(DaoStudyRoom.class).to(MyBatisStudyRoom.class);
            }
        });
    }

    public static ServicesLibraryFactory getInstance(){
        return instance;
    }
}

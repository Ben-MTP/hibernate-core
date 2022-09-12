package edu.fa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author ManhKM on 9/12/2022
 * @project hibernate-fpt
 * -----
 * Áp dụng Singleton để đảm bảo tại một thời điểm chỉ tạo ra một SessionFactory mà thôi
 */
public class ConnectionUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("hibernates.cfg.xml");  //loading file hibernate.cfg.xml

            ServiceRegistry registry = new StandardServiceRegistryBuilder()     // sử dụng ServiceRegistry để load configuration
                .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(registry);
        }
        return sessionFactory;
    }
}

package fr.norsys.util;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration config =  new Configuration().configure("hibernate.cfg.xml");
            //config.setProperty("hibernate.current_session_context_class","thread");

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

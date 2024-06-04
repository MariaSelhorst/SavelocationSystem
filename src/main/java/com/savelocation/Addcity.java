package main.java.com.savelocation;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


import com.savelocation.model.City;

public class Addcity {
    private static SessionFactory sessionFactory;
    
    static {
        try{
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.configure("hibernate.cfg.xml");//
            System.out.println("Configuração do Hibernate carregada com sucesso.");
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e){
            System.err.println("Erro ao inicializar o Hibernate:");
            e.printStackTrace();
        }
    }

    public void insertCity(City city){
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.openSession();//
            transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

}
package fr.norsys.dao;

import fr.norsys.entity.Departement;
import fr.norsys.entity.Employe;
import fr.norsys.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class EmployeDao {
    static Session session=null;


        public static void deleteEmploye(Employe employe){

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(employe);
            session.getTransaction().commit();
        }
        public static Employe getEmploye(int id){
            try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Employe employe= session.get(Employe.class,id);
            session.getTransaction().commit();
            return employe;
        } catch (HibernateException e) {
        if (session.getTransaction()!=null) session.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

            return null;
        }

        public List<Employe> employeList(int idDepartement){
            try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Departement departement=DepartementDao.getDepartement(idDepartement);
            String hql = "FROM Employe E WHERE E.departement= :departement";
            Query query = session.createQuery(hql);
            query.setParameter("departement",departement);
            List results = query.list();
            session.getTransaction().commit();

            return results;
        } catch (HibernateException e) {
        if (session.getTransaction()!=null) session.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

            return null;
        }

        public void nvEmployeDepartemet(int idDepartemet,Employe employe) {

            try {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();

                Departement departement = session.get(Departement.class, idDepartemet);
                if (departement == null) {
                    throw new IllegalArgumentException("departement avec ID " + idDepartemet + " non trouvé");
                }

                employe.setDepartement(departement);
                session.save(employe);

                session.getTransaction().commit();
            } catch (HibernateException e) {
                if (session.getTransaction()!=null) session.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }



}

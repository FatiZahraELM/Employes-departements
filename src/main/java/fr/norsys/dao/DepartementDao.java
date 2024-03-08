package fr.norsys.dao;

import fr.norsys.entity.Departement;
import fr.norsys.entity.Employe;
import fr.norsys.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartementDao {

        static Session session;
        public static void addDepartement( Departement departement){

             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(departement);
            session.getTransaction().commit();


        }
        public static void updateDepartement(Departement departement){

             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(departement);
            session.getTransaction().commit();
        }
        public static void deleteDepartement(Departement departement){

             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(departement);
            session.getTransaction().commit();
        }
        public static Departement getDepartement(int id){

             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Departement departement= session.get(Departement.class,id);
            session.getTransaction().commit();
            return departement;

        }

        public List<Departement> departementList(int idEmploye) {
            try {
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                Employe employe = EmployeDao.getEmploye(idEmploye);
                int dep = employe.getDepartement().getId();
                String hql = "FROM Departement d WHERE d.id= :dep";
                Query query = session.createQuery(hql);
                query.setParameter("dep", dep);
                List results = query.list();
                session.getTransaction().commit();

                return results;
            } catch (
                    HibernateException e) {
                if (session.getTransaction() != null) session.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }


            return null;
        }}




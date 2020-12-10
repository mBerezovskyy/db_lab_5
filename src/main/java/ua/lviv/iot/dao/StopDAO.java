package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Bus;
import ua.lviv.iot.model.Stop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StopDAO implements GeneralDAO<Stop>{
    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();


    @Override
    public List<Stop> findAll() {
        List<Stop> stops = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            stops = session.createQuery("from Stop").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return stops;
    }

    @Override
    public Stop findOne(Integer id) throws SQLException {
        Stop stop = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            stop = session.get(Stop.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return stop;
    }

    @Override
    public void create(Stop stop) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(stop);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Stop stop) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(stop);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Stop stop = session.get(Stop.class, id);
            if (stop != null) {
                session.delete(stop);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Bus;
import ua.lviv.iot.model.Manufacturer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAO implements GeneralDAO<Bus>{
    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();


    @Override
    public List<Bus> findAll() {
        List<Bus> buses = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            buses = session.createQuery("from Bus").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return buses;
    }

    @Override
    public Bus findOne(Integer id) throws SQLException {
        Bus bus = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            bus = session.get(Bus.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return bus;
    }

    @Override
    public void create(Bus bus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(bus);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Bus bus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(bus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Bus bus = session.get(Bus.class, id);
            if (bus != null) {
                session.delete(bus);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

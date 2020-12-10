package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Bus;
import ua.lviv.iot.model.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements GeneralDAO<Driver>{
    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();


    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            drivers = session.createQuery("from Driver").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    @Override
    public Driver findOne(Integer id) throws SQLException {
        Driver driver = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            driver = session.get(Driver.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public void create(Driver driver) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Driver driver) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(driver);
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

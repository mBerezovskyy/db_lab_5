package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.connection.ConnectionManager;

import ua.lviv.iot.model.Manufacturer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements GeneralDAO<Manufacturer> {
    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();


    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            manufacturers = session.createQuery("from Manufacturer").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    @Override
    public Manufacturer findOne(Integer id) throws SQLException {
        Manufacturer manufacturer = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            manufacturer = session.get(Manufacturer.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    @Override
    public void create(Manufacturer manufacturer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Manufacturer manufacturer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Manufacturer manufacturer = session.get(Manufacturer.class, id);
            if (manufacturer != null) {
                session.delete(manufacturer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

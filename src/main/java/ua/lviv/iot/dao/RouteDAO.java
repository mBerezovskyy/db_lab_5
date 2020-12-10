package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO implements GeneralDAO<Route> {
    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();


    @Override
    public List<Route> findAll() {
        List<Route> routes = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            routes = session.createQuery("from Route").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public Route findOne(Integer id) throws SQLException {
        Route route = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            route = session.get(Route.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public void create(Route route) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Route route) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Route route = session.get(Route.class, id);
            if (route != null) {
                session.delete(route);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

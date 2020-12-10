package ua.lviv.iot.controller;

import ua.lviv.iot.dao.RouteDAO;
import ua.lviv.iot.dao.StopDAO;
import ua.lviv.iot.model.Route;
import ua.lviv.iot.model.Stop;

import java.sql.SQLException;
import java.util.List;

public class RouteController implements GeneralController<Route> {
    RouteDAO dao = new RouteDAO();

    @Override
    public List<Route> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Route findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Route route) throws SQLException {
        dao.create(route);

    }

    @Override
    public void update(Integer id, Route route) throws SQLException {
        dao.update(id, route);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}

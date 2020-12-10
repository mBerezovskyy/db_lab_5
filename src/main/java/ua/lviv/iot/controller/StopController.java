package ua.lviv.iot.controller;

import ua.lviv.iot.dao.BusDAO;
import ua.lviv.iot.dao.StopDAO;
import ua.lviv.iot.model.Bus;
import ua.lviv.iot.model.Stop;

import java.sql.SQLException;
import java.util.List;

public class StopController implements GeneralController<Stop>{

    StopDAO dao = new StopDAO();

    @Override
    public List<Stop> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Stop findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Stop stop) throws SQLException {
        dao.create(stop);

    }

    @Override
    public void update(Integer id, Stop stop) throws SQLException {
        dao.update(id, stop);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}

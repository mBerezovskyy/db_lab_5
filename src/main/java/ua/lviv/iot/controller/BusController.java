package ua.lviv.iot.controller;

import ua.lviv.iot.dao.BusDAO;
import ua.lviv.iot.model.Bus;

import java.sql.SQLException;
import java.util.List;

public class BusController implements GeneralController<Bus>{

    BusDAO dao = new BusDAO();

    @Override
    public List<Bus> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Bus findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Bus bus) throws SQLException {
        dao.create(bus);

    }

    @Override
    public void update(Integer id, Bus bus) throws SQLException {
        dao.update(id, bus);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}

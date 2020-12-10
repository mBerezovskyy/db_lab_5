package ua.lviv.iot.controller;

import ua.lviv.iot.dao.DriverDAO;
import ua.lviv.iot.model.Driver;

import java.sql.SQLException;
import java.util.List;

public class DriverController implements GeneralController<Driver> {
    DriverDAO dao = new DriverDAO();

    @Override
    public List<Driver> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Driver findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Driver driver) throws SQLException {
        dao.create(driver);

    }

    @Override
    public void update(Integer id, Driver driver) throws SQLException {
        dao.update(id, driver);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}

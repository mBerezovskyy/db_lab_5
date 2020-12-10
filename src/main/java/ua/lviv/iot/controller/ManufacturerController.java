package ua.lviv.iot.controller;

import ua.lviv.iot.dao.ManufacturerDAO;
import ua.lviv.iot.model.Manufacturer;

import java.sql.SQLException;
import java.util.List;

public class ManufacturerController implements GeneralController<Manufacturer> {

    ManufacturerDAO dao = new ManufacturerDAO();

    @Override
    public List<Manufacturer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Manufacturer findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }


    @Override
    public void create(Manufacturer manufacturer) throws SQLException {
        dao.create(manufacturer);

    }

    @Override
    public void update(Integer id, Manufacturer manufacturer) throws SQLException {
        dao.update(id, manufacturer);

    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }
}

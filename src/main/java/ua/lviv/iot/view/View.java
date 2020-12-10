package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final ManufacturerController manufacturerController = new ManufacturerController();
    private final BusController busController = new BusController();
    private final DriverController driverController = new DriverController();
    private final StopController stopController = new StopController();
    private final RouteController routeController = new RouteController();

    public View() {
        //CHOOSE
        menu.put("11", this::getAllManufacturers);
        menu.put("12", this::getManufacturerById);
        menu.put("13", this::createManufacturer);
        menu.put("14", this::updateManufacturer);
        menu.put("15", this::deleteManufacturer);

        menu.put("21", this::getAllBusses);
        menu.put("22", this::getBusById);
        menu.put("23", this::createBus);
        menu.put("24", this::updateBus);
        menu.put("25", this::deleteBus);

        menu.put("31", this::getAllDrivers);
        menu.put("32", this::getDriverById);
        menu.put("33", this::createDriver);
        menu.put("34", this::updateDriver);
        menu.put("35", this::deleteDriver);

        menu.put("41", this::getAllStops);
        menu.put("42", this::getStopById);
        menu.put("43", this::createStop);
        menu.put("44", this::updateStop);
        menu.put("45", this::deleteStop);

        menu.put("51", this::getAllRoutes);
        menu.put("52", this::getRouteById);
        menu.put("53", this::createRoute);
        menu.put("54", this::updateRoute);
        menu.put("55", this::deleteRoute);

    }

    ////////////////MANUFACTURERS////////////////

    private void getAllManufacturers() throws SQLException {
        System.out.println("\nAll manufacturers: ");
        System.out.println(manufacturerController.findAll() + "\n");
    }

    private void getManufacturerById() throws SQLException {
        System.out.println("\nInput manufacturer's id: ");
        Integer manufacturer_id = scanner.nextInt();
        System.out.println(manufacturerController.findOne(manufacturer_id) + "\n");
    }

    private Manufacturer getManufacturerData() {
        System.out.println("\nInput manufacturer's name: ");
        String name = scanner.next();

        System.out.println("\nInput manufacturer's phone number: ");
        String phoneNumber = scanner.next();

        System.out.println("\nInput manufacturer's office adress: ");
        String officeAdress = scanner.next();

        return new Manufacturer(name, phoneNumber, officeAdress);
    }

    private void createManufacturer() throws SQLException {
        System.out.println("\nCreating manufacturer: ");
        Manufacturer manufacturer = getManufacturerData();
        manufacturerController.create(manufacturer);
        System.out.println("\nCreated manufacturer: ");
    }

    private void updateManufacturer() throws SQLException {
        System.out.println("\nInput manufacturer's id to update it: ");
        Integer manufacturer_id = scanner.nextInt();
        Manufacturer manufacturer = getManufacturerData();
        manufacturer.setIdManufacturer(manufacturer_id);

        manufacturerController.update(manufacturer.getIdManufacturer(), manufacturer);
        System.out.println("\nUpdated manufacturer with this id ");
    }

    private void deleteManufacturer() throws SQLException {
        System.out.println("\nInput manufacturer's id to delete it: ");
        Integer manufacturer_id = scanner.nextInt();

        manufacturerController.delete(manufacturer_id);
        System.out.println("\nDeleted manufacturer with this id ");

    }


    ////////////////BUSSES////////////////

    private void getAllBusses() throws SQLException {
        System.out.println("\nAll busses: ");
        System.out.println(busController.findAll() + "\n");
    }

    private void getBusById() throws SQLException {
        System.out.println("\nInput busse's id: ");
        Integer bus_id = scanner.nextInt();
        System.out.println(busController.findOne(bus_id) + "\n");
    }


    private Bus getBusData() throws SQLException {
        System.out.println("\nInput busse's number sign: ");
        String numberSign = scanner.next();

        System.out.println("\nInput busse's age: ");
        Integer age = scanner.nextInt();

        System.out.println("\nInput busse's capacity: ");
        Integer capacity = scanner.nextInt();

        System.out.println("\nInput busse's mileadge: ");
        Integer mileadge = scanner.nextInt();

        System.out.println("\nInput manufacturerId: ");
        Integer id = scanner.nextInt();
        Manufacturer manufacturer_id = manufacturerController.findOne(id);

        return new Bus(numberSign, age, capacity, mileadge, manufacturer_id);
    }

    private void createBus() throws SQLException {
        System.out.println("\nCreating bus: ");
        Bus bus = getBusData();
        busController.create(bus);
        System.out.println("\nCreated bus: ");
    }

    private void updateBus() throws SQLException {
        System.out.println("\nInput busse's id to update it: ");
        Integer bus_id = scanner.nextInt();
        Bus bus = getBusData();
        bus.setIdBus(bus_id);

        busController.update(bus.getIdBus(), bus);
        System.out.println("\nUpdated bus with this id ");
    }

    private void deleteBus() throws SQLException {
        System.out.println("\nInput busse's id to delete it: ");
        Integer bus_id = scanner.nextInt();

        busController.delete(bus_id);
        System.out.println("\nDeleted bus with this id ");

    }


    ////////////////DRIVERS////////////////

    private void getAllDrivers() throws SQLException {
        System.out.println("\nAll drivers: ");
        System.out.println(driverController.findAll() + "\n");
    }

    private void getDriverById() throws SQLException {
        System.out.println("\nInput driver's id: ");
        Integer bus_id = scanner.nextInt();
        System.out.println(driverController.findOne(bus_id) + "\n");
    }


    private Driver getDriverData() throws SQLException {
        System.out.println("\nInput driver's name: ");
        String name = scanner.next();

        System.out.println("\nInput driver's surname: ");
        String surname = scanner.next();


        return new Driver(name, surname);
    }

    private void createDriver() throws SQLException {
        System.out.println("\nCreating driver: ");
        Driver driver = getDriverData();
        driverController.create(driver);
        System.out.println("\nCreated driver: ");
    }

    private void updateDriver() throws SQLException {
        System.out.println("\nInput driver's id to update it: ");
        Integer driver_id = scanner.nextInt();
        Driver driver = getDriverData();
        driver.setIdDriver(driver_id);

        driverController.update(driver.getIdDriver(), driver);
        System.out.println("\nUpdated driver with this id ");
    }

    private void deleteDriver() throws SQLException {
        System.out.println("\nInput driver's id to delete it: ");
        Integer driver_id = scanner.nextInt();

        driverController.delete(driver_id);
        System.out.println("\nDeleted driver with this id ");

    }

    ////////////////STOPS////////////////


    private void getAllStops() throws SQLException {
        System.out.println("\nAll stops: ");
        System.out.println(stopController.findAll() + "\n");
    }

    private void getStopById() throws SQLException {
        System.out.println("\nInput stop's id: ");
        Integer bus_id = scanner.nextInt();
        System.out.println(stopController.findOne(bus_id) + "\n");
    }

    private Stop getStopData() throws SQLException {
        System.out.println("\nInput stop's district: ");
        String district = scanner.next();

        System.out.println("\nInput stop's street name: ");
        String streetName = scanner.next();

        System.out.println("\nInput stop's street number: ");
        String streetNumber = scanner.next();


        return new Stop(district, streetName, streetNumber);
    }

    private void createStop() throws SQLException {
        System.out.println("\nCreating stop: ");
        Stop stop = getStopData();
        stopController.create(stop);
        System.out.println("\nCreated stop: ");
    }

    private void updateStop() throws SQLException {
        System.out.println("\nInput stop's id to update it: ");
        Integer stop_id = scanner.nextInt();
        Stop stop = getStopData();
        stop.setIdStop(stop_id);

        stopController.update(stop.getIdStop(), stop);
        System.out.println("\nUpdated stop with this id ");
    }

    private void deleteStop() throws SQLException {
        System.out.println("\nInput stop's id to delete it: ");
        Integer stop_id = scanner.nextInt();

        stopController.delete(stop_id);
        System.out.println("\nDeleted stop with this id ");

    }

////////////////ROUTES////////////////


    private void getAllRoutes() throws SQLException {
        System.out.println("\nAll routes: ");
        System.out.println(routeController.findAll() + "\n");
    }

    private void getRouteById() throws SQLException {
        System.out.println("\nInput route's id: ");
        Integer route_id = scanner.nextInt();
        System.out.println(routeController.findOne(route_id) + "\n");
    }

    private Route getRouteData() throws SQLException {
        System.out.println("\nInput route's total fare: ");
        Integer totalFare = scanner.nextInt();

        System.out.println("\nInput starting stop id: ");
        Integer startingId = scanner.nextInt();

        Stop startingStopId = stopController.findOne(startingId);

        System.out.println("\nInput ending stop id: ");
        Integer endingId = scanner.nextInt();

        Stop endingStopId = stopController.findOne(endingId);


        return new Route(totalFare, startingStopId, endingStopId);
    }

    private void createRoute() throws SQLException {
        System.out.println("\nCreating route: ");
        Route route = getRouteData();
        routeController.create(route);
        System.out.println("\nCreated route: ");
    }

    private void updateRoute() throws SQLException {
        System.out.println("\nInput route's id to update it: ");
        Integer route_id = scanner.nextInt();
        Route route = getRouteData();
        route.setIdRoute(route_id);

        routeController.update(route.getIdRoute(), route);
        System.out.println("\nUpdated route with this id ");
    }

    private void deleteRoute() throws SQLException {
        System.out.println("\nInput route's id to delete it: ");
        Integer route_id = scanner.nextInt();

        routeController.delete(route_id);
        System.out.println("\nDeleted route with this id ");

    }


    public void view() {
        System.out.println("\nInput method key to deal with db:");
        String input;
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
                System.out.println("\nSelect option from menu:");
            } catch (Exception e) {
                System.out.println("No such option");
                System.out.println("\nSelect option from menu:");
            }
        } while (scanner.hasNext());
    }
}
package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Driver {
    private Integer idDriver;
    private String name;
    private String surname;
    private Set<Bus> busses;
    private Set<Route> routes;

    public Driver(Integer idDriver, String name, String surname) {
        this.idDriver = idDriver;
        this.name = name;
        this.surname = surname;
    }

    public Driver(String name, String surname) {
        this(null, name, surname);
    }

    public Driver(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDriver")
    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (idDriver != null ? !idDriver.equals(driver.idDriver) : driver.idDriver != null) return false;
        if (name != null ? !name.equals(driver.name) : driver.name != null) return false;
        if (surname != null ? !surname.equals(driver.surname) : driver.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDriver != null ? idDriver.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name = "driver_has_bus", catalog = "", schema = "fixbus_db_hibernate", joinColumns = @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver", nullable = false), inverseJoinColumns = @JoinColumn(name = "Bus_idBus", referencedColumnName = "idBus", nullable = false))
    public Set<Bus> getBusses() {
        return busses;
    }

    public void setBusses(Set<Bus> busses) {
        this.busses = busses;
    }

    @ManyToMany
    @JoinTable(name = "driver_has_route", catalog = "", schema = "fixbus_db_hibernate", joinColumns = @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver", nullable = false), inverseJoinColumns = @JoinColumn(name = "Route_idRoute", referencedColumnName = "idRoute", nullable = false))
    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "idDriver=" + idDriver +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

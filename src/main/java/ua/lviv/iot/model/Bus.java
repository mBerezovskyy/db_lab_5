package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bus {
    private Integer idBus;
    private String numberSign;
    private Integer age;
    private Integer capacity;
    private Integer mileadge;
    private Manufacturer manufacturerId;
    private Set<Driver> drivers;

    public Bus(Integer idBus, String numberSign, Integer age, Integer capacity, Integer mileadge, Manufacturer manufacturerId) {
        this.idBus = idBus;
        this.numberSign = numberSign;
        this.age = age;
        this.capacity = capacity;
        this.mileadge = mileadge;
        this.manufacturerId = manufacturerId;
    }

    public Bus(String numberSign, Integer age, Integer capacity, Integer mileadge, Manufacturer manufacturerId) {
        this(null, numberSign, age, capacity, mileadge, manufacturerId);
    }

    public Bus(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBus")
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    @Basic
    @Column(name = "numberSign")
    public String getNumberSign() {
        return numberSign;
    }

    public void setNumberSign(String numberSign) {
        this.numberSign = numberSign;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "mileadge")
    public Integer getMileadge() {
        return mileadge;
    }

    public void setMileadge(Integer mileadge) {
        this.mileadge = mileadge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (idBus != null ? !idBus.equals(bus.idBus) : bus.idBus != null) return false;
        if (numberSign != null ? !numberSign.equals(bus.numberSign) : bus.numberSign != null) return false;
        if (age != null ? !age.equals(bus.age) : bus.age != null) return false;
        if (capacity != null ? !capacity.equals(bus.capacity) : bus.capacity != null) return false;
        if (mileadge != null ? !mileadge.equals(bus.mileadge) : bus.mileadge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBus != null ? idBus.hashCode() : 0;
        result = 31 * result + (numberSign != null ? numberSign.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (mileadge != null ? mileadge.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Manufacturer_idManufacturer", referencedColumnName = "idManufacturer", nullable = false)
    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @ManyToMany(mappedBy = "busses")
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "idBus=" + idBus +
                ", numberSign='" + numberSign + '\'' +
                ", age=" + age +
                ", capacity=" + capacity +
                ", mileadge=" + mileadge +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}

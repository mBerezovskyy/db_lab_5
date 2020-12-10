package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
public class Stop {
    private Integer idStop;
    private String district;
    private String streetName;
    private String streetNumber;

    public Stop(Integer idStop, String district, String streetName, String streetNumber) {
        this.idStop = idStop;
        this.district = district;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Stop(String district, String streetName, String streetNumber) {
        this(null, district, streetName, streetName);
    }

    public Stop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStop")
    public Integer getIdStop() {
        return idStop;
    }

    public void setIdStop(Integer idStop) {
        this.idStop = idStop;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "streetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "streetNumber")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop stop = (Stop) o;

        if (idStop != null ? !idStop.equals(stop.idStop) : stop.idStop != null) return false;
        if (district != null ? !district.equals(stop.district) : stop.district != null) return false;
        if (streetName != null ? !streetName.equals(stop.streetName) : stop.streetName != null) return false;
        if (streetNumber != null ? !streetNumber.equals(stop.streetNumber) : stop.streetNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStop != null ? idStop.hashCode() : 0;
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "idStop=" + idStop +
                ", district='" + district + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}

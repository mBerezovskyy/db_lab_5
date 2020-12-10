package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
public class Manufacturer {
    private Integer idManufacturer;
    private String name;
    private String phoneNumber;
    private String officeAdress;

    public Manufacturer(Integer idManufacturer, String name, String phoneNumber, String officeAdress) {
        this.idManufacturer = idManufacturer;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.officeAdress = officeAdress;
    }

    public Manufacturer(String name, String phoneNumber, String officeAdress) {
        this(null, name, phoneNumber, officeAdress);
    }

    public Manufacturer(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idManufacturer")
    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
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
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "officeAdress")
    public String getOfficeAdress() {
        return officeAdress;
    }

    public void setOfficeAdress(String officeAdress) {
        this.officeAdress = officeAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (idManufacturer != null ? !idManufacturer.equals(that.idManufacturer) : that.idManufacturer != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (officeAdress != null ? !officeAdress.equals(that.officeAdress) : that.officeAdress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idManufacturer != null ? idManufacturer.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (officeAdress != null ? officeAdress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufacturer=" + idManufacturer +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", officeAdress='" + officeAdress + '\'' +
                '}';
    }
}

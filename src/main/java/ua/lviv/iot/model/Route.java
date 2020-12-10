package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Route {
    private Integer idRoute;
    private Integer totalFare;
    private Stop startingStopId;
    private Stop endingStopId;
    private Set<Driver> driverss;

    public Route(Integer idRoute, Integer totalFare, Stop startingStopId, Stop endingStopId) {
        this.idRoute = idRoute;
        this.totalFare = totalFare;
        this.startingStopId = startingStopId;
        this.endingStopId = endingStopId;
    }

    public Route(Integer totalFare, Stop startingStopId, Stop endingStopId) {
        this(null, totalFare, startingStopId, endingStopId);
    }

    public Route(){

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRoute")
    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    @Basic
    @Column(name = "totalFare")
    public Integer getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Integer totalFare) {
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (idRoute != null ? !idRoute.equals(route.idRoute) : route.idRoute != null) return false;
        if (totalFare != null ? !totalFare.equals(route.totalFare) : route.totalFare != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoute != null ? idRoute.hashCode() : 0;
        result = 31 * result + (totalFare != null ? totalFare.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "startingStopId", referencedColumnName = "idStop", nullable = false)
    public Stop getStartingStopId() {
        return startingStopId;
    }

    public void setStartingStopId(Stop startingStopId) {
        this.startingStopId = startingStopId;
    }

    @ManyToOne
    @JoinColumn(name = "Stop_idStop1endingStopId", referencedColumnName = "idStop", nullable = false)
    public Stop getEndingStopId() {
        return endingStopId;
    }

    public void setEndingStopId(Stop endingStopId) {
        this.endingStopId = endingStopId;
    }

    @ManyToMany(mappedBy = "routes")
    public Set<Driver> getDriverss() {
        return driverss;
    }

    public void setDriverss(Set<Driver> driverss) {
        this.driverss = driverss;
    }

    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", totalFare=" + totalFare +
                ", startingStopId=" + startingStopId +
                ", endingStopId=" + endingStopId +
                '}';
    }
}

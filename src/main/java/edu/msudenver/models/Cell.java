package edu.msudenver.models;

import javax.persistence.*;

@Entity
@Table(name = "cell")
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer xcoordinate;

    private Integer ycoordinate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getXcoordinate() {
        return xcoordinate;
    }

    public void setXcoordinate(Integer xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public Integer getYcoordinate() {
        return ycoordinate;
    }

    public void setYcoordinate(Integer ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}

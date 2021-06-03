package com.studies.application.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CAR_BRAND")
public class CarBrand {
    @GeneratedValue
    @Id
    Long id;

    @Column
    String name;

    @Column
    @OneToMany(mappedBy = "carBrand")
    List<Car> cars;

    public CarBrand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

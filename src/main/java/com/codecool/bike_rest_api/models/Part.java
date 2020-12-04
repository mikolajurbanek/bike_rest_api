package com.codecool.bike_rest_api.models;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name="bike_parts")
public class Part {


    @Id
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String type;
    private Float price;
    private Float weight;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}

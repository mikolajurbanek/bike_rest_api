package com.codecool.bike_rest_api.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="basket")
public class Basket {

    @Id
    private Long id;
    private Long bikePartId;
    private int quantity;
}

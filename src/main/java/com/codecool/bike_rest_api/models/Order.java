package com.codecool.bike_rest_api.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {

    @Id
    private Long id;
    private Long userId;
    private Date date;
    private Time time;
    private Long paymentId;
    private Long basketId;

}

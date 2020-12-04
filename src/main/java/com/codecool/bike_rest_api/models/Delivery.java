package com.codecool.bike_rest_api.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name="delivery")
public class Delivery {

    @Id
    private Long id;
    private Long orderId;
    private Long statusId;
    private Date date;
    private Time time;

}

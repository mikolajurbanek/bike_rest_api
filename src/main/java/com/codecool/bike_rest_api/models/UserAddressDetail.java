package com.codecool.bike_rest_api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="user_address_details")
public class UserAddressDetail {

    @Id
    private Long id;
    private Long userId;
    private String country;
    private String zipcode;
    private String town;
    private String street;
    private int streetNumber;
    private int flatNumber;
    private String firstName;
    private String surname;
}

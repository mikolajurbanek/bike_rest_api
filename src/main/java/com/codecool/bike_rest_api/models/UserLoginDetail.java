package com.codecool.bike_rest_api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="user_login_details")
public class UserLoginDetail {

    @Id
    private Long id;

    private String email;
    private String password;


}

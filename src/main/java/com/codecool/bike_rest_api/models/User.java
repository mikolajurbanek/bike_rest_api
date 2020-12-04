package com.codecool.bike_rest_api.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    private Long id;
    private Long loginDetailsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserLoginDetail emailDetails;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "id", referencedColumnName = "id") })
    private List<Role> role;
}

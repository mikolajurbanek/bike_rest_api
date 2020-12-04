package com.codecool.bike_rest_api.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.lang.reflect.Member;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="roles")
@RequiredArgsConstructor
public class Role {

    @Id
    private Long id;
    private Long user_id;
    private String role;

    @ManyToMany(mappedBy = "role")
    private List<User> users;

    public Role(String role) {
        this.role = role;
    }


}

package com.codecool.bike_rest_api.repositories;

import com.codecool.bike_rest_api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
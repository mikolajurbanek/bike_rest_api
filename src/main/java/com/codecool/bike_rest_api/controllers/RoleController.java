package com.codecool.bike_rest_api.controllers;

import com.codecool.bike_rest_api.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @RequestMapping(value="/user")
    public String user(){
        return "User";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "Admin";
    }



}

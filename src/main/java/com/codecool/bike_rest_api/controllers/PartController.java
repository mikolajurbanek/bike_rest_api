package com.codecool.bike_rest_api.controllers;


import com.codecool.bike_rest_api.models.Part;
import com.codecool.bike_rest_api.repositories.PartRepository;
import com.codecool.bike_rest_api.services.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PartController {


    private final PartService partService;

    @GetMapping("/parts")
    public List<Part> getParts(){
        return partService.getParts();
    }

    @GetMapping("/parts/{id}")
    public Part getOnePart(@PathVariable Long id) {
        return partService.getOnePart(id);
    }


}

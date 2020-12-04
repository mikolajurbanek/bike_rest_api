package com.codecool.bike_rest_api.services;

import com.codecool.bike_rest_api.models.Part;
import com.codecool.bike_rest_api.repositories.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {



    private final PartRepository partRepository;


    public List<Part> getParts(){
        return partRepository.findAll();
    }


    public Part getOnePart(Long id) {
        return partRepository.findById(id).orElseThrow();
    }

    public void removePart(Long id){
        partRepository.deleteById(id);
    }


}

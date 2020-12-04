package com.codecool.bike_rest_api.services;

import com.codecool.bike_rest_api.models.UserLoginDetail;
import com.codecool.bike_rest_api.repositories.LoginRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    ObjectMapper objectMapper = new ObjectMapper();

    private final LoginRepository loginRepository;

    public List<UserLoginDetail> getAllLoginDetails() {
        return loginRepository.findAll();
    }

    public UserLoginDetail getLoginDetailsById(Long id) {
        return loginRepository.findById(id).orElseThrow();
    }

    public String isItCorrectLoginPass(String login, String password) throws IOException {
        List<UserLoginDetail> jsonList = loginRepository.findAll();
        Iterator iterator = jsonList.iterator();
        while (iterator.hasNext()) {
            UserLoginDetail uld = (UserLoginDetail) iterator.next();
            if(uld.getEmail().equals(login)){
                if(uld.getPassword().equals(password)){
                    return "welcome";
                }
                else{
                    return "try another password";
                }
            }

        }return "no such user";

    }
}

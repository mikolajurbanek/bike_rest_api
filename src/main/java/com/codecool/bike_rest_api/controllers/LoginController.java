package com.codecool.bike_rest_api.controllers;


import com.codecool.bike_rest_api.models.User;
import com.codecool.bike_rest_api.models.UserLoginDetail;
import com.codecool.bike_rest_api.services.LoginService;
import com.codecool.bike_rest_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {


    private final LoginService loginService;


    UserService memberService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/login")
    public String registerMember(@Valid User user){
        memberService.createUser(user);
        return "register";
    }

//    @GetMapping("/logins")
//    public List<UserLoginDetail> getlogins(){
//        return loginService.getAllLoginDetails();
//    }

//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String tryLog(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String userName = request.getParameter("uname");
//        String password = request.getParameter("psw");
//
//        System.out.println(loginService.isItCorrectLoginPass(userName, password));
//        if(loginService.isItCorrectLoginPass(userName, password).equals("welcome")){
//            response.addCookie(new Cookie("user", userName));
//        }
//        return userName + password;}





}


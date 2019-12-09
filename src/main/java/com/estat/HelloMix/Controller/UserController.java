package com.estat.HelloMix.Controller;

import com.estat.HelloMix.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;
}

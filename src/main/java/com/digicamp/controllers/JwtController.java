package com.digicamp.controllers;

import com.digicamp.entity.JwtRequest;
import com.digicamp.entity.JwtResponse;
import com.digicamp.service.JwtService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest.getUserPassword()+"|"+jwtRequest.getUserId());
        return jwtService.createJwtToken(jwtRequest);
    }
}

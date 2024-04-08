package com.example.blogapplication.controller;

import com.example.blogapplication.dtos.JWTAuthResponse;
import com.example.blogapplication.dtos.LoginDto;
import com.example.blogapplication.dtos.RegisterDto;
import com.example.blogapplication.service.AuthServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthServiceInterface authServiceInterface;

    public AuthController(AuthServiceInterface authServiceInterface) {
        this.authServiceInterface = authServiceInterface;
    }

    //build login rest api
    //@PostMapping("/login")
    @PostMapping(value = {"/login", "/signin"})  //this is how we can have multiple endpoints for the same method. with "value" attribute
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) { //changed the return type from String to jwtAuthResponse
//        String response = authService.login(loginDto);
//        return ResponseEntity.ok(response);
//        return ResponseEntity.ok(authService.login(loginDto));

        String token = authServiceInterface.login(loginDto);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    //build register rest api
   // @PostMapping("/register")
    @PostMapping(value = {"/register", "/signup"})  //this is how we can have multiple endpoints for the same method. with "value" attribute
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authServiceInterface.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}

package com.example.blogapplication.service;

import com.example.blogapplication.dtos.LoginDto;
import com.example.blogapplication.dtos.RegisterDto;

public interface AuthServiceInterface {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}

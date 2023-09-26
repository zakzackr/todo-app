package com.zakzackr.todomanagement.service;

import com.zakzackr.todomanagement.dto.JwtAuthResponse;
import com.zakzackr.todomanagement.dto.LoginDto;
import com.zakzackr.todomanagement.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    JwtAuthResponse login(LoginDto loginDto);
}

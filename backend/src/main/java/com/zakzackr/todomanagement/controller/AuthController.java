package com.zakzackr.todomanagement.controller;

import com.zakzackr.todomanagement.dto.JwtAuthResponse;
import com.zakzackr.todomanagement.dto.LoginDto;
import com.zakzackr.todomanagement.dto.RegisterDto;
import com.zakzackr.todomanagement.service.AuthService;
import com.zakzackr.todomanagement.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;
    private EmailSenderService senderService;


    // build register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);

        senderService.sendEmail(
                registerDto.getEmail(),
				"Register Confirmation Email",
				"Welcome to Todo App!!");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // build login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);

//        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
//        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
}

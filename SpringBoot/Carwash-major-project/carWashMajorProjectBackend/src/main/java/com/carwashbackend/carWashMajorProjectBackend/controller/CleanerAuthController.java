package com.carwashbackend.carWashMajorProjectBackend.controller;


import com.carwashbackend.carWashMajorProjectBackend.config.CustomAuthenticationManager;
import com.carwashbackend.carWashMajorProjectBackend.dto.JwtRequest;
import com.carwashbackend.carWashMajorProjectBackend.dto.JwtResponse;
import com.carwashbackend.carWashMajorProjectBackend.security.JwtHelper;
import com.carwashbackend.carWashMajorProjectBackend.service.CleanerAuthService;
import com.carwashbackend.carWashMajorProjectBackend.service.CleanerDetailServiceImp;
import com.carwashbackend.carWashMajorProjectBackend.service.ClientDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class CleanerAuthController {


//    @Autowired
//    private AuthenticationManager authenticationManager;
//

    @Autowired
    private CleanerAuthService cleanerAuthService;

    @PostMapping("/login/cleaner")
    @CrossOrigin(origins = "*")
    public ResponseEntity<JwtResponse> cleanerLogin(@RequestBody JwtRequest request) {
        return this.cleanerAuthService.login(request);
    }

    @GetMapping("/cleaner/hello-world")
    @CrossOrigin(origins = "*")
    public String cleanerLogin() {
        return "Hello ji";
    }
}

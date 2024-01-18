package com.vueapi.springboot.cruddemo.rest;

import com.vueapi.springboot.cruddemo.security.dto.AuthenticationRequest;
import com.vueapi.springboot.cruddemo.security.dto.AuthenticationResponse;
import com.vueapi.springboot.cruddemo.security.utils.JwtToken;
import com.vueapi.springboot.cruddemo.security.utils.JwtTokenProvider;
import com.vueapi.springboot.cruddemo.service.EggBoilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService detService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private EggBoilerService theEggService;



    @GetMapping("/throw")
    public ResponseEntity<?> throwException(){

            throw new RuntimeException("Some exception for testing only");


        //return ResponseEntity.ok("test");
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){

        theEggService.boilEgs();

        return ResponseEntity.ok("boiled");
    }

    @GetMapping("/exception")
    public ResponseEntity<?> givMeAnException(){

        throw new RuntimeException("My exception is beautiful!");

        //return ResponseEntity.ok("boiled");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @RequestBody AuthenticationRequest authenticationRequest) {
//        System.out.println("Test");
//        System.out.println(authenticationRequest.getUsername());
//        System.out.println(authenticationRequest.getPassword());

//        System.out.println("===============================");
//        System.out.println(detService.loadUserByUsername(authenticationRequest.getUsername()));
//        System.out.println("===============================");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword())
        );
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtToken jwt = jwtTokenProvider.createToken(authentication);
//        System.out.println("New Token = "+jwt);
        return ResponseEntity.ok(new AuthenticationResponse(
                jwt.getUserId(),
                jwt.getAccessToken(),
                jwt.getExpiryDate(),
                jwt.getUsername()
        ));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logout successful");
    }

}
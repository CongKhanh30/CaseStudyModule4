package com.be.controller;

import com.be.model.Account;
import com.be.model.dto.JwtResponse;
import com.be.service.IAccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IAccountService accountService;
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = createToken(account.getUsername());
        Account account1 = accountService.findByUsername(account.getUsername());
        UserDetails userDetails = accountService.loadUserByUsername(account.getUsername());
        String username1 = userDetails.getUsername();
        return ResponseEntity.ok(new JwtResponse(token,account1.getId(),username1 , userDetails.getAuthorities()));
    }
    public static final String PRIVATE_KEY = "123456789999887abc";
    private static final long EXPIRE_TIME = 86400L;
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject((username))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, PRIVATE_KEY)
                .compact();
    }
}
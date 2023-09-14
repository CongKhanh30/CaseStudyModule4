package com.be.model.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
public class JwtResponse {
    @Getter
    private int id;
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token,int id, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
    public Collection<? extends GrantedAuthority> getRole() {
        return roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
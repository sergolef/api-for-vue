package com.vueapi.springboot.cruddemo.security.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtToken {
    private String username;
    private Long userId;

    private Date expiryDate;
    public JwtToken(String username, Long userId, String accessToken, Date expiryDate) {
        this.username = username;
        this.userId = userId;
        this.accessToken = accessToken;
        this.expiryDate = expiryDate;
    }

    public String getUsername() {
        return username;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtToken() {
    }

    private String accessToken;
}

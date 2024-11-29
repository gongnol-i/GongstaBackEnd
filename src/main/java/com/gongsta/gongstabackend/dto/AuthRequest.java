package com.gongsta.gongstabackend.dto;

public class AuthRequest {
    private String username;
    private String password;

    // 기본 생성자
    public AuthRequest() {}

    // 생성자
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter (필요하면 추가)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// AuthController.java
package com.gongsta.gongstabackend.controller;

import com.gongsta.gongstabackend.dto.AuthRequest;
import com.gongsta.gongstabackend.dto.AuthResponse;
import com.gongsta.gongstabackend.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "사용자 로그인", description = "아이디와 비밀번호를 사용해 로그인합니다.")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

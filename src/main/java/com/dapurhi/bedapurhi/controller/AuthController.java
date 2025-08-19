package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.LoginRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.LoginResponse;
import com.dapurhi.bedapurhi.service.AuthService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<CommonResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil login.",
                authService.login(loginRequest)
        );
    }
}

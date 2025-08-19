package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.LoginRequest;
import com.dapurhi.bedapurhi.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}

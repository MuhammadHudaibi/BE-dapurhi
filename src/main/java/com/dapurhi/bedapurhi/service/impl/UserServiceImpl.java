package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.request.LoginRequest;
import com.dapurhi.bedapurhi.dto.response.LoginResponse;
import com.dapurhi.bedapurhi.repository.UserRepository;
import com.dapurhi.bedapurhi.service.JwtService;
import com.dapurhi.bedapurhi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }
}

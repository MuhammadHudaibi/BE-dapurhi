package com.dapurhi.bedapurhi.config;

import com.dapurhi.bedapurhi.constant.UserRole;
import com.dapurhi.bedapurhi.entity.User;
import com.dapurhi.bedapurhi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void initAdmin(){
        if (!userRepository.existsUserByUsername("adminhuda")) {
            User adminUser = User.builder()
                    .username("adminhuda")
                    .password(passwordEncoder.encode("hudahuda"))
                    .role(UserRole.ROLE_ADMIN)
                    .isEnabled(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .isAccountNonExpired(true)
                    .build();

            userRepository.save(adminUser);

            System.out.println("User admin berhasil dibuat email: " + adminUser.getUsername() + " Password: hudahuda");
        }

    }
}

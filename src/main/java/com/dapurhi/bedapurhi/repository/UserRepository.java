package com.dapurhi.bedapurhi.repository;

import com.dapurhi.bedapurhi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(String username);

    UserDetails findUserByUsername(String username);
}

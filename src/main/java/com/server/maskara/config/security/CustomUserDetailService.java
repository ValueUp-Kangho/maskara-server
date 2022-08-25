package com.server.maskara.config.security;

import com.server.maskara.entity.User;
import com.server.maskara.advice.exception.UserNotFoundException;
import com.server.maskara.respository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String id) {

        Optional<User> user = userRepository.findById(Long.valueOf(id));

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return user.get();
    }


}

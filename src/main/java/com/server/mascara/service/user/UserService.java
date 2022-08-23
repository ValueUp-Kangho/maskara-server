package com.server.mascara.service.user;

import com.server.mascara.domain.user.RegisterFormRequest;
import com.server.mascara.entity.User;
import com.server.mascara.advice.exception.UserNotFoundException;
import com.server.mascara.respository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public User findByUsername(String username) {

        Optional<User> findUser = userRepository.findByusername(username);

        if (findUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        return findUser.get();
    }

    public void save(RegisterFormRequest form) {
        User user = User.builder()
                .username(form.getId())
                .password(passwordEncoder.encode(form.getPassword()))
                .nickName(form.getNickname())
                .email(form.getResidence())
                .roles(Collections.singletonList("ROLE_USER"))
                .point(0)
                .build();

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }
}

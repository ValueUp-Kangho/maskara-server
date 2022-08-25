package com.server.maskara.service.user;

import com.server.maskara.domain.user.request.RegisterFormRequest;
import com.server.maskara.entity.User;
import com.server.maskara.advice.exception.UserNotFoundException;
import com.server.maskara.respository.user.UserRepository;
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
                .residence(form.getResidence())
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

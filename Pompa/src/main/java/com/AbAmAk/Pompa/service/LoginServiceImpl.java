package com.AbAmAk.Pompa.service;

import com.AbAmAk.Pompa.entity.AppUser;
import com.AbAmAk.Pompa.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(String username, String password) {
        Optional<AppUser> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            AppUser app_user = userOptional.get();

            // Verify password
            if (passwordEncoder.matches(password, app_user.getPassword())) {
                return true; // Login successful
            }
        }
        return false; // Login failed
    }
}
package bsm.bto.oauth.service;

import bsm.bto.oauth.domain.User;
import bsm.bto.oauth.domain.UserRepository;
import bsm.bto.oauth.exception.UserNotFoundException;
import bsm.bto.oauth.presentation.dto.AuthRequest;
import bsm.bto.oauth.presentation.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import bsm.bto.oauth.config.SecurityConfig;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByName(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("Invalid credentials");
        }
        // JWT 토큰 생성 로직 (예시)
        String token = "generated-jwt-token";
        return AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .build();
    }

    public AuthResponse register(AuthRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .name(request.getUsername())
                .password(encodedPassword)
                .build();
        userRepository.save(user);
        // JWT 토큰 생성 로직 (예시)
        String token = "generated-jwt-token";
        return AuthResponse.builder()
                .token(token)
                .userId(user.getId())
                .build();
    }
}

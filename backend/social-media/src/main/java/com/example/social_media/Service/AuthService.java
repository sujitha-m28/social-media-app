package com.example.social_media.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.social_media.DTO.LoginRequest;
import com.example.social_media.DTO.RegisterRequest;
import com.example.social_media.Entity.User;
import com.example.social_media.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request)
    {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
        {
            return "Emails exists already";
        }

        User user= User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return "User Registered Successfully";

    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return "Login Success";
    }
}

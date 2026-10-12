package com.example.Frontend.service;

import com.example.Frontend.Entity.User;
import com.example.Frontend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Userservice {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    
    public Userservice(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        
        // கையேட்டின் விதிமுறைப்படி: .matches() மூலம் பிளைன் பாஸ்வேர்டையும் ஹேஷ் பாஸ்வேர்டையும் ஒப்பிடுதல்
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt.get(); 
        }
        return null; 
    }
}

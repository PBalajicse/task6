package com.example.Frontend.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Frontend.Entity.User;
import com.example.Frontend.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, 
                               BindingResult result, 
                               Model model) {
        
        
        if (result.hasErrors()) {
            return "register";         }

        
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("duplicateError", "Username already exists!");
            return "register";
        }

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login?registered=true";
    }

}

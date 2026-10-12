package com.example.Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Frontend.Entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        String role = (String) session.getAttribute("userRole");

        
        if (user == null || !"ADMIN".equalsIgnoreCase(role)) {
            return "redirect:/login"; 
        }

        // அட்மின் பேனலில் காட்ட வேண்டிய போலி புள்ளிவிவரங்கள்
        model.addAttribute("adminName", user.getUsername());
        model.addAttribute("totalStudentsCount", 124); 
        model.addAttribute("totalQuestionsCount", 45);   

        return "admindashboard"; 
    }
}

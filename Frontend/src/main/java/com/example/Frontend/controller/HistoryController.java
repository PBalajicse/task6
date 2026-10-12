package com.example.Frontend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Frontend.Entity.Assessment;
import com.example.Frontend.Entity.User;
import com.example.Frontend.repository.AssessmentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HistoryController {
	
    private final AssessmentRepository assessmentRepository;

    public HistoryController(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @GetMapping("/history")
    public String showAssessmentHistory(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        String role = (String) session.getAttribute("userRole");

        // பாதுகாப்புச் சோதனை (Security Check)
        if (user == null || !"STUDENT".equalsIgnoreCase(role)) {
            return "redirect:/login";
        }

        // கையேட்டின்படி: லாகின் செய்த மாணவரின் ஐடியை அனுப்பி வரலாற்றை எடுக்கிறோம்
        List<Assessment> historyList = assessmentRepository.findByUserId(user.getId());
        model.addAttribute("history", historyList);

        return "history"; // templates/history.html பக்கத்தைக் குறிக்கும்
    }

}

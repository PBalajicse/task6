package com.example.Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	 @GetMapping("/dashboard")
	    public String showDashboard(Model model) {
	        
	        model.addAttribute("targetRole", "Java Backend Developer");
	        model.addAttribute("latestScore", "46.15%");
	        model.addAttribute("matchedCount", 3);
	        model.addAttribute("missingCount", 3);
	        model.addAttribute("highestScore", "85.00%");
	        model.addAttribute("assessmentCount", 4);
	        model.addAttribute("topRecommendations", "Spring Boot, REST API, Hibernate");

	        return "dashboard"; 
	    }

}

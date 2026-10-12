package com.example.Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssessmentController {
	

    @GetMapping("/assessment/role")
    public String showRoleSelection() {
        return "assessment"; 
    }


    @PostMapping("/assessment/run")
    public String runAssessment(@RequestParam("targetRole") String targetRole, Model model) {
        model.addAttribute("selectedRole", targetRole);
        

        if (targetRole.equals("Java Developer")) {
            model.addAttribute("q1", "1. ஜாவாவில் 'static' கீவேர்டின் பயன் என்ன?");
            model.addAttribute("q2", "2. Spring Boot-இல் டிபென்டென்சி இன்ஜெக்ஷன் (DI) என்றால் என்ன?");
        } else {
            model.addAttribute("q1", "1. SQL-இல் INNER JOIN மற்றும் LEFT JOIN-க்கு என்ன வித்தியாசம்?");
            model.addAttribute("q2", "2. தரவுப் பகுப்பாய்வில் (Data Analysis) Pandas-இன் பயன் என்ன?");
        }
        
        return "assessment"; 
    }


     
    @PostMapping("/assessment/submit")
    public String submitAssessment(@RequestParam(value = "score", required = false) Integer score, Model model) {
        
        
        int finalScore = (score != null) ? score : 0;
       
        model.addAttribute("finalScore", finalScore);
        return "redirect:/result?score=" + finalScore; 
    }

}

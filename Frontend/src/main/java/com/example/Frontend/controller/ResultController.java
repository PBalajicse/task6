package com.example.Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {
 
    @GetMapping("/result")
    public String showResult(@RequestParam(value = "score", defaultValue = "0") int score, Model model) {
        model.addAttribute("score", score);
        

        if (score >= 70) {
            model.addAttribute("status", "வெற்றி! (Passed)");
            model.addAttribute("feedback", "உங்களிடம் நல்ல திறமைகள் உள்ளன. வேலை வாய்ப்புகளுக்குத் தயாராக இருக்கிறீர்கள்!");
        } else {
            model.addAttribute("status", "மேம்படுத்த வேண்டும் (Needs Improvement)");
            model.addAttribute("feedback", "உங்களுக்குச் சில திறமை இடைவெளிகள் (Skill Gaps) உள்ளன. மீண்டும் படித்துவிட்டு முயற்சிக்கவும்.");
        }
        return "result"; 
    }


	/*
	 * @GetMapping("/history") public String showHistory(Model model) {
	 * 
	 * return "history"; }
	 */

}

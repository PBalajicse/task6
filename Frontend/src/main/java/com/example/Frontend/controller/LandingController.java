package com.example.Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Frontend.service.Userservice;

@Controller
public class LandingController {
	
	
	private final Userservice userService;
	
	 public LandingController(Userservice userService) {
	        this.userService = userService;
	    }
	
    // 1. Landing Page (http://localhost:8080/)
    @GetMapping("/")
    public String showLandingPage() {
        return "landing";
    }

    // 2. Register Page
	/*
	 * @GetMapping("/register") public String showRegisterPage() { return
	 * "register"; }
	 */

    // 3. Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // 4. Dashboard Page
	/*
	 * @GetMapping("/dashboard") public String showDashboardPage() { return
	 * "dashboard"; }
	 */

    // 5. My Skills Page (Maintain Skills பகுதி)
    @GetMapping("/my-skills")
    public String showMySkillsPage() {
        return "my-skills";
    }

    // 6. Assessment Page (Select Target Role & Run Assessment)
    @GetMapping("/assessment")
    public String showAssessmentPage() {
        return "assessment";
    }

    // 7. Result Page (View Result & Reassess)
	/*
	 * @GetMapping("/result") public String showResultPage() { return "result"; }
	 */

    // 8. History Page (Review History)
	/*
	 * @GetMapping("/history") public String showHistoryPage() { return "history"; }
	 */

    // 9. Admin Dashboard Page
	/*
	 * @GetMapping("/admin/dashboard") public String showAdminDashboardPage() {
	 * return "admin-dashboard"; }
	 */

}

package com.example.Frontend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Frontend.Entity.Skill;
import com.example.Frontend.Entity.User;
import com.example.Frontend.repository.SkillRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/skills")
public class AdminSkillController {

    private final SkillRepository skillRepository;

    public AdminSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    
    @GetMapping
    public String viewSkills(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        String role = (String) session.getAttribute("userRole");

        
        if (user == null || !"ADMIN".equalsIgnoreCase(role)) {
            return "redirect:/login"; 
        }

        List<Skill> skillList = skillRepository.findAll();
        model.addAttribute("skills", skillList);
        return "admin_skills"; 
    }

    
    @PostMapping("/add")
    public String addSkill(@RequestParam("skillName") String skillName, 
                           @RequestParam("description") String description) {
        Skill skill = new Skill();
        skill.setSkillName(skillName);
        skill.setDescription(description);
        skill.setStatus("ACTIVE"); // கையேட்டின்படி இயல்பாக ACTIVE என்று சேமிக்கும்
        
        skillRepository.save(skill);
        return "redirect:/admin/skills";
    }

    
    @GetMapping("/deactivate/{id}")
    public String deactivateSkill(@PathVariable("id") Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        if (skill != null) {
            skill.setStatus("INACTIVE"); // கையேட்டின் முக்கிய விதி: Hard delete செய்யாமல் Status மாற்றுவது
            skillRepository.save(skill);
        }
        return "redirect:/admin/skills";
    }
}

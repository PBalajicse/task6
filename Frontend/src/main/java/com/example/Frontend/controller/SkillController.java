package com.example.Frontend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Frontend.Entity.Skill;
import com.example.Frontend.repository.SkillRepository;

@Controller
public class SkillController {
	
    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    
    @GetMapping("/skills")
    public String viewSkills(Model model) {
        List<Skill> skillList = skillRepository.findAll();
        model.addAttribute("skills", skillList);
        return "myskills"; 
    }

  
    @PostMapping("/skills/add")
    public String addSkill(@RequestParam("skillName") String skillName, 
                           @RequestParam("description") String description) {
        Skill newSkill = new Skill();
        newSkill.setSkillName(skillName);
        newSkill.setDescription(description);
        
        skillRepository.save(newSkill); 
        return "redirect:/skills"; 
    }

    @GetMapping("/skills/delete/{id}")
    public String deleteSkill(@PathVariable("id") Long id) {
        skillRepository.deleteById(id);
        return "redirect:/skills";
    }

}

package com.example.Frontend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Frontend.Entity.Skill;
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	Optional<Skill> findBySkillName(String skillName);
}

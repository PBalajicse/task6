package com.example.Frontend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Frontend.Entity.Assessment;
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

	
	 @Query("SELECT a FROM Assessment a WHERE a.user.id = :userId ORDER BY a.createdAt DESC")
	    List<Assessment> findByUserId(@Param("userId") Long userId);
}

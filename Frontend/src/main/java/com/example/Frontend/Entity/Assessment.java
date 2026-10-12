package com.example.Frontend.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assessments")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. கையேட்டின் விதி: எந்த வேலைக்கான தேர்வு (Role)
    @Column(nullable = false)
    private String targetRole;

    // 2. கையேட்டின் விதி: பெற்ற மதிப்பெண் சதவீதம் (Score)
    @Column(nullable = false)
    private String score;

    // 3. கையேட்டின் விதி: மாணவரின் நிலை (Label - Expert/Developing)
    @Column(nullable = false)
    private String label;

    // 4. கையேட்டின் விதி: தேர்வு எழுதிய தேதி மற்றும் நேரம் (Date)
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // வரைபடத்தின்படி: இந்தத் தேர்வு எந்த மாணவருக்குச் சொந்தமானது என்ற இணைப்பு (Many-to-One Link)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // --- GETTER AND SETTER METHODS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

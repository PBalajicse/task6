INSERT IGNORE INTO users (id, username, password, email, role) 
VALUES (1, 'admin', '$2a$10$8.tXGdf.AXYy0R0Wj3QvAuE6M9f1l8X7G4t1E7O2Y2w1mO2Z2b2S2', 'admin@portal.com', 'ADMIN');


INSERT IGNORE INTO skills (id, skill_name, description, status) 
VALUES (1, 'Java', 'Core Java Programming', 'ACTIVE');

INSERT IGNORE INTO skills (id, skill_name, description, status) 
VALUES (2, 'Spring Boot', 'Enterprise Framework', 'ACTIVE');

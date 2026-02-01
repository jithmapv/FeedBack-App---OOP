-- SQL Script to setup the Feedback Application Database
-- Run this script in MySQL to create the database and table

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS web_db;

-- Use the database
USE web_db;

-- Create feedback table
CREATE TABLE IF NOT EXISTS feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    feedback TEXT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample data (optional)
INSERT INTO feedback (type, feedback, name, email) VALUES
('Suggestion', 'Great application! Would love to see more features.', 'John Doe', 'john@example.com'),
('Bug Report', 'Found a small issue with the edit functionality.', 'Jane Smith', 'jane@example.com'),
('Compliment', 'Amazing work! Very user-friendly interface.', 'Bob Johnson', 'bob@example.com');

-- Display all feedbacks
SELECT * FROM feedback;

-- src/main/resources/schema.sql

CREATE DATABASE IF NOT EXISTS blog_app CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE blog_app;

-- USER
CREATE TABLE IF NOT EXISTS users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(120) NOT NULL,
  email VARCHAR(180) NOT NULL UNIQUE,
  password_hash VARCHAR(100) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE INDEX idx_users_email ON users(email);

-- BLOG
CREATE TABLE IF NOT EXISTS blogs (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  title VARCHAR(200) NOT NULL,
  short_description VARCHAR(300) NOT NULL,
  content MEDIUMTEXT NOT NULL,
  is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL DEFAULT NULL,
  CONSTRAINT fk_blogs_user FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;

-- Indexes for search + uniqueness
CREATE UNIQUE INDEX uq_blog_title ON blogs(title);
CREATE UNIQUE INDEX uq_blog_short_description ON blogs(short_description);
CREATE INDEX idx_blog_is_deleted ON blogs(is_deleted);
CREATE INDEX idx_blog_title ON blogs(title);
CREATE INDEX idx_blog_short_desc ON blogs(short_description);

-- Optional FULLTEXT for better search ranking (MySQL 8+)
ALTER TABLE blogs
  ADD FULLTEXT INDEX ft_blog_content (content);

-- COMMENT
CREATE TABLE IF NOT EXISTS comments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  blog_id BIGINT NOT NULL,
  name VARCHAR(120) NOT NULL,
  email VARCHAR(180) NOT NULL,
  comment_text TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_comments_blog FOREIGN KEY (blog_id) REFERENCES blogs(id)
) ENGINE=InnoDB;

CREATE INDEX idx_comments_blog_id ON comments(blog_id);
CREATE INDEX idx_comments_email ON comments(email);

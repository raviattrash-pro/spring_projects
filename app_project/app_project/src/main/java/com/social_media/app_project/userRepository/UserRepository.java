package com.social_media.app_project.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social_media.app_project.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

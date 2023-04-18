package com.elite.evince.task.repository;

import com.elite.evince.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

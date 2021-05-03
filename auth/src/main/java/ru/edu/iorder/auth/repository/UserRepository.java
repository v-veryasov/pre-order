package ru.edu.iorder.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.iorder.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}

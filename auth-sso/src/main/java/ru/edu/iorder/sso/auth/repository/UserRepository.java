package ru.edu.iorder.sso.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.iorder.sso.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}

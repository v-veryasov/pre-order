package ru.edu.iorder.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.iorder.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

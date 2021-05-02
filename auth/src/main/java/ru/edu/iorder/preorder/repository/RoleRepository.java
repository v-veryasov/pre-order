package ru.edu.iorder.preorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.iorder.preorder.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

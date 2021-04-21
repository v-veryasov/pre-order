package ru.edu.iorder.preorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.iorder.preorder.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByLogin(String login);
//    CrudRepository<Customer, Long> JpaRepository

//    Customer findByLogin(String login);
}

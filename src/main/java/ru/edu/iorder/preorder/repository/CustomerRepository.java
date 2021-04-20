package ru.edu.iorder.preorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.iorder.preorder.model.Customer;

//TODO: почитать
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByLogin(String login);
}

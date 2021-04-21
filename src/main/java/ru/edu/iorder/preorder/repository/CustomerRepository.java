package ru.edu.iorder.preorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.edu.iorder.preorder.model.Customer;

//TODO: почитать
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByLogin(String login);
}

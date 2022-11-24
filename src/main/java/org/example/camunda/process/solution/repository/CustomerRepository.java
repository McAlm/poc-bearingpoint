package org.example.camunda.process.solution.repository;

import org.example.camunda.process.solution.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}

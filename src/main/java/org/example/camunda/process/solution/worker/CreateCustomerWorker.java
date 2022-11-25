package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import org.example.camunda.process.solution.dto.Antragsdaten;
import org.example.camunda.process.solution.entity.Customer;
import org.example.camunda.process.solution.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerWorker {

  private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerWorker.class);
  @Autowired private CustomerRepository custRepo;

  @JobWorker
  public void createCustomer(@VariablesAsType Antragsdaten antragsdaten) {
    Customer customer = new Customer();
    customer.setBirthdate(antragsdaten.getBirthdate());
    customer.setFirstName(antragsdaten.getFirstname());
    customer.setLastName(antragsdaten.getLastname());
    customer.setCity(antragsdaten.getCity());
    customer.setStreet(antragsdaten.getStreet());
    customer.setZipcode(antragsdaten.getZipcode());
    customer.setEmail(antragsdaten.getEmailAdress());
    LOG.info("Try to create a new customer.." + customer);

    customer = custRepo.save(customer);
    custRepo.flush();

    LOG.info("Customer created with id " + customer.getId());
  }
}

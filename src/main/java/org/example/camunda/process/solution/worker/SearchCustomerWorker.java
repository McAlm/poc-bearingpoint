package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import java.util.HashMap;
import org.example.camunda.process.solution.dto.Antragsdaten;
import org.example.camunda.process.solution.entity.Customer;
import org.example.camunda.process.solution.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchCustomerWorker {

  private static final Logger LOG = LoggerFactory.getLogger(SearchCustomerWorker.class);

  @Autowired private CustomerRepository custRepo;

  @JobWorker
  public HashMap<String, Object> searchCustomer(@VariablesAsType Antragsdaten antragsdaten) {

    String email = antragsdaten.getEmailAdress();
    Customer customer = custRepo.findByEmail(email);

    HashMap<String, Object> vars = new HashMap<>();
    if (customer == null) {
      vars.put("customerFound", false);
    } else {
      LOG.info("Found customer " + customer);
      vars.put("customerFound", true);
    }

    return vars;
  }
}

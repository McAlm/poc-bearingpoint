package org.example.camunda.process.solution.worker;

import java.time.LocalDate;
import java.util.Optional;

import org.example.camunda.process.solution.ProcessVariables;
import org.example.camunda.process.solution.entity.Customer;
import org.example.camunda.process.solution.repository.CustomerRepository;
import org.example.camunda.process.solution.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

@Component
public class MyWorker {

  private static final Logger LOG = LoggerFactory.getLogger(MyWorker.class);

  @Autowired
  private MyService myService;

  @Autowired
  private CustomerRepository custRepo;

  @JobWorker
  public ProcessVariables invokeMyService(@VariablesAsType ProcessVariables variables) {
    LOG.info("Invoking myService with variables: " + variables);

    Optional<Customer> found = custRepo.findById(1l);
    if (found.isPresent()) {
      Customer customer = found.get();
      LOG.info(customer.toString());
    } else {
      Customer stefan = new Customer("Stefan", "Wiese", LocalDate.of(1968, 4, 28));
      custRepo.save(stefan);
      custRepo.flush();
    }
    boolean result = myService.myOperation(variables.getBusinessKey());

    return new ProcessVariables()
        .setResult(result); // new object to avoid sending unchanged variables
  }
}

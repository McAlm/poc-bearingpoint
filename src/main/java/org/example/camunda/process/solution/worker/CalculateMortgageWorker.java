package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import java.math.BigDecimal;
import java.text.NumberFormat;
import org.example.camunda.process.solution.dto.MortgageData;
import org.example.camunda.process.solution.service.MortgageCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateMortgageWorker {

  private static final Logger LOG = LoggerFactory.getLogger(CalculateMortgageWorker.class);

  @Autowired private MortgageCalculatorService calculatorService;

  @JobWorker()
  public MortgageData calculateMortgage(@VariablesAsType MortgageData mortgageData) {

    BigDecimal calculatedMortgage = calculatorService.calculateMortgage(mortgageData);

    String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(calculatedMortgage);
    LOG.info("calculated monthly payment: " + monthlyPaymentFormatted);

    mortgageData.setCalculatedMonthlyPayment(calculatedMortgage);
    return mortgageData;
  }
}

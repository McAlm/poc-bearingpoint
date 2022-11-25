package org.example.camunda.process.solution.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.example.camunda.process.solution.dto.MortgageData;
import org.springframework.stereotype.Service;

@Service
public class MortgageCalculatorService {

  private static final MathContext MC = MathContext.DECIMAL32;
  private static final BigDecimal ONE = BigDecimal.valueOf(1L);
  private static final BigDecimal TWELVE = BigDecimal.valueOf(12L);

  public BigDecimal calculateMortgage(MortgageData md) {

    // calculate according to https://www.wikihow.com/Calculate-Mortgage-Payments

    // Principal
    Long principal =
        md.getKaufpreis() + md.getZusaetzlicherFinanzierungsbedarf() - md.getEigenkapital();

    // Interest rate
    BigDecimal annualInterest = BigDecimal.valueOf(md.getInterestRate());
    BigDecimal monthlyInterest =
        annualInterest.divide(TWELVE, MC).divide(BigDecimal.valueOf(100.0), MC);

    int years = md.getWunschlaufzeit();
    int numberOfPayments = years * 12;

    // Calculate the monthly payment
    BigDecimal power = monthlyInterest.add(ONE).pow(numberOfPayments, MC);

    BigDecimal zaehler = monthlyInterest.multiply(power);
    BigDecimal nenner = power.subtract(ONE);

    BigDecimal zwischenergebnis = zaehler.divide(nenner, MC);

    BigDecimal monthlyPayment =
        BigDecimal.valueOf(principal)
            .multiply(zwischenergebnis)
            .setScale(2, RoundingMode.HALF_EVEN);

    return monthlyPayment;
  }
}

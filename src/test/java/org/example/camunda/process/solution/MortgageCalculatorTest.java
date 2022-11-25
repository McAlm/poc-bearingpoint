package org.example.camunda.process.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.example.camunda.process.solution.dto.MortgageData;
import org.example.camunda.process.solution.service.MortgageCalculatorService;
import org.junit.jupiter.api.Test;

public class MortgageCalculatorTest {
    
    @Test
    public void testMortgage(){
        MortgageData md = new MortgageData();
        md.setEigenkapital(40000L);
        md.setWunschlaufzeit(15);
        md.setInterestRate(6.0);
        md.setZinsBindung(10);
        md.setZusaetzlicherFinanzierungsbedarf(20000L);
        md.setKaufpreis(120000L);

        MortgageCalculatorService mds = new MortgageCalculatorService();
        BigDecimal monthly = mds.calculateMortgage(md);
        assertEquals(BigDecimal.valueOf( 843.86), monthly);
    }
}

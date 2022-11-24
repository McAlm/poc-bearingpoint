package org.example.camunda.process.solution.worker;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

@Component
public class CalculateMortgageWorker {

    @JobWorker()
    public void calculateMortgage(@VariablesAsType MortgageData mortgageData) {

        // Zinsangebot
        // Restschuld
        // Rate
        Long kreditBedarf = mortgageData.getKaufpreis() + mortgageData.getZusaetzlicherFinanzierungsbedarf() -
                mortgageData.getEigenkapital();

    }
}

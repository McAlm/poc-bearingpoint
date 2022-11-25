package org.example.camunda.process.solution.worker;

public class MailData {

    private String emailAdress;
    private String firstname;
    private Double calculatedMonthlyPayment;
    
    public String getEmailAdress() {
        return emailAdress;
    }
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public Double getCalculatedMonthlyPayment() {
        return calculatedMonthlyPayment;
    }
    public void setCalculatedMonthlyPayment(Double calculatedMonthlyPayment) {
        this.calculatedMonthlyPayment = calculatedMonthlyPayment;
    }
    
}

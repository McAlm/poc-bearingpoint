package org.example.camunda.process.solution.worker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MortgageData {

    private Integer zinsBindung;
    private Long zusaetzlicherFinanzierungsbedarf;
    private Long eigenkapital;
    private Long wunschrate;
    private Integer wunschlaufzeit;
    private Long kaufpreis;
    private Long einkommen_1, einkommen_2;
    public Integer getZinsBindung() {
        return zinsBindung;
    }
    public void setZinsBindung(Integer zinsBindung) {
        this.zinsBindung = zinsBindung;
    }
    public Long getZusaetzlicherFinanzierungsbedarf() {
        return zusaetzlicherFinanzierungsbedarf;
    }
    public void setZusaetzlicherFinanzierungsbedarf(Long zusaetzlicherFinanzierungsbedarf) {
        this.zusaetzlicherFinanzierungsbedarf = zusaetzlicherFinanzierungsbedarf;
    }
    public Long getEigenkapital() {
        return eigenkapital;
    }
    public void setEigenkapital(Long eigenkapital) {
        this.eigenkapital = eigenkapital;
    }
    public Long getWunschrate() {
        return wunschrate;
    }
    public void setWunschrate(Long wunschrate) {
        this.wunschrate = wunschrate;
    }
    public Integer getWunschlaufzeit() {
        return wunschlaufzeit;
    }
    public void setWunschlaufzeit(Integer wunschlaufzeit) {
        this.wunschlaufzeit = wunschlaufzeit;
    }
    public Long getKaufpreis() {
        return kaufpreis;
    }
    public void setKaufpreis(Long kaufpreis) {
        this.kaufpreis = kaufpreis;
    }
    public Long getEinkommen_1() {
        return einkommen_1;
    }
    public void setEinkommen_1(Long einkommen_1) {
        this.einkommen_1 = einkommen_1;
    }
    public Long getEinkommen_2() {
        return einkommen_2;
    }
    public void setEinkommen_2(Long einkommen_2) {
        this.einkommen_2 = einkommen_2;
    }


    


}

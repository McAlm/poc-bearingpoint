package org.example.camunda.process.solution.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer", schema = "public")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "birthdate")
  private String birthdate;

  @Column(name = "zipcode")
  private String zipcode;

  @Column(name = "city")
  private String city;

  @Column(name = "street")
  private String street;

  @Column(name = "email")
  private String email;


  public Customer(String firstName, String lastName, String birthdate, String zipcode, String city, String street,
      String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.zipcode = zipcode;
    this.city = city;
    this.street = street;
    this.email = email;
  }

  public Customer() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  @Override
  public String toString() {
    return "Customer [id="
        + id
        + ", firstName="
        + firstName
        + ", lastName="
        + lastName
        + ", birthdate="
        + birthdate
        + "]";
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

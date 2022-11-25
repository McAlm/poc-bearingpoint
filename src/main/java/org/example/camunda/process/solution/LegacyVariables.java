package org.example.camunda.process.solution;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.camunda.connector.api.annotation.Secret;

@JsonInclude(Include.NON_NULL)
public class LegacyVariables {

  @NotEmpty
  @Pattern(regexp = "^(secrets\\.).+", message = "Token must be a secret.")
  @Secret
  private String token;
  
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  private String businessKey;
  private Boolean result;

  private String request;

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public String getBusinessKey() {
    return businessKey;
  }

  public LegacyVariables setBusinessKey(String businessKey) {
    this.businessKey = businessKey;
    return this;
  }

  public Boolean getResult() {
    return result;
  }

  public LegacyVariables setResult(Boolean result) {
    this.result = result;
    return this;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(
        this,
        new MultilineRecursiveToStringStyle() {
          public ToStringStyle withShortPrefixes() {
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
            return this;
          }
        }.withShortPrefixes());
  }
}

package com.pfe.main.model;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String userName;
     
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    @NotBlank
    @Size(max = 8)
  private String cin;
    
    public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getUserName() {
        return userName;
    }
 
    public void setUserName(String username) {
        this.userName = username;
    }
 
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}

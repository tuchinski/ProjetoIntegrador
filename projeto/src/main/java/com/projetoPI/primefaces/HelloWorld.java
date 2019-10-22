package com.projetoPI.primefaces;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class HelloWorld {
	private String firstName = "John";
	private String lastName = "Doe";
	
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

	  public String showGreeting() {
	    return "Hello " + firstName + " " + lastName + "!";
	  }
}

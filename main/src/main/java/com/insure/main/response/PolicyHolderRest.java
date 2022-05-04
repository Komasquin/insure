package com.insure.main.response;

import java.util.Date;

import lombok.Data;

@Data
public class PolicyHolderRest {

	private String firstName;
	private String lastName;
	private int age;
	private Date dateOfBirth;
	private String address;
}

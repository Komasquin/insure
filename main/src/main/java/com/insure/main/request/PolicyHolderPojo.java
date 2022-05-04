package com.insure.main.request;

import java.util.Date;

import lombok.Data;

@Data
public class PolicyHolderPojo {

	private String firstName;
	private String lastName;
	private int age;
	private Date dateOfBirth;
	private String address;
}

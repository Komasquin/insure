package com.insure.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PolicyHolderDto {
	private String firstName;
	private String lastName;
	private int age;
	private Date dateOfBirth;
	private String address;
	
	
}

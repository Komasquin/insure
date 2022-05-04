package com.insure.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin("http://localhost:4200")
@Entity
@Table(name="policy_holder")
@Getter
@Setter
public class PolicyHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="address")
	private String address;
}

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
@Table(name="policy_details")
@Getter
@Setter
public class PolicyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policy_number")
	private int policyNumber;
	
	@Column(name="policy_made_date")
	private Date policyMadeDate;
	
	@Column(name="premium_amount")
	private double premiumAmount;
	
	@Column(name="policy_holer_id")
	private int policyHolderId;
	
	@Column(name="plan_name")
	private String planName;
}

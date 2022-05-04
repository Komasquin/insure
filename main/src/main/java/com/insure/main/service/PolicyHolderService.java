package com.insure.main.service;

import java.util.List;

import com.insure.main.dto.PolicyHolderDto;


public interface PolicyHolderService {
	//interface - CRUD
	PolicyHolderDto createPolicyHolder(PolicyHolderDto policyHolder);//C
	PolicyHolderDto getPolicyHolderByPolicyHolderID(int id);//R
	PolicyHolderDto getPolicyHolderByName(String name);//R
	List<PolicyHolderDto> getHolders();//R
	PolicyHolderDto updatePolicyHolder(String id, PolicyHolderDto policyHolder);//U
	void deletePolicyHolder(int id);//D
}

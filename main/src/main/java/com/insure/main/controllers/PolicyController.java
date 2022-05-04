package com.insure.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insure.main.dto.PolicyHolderDto;
import com.insure.main.request.PolicyHolderPojo;
import com.insure.main.response.PolicyHolderRest;
import com.insure.main.service.PolicyHolderService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired 
	PolicyHolderService policyHolderService;
	
	@PostMapping(path="/add")
	public PolicyHolderRest addPolicyHolder(@RequestBody PolicyHolderPojo newPolicyHolder) throws Exception {
		
		PolicyHolderRest returnValue = new PolicyHolderRest();
		PolicyHolderDto newHolder = new PolicyHolderDto();
		ModelMapper modelMapper = new ModelMapper();
		
		if(newPolicyHolder.getFirstName().isEmpty()) {
			throw new Exception("Error in controller, function: addPolicyHolder");
		}
		
		newHolder = modelMapper.map(newPolicyHolder, PolicyHolderDto.class);
		PolicyHolderDto createHolderReturn = policyHolderService.createPolicyHolder(newHolder);
		//BeanUtils.copyProperties(createHolderReturn, returnValue);
		returnValue = modelMapper.map(createHolderReturn, PolicyHolderRest.class);
		
		return returnValue;
	}
	
	@GetMapping(path="/policyholders")
	public List<PolicyHolderRest> getPolicyHolders() {
		List<PolicyHolderRest> returnValues = new ArrayList<>();
		List<PolicyHolderDto> policyHolders = policyHolderService.getHolders();
		
		policyHolders.forEach((holder) -> {
			PolicyHolderRest policyHolder = new PolicyHolderRest();
			BeanUtils.copyProperties(holder, policyHolder);
			returnValues.add(policyHolder);
		});
		
		return returnValues;
	}
	
	@GetMapping(path="/search/name/{lastName}")
	public void searchPolicyHolderByLastName() {
		
	}
	
	@GetMapping(path="/search/id/{id}")
	public void searchPolicyHolderById() {
		
	}
	
	@PutMapping(path="/update/{id}")
	public PolicyHolderRest updatePolicyHolder(@PathVariable String id, @RequestBody PolicyHolderPojo policyHolderDetails) {
		PolicyHolderRest returnValue = new PolicyHolderRest();
		PolicyHolderDto policyHolderDTO = new PolicyHolderDto();
		
		BeanUtils.copyProperties(policyHolderDetails, policyHolderDTO);
		PolicyHolderDto updatedUser = policyHolderService.updatePolicyHolder(id, policyHolderDTO);
		BeanUtils.copyProperties(updatedUser, returnValue);
			
		return returnValue;
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deletePolicyHolder(@PathVariable String id) {
		int tempId = Integer.valueOf(id);
		policyHolderService.deletePolicyHolder(tempId);
		
		return "Policy holder was deleted from database.";
	}
}

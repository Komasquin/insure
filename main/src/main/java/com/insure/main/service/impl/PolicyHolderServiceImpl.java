package com.insure.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insure.main.dao.PolicyHolderRepository;
import com.insure.main.dto.PolicyHolderDto;
import com.insure.main.entity.PolicyHolder;
import com.insure.main.service.PolicyHolderService;

@Service
public class PolicyHolderServiceImpl implements PolicyHolderService {
	
	@Autowired
	PolicyHolderRepository policyHolderRepo;

	@Override
	public PolicyHolderDto createPolicyHolder(PolicyHolderDto policyHolder) {
		ModelMapper modelMapper = new ModelMapper();
		PolicyHolder holder = new PolicyHolder();
		PolicyHolderDto returnValues = new PolicyHolderDto();

		BeanUtils.copyProperties(policyHolder, holder);
		holder = modelMapper.map(policyHolder, PolicyHolder.class);
		PolicyHolder storedHolder = policyHolderRepo.save(holder);
		returnValues = modelMapper.map(storedHolder, PolicyHolderDto.class);
		
		return returnValues;
	}

	@Override
	public PolicyHolderDto getPolicyHolderByPolicyHolderID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PolicyHolderDto getPolicyHolderByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PolicyHolderDto> getHolders() {
		List<PolicyHolderDto> returnValues = new ArrayList<>();
		List<PolicyHolder> policyHolders = policyHolderRepo.findAll();
		
		policyHolders.forEach((holder) -> {
			PolicyHolderDto policyHolder = new PolicyHolderDto();
			BeanUtils.copyProperties(holder, policyHolder);
			returnValues.add(policyHolder);
		});
		
		return returnValues;
	}

	@Override
	public PolicyHolderDto updatePolicyHolder(String id, PolicyHolderDto policyHolder) {
		PolicyHolderDto returnValue = new PolicyHolderDto();
		int tempId = Integer.valueOf(id);
		
		Optional<PolicyHolder> holder = policyHolderRepo.findById(tempId);
		if (policyHolder == null) {
			System.out.println("***---Error in PolicyHolderServiceImpl, function: updatePolicyHolder---***");
		}
		
		holder.get().setFirstName(policyHolder.getFirstName());
		holder.get().setLastName(policyHolder.getLastName());
		holder.get().setAge(policyHolder.getAge());
		holder.get().setDateOfBirth(policyHolder.getDateOfBirth());
		holder.get().setAddress(policyHolder.getAddress());
		
		PolicyHolder updatedPolicyHolder = policyHolderRepo.save(holder.get());
		
		BeanUtils.copyProperties(updatedPolicyHolder, returnValue);
		return returnValue;
	}

	@Override
	public void deletePolicyHolder(int id) {
		Optional<PolicyHolder> policyHolder = policyHolderRepo.findById(id);

		if (policyHolder == null) {
			System.out.println("***---Error in PolicyHolderServiceImpl, function: deletePolicyHolder---***");
		}

		policyHolderRepo.delete(policyHolder.get());
	}

}

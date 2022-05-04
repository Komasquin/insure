package com.insure.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.insure.main.entity.PolicyHolder;

@RepositoryRestResource(collectionResourceRel = "policyHolder", path = "policy-holders")
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer> {

}

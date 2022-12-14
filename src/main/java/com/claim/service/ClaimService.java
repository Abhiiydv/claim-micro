package com.claim.service;

import java.util.List;
import java.util.Optional;

import com.claim.entity.Claim;

public interface ClaimService {

	Claim submitClaim(Claim clame);
	
	Optional<Claim> fetchClaimById(Integer id);
	
	List<Claim> fetchClaimByMemberId(Long id);
	
	List<Claim> getAllClaims();
}

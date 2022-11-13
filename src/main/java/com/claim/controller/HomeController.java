package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Claim;
import com.claim.service.ClaimService;

@RestController
public class HomeController {

	@Autowired
	private ClaimService claimService;
	
	@PostMapping("/submit")
	public Integer submitClaim(@RequestBody Claim claim) {
		
		return claimService.submitClaim(claim);
	}
	
	@GetMapping("/claim/{id}")
	public Optional<Claim> fetchByClaimId(@PathVariable Integer id)
	{
		return claimService.fetchClaimById(id);
	}
	
	@GetMapping("/claim/member/{id}")
	public List<Claim> fetchClaimsByMemberId(@PathVariable Long id){
		return claimService.fetchClaimByMemberId(id);
	}
	
}

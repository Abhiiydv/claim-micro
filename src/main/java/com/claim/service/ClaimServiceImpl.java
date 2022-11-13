package com.claim.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Claim;
import com.claim.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	private ClaimRepository claimRepo;
	
	@Override
	public Integer submitClaim(Claim clame) {
		// TODO Auto-generated method stub
		System.out.println("Saving claim for memebr :"+clame.getMemberId());
	    clame.setClaimDate(LocalDate.now());
		Claim savedClaime= claimRepo.save(clame);
		return savedClaime.getClaim_id();
	}

	@Override
	public Optional<Claim> fetchClaimById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("Fetching data for clame id :"+id);
		
		return claimRepo.findById(id);
	}
	
	@Override
	public List<Claim> fetchClaimByMemberId(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Fetching claim data for member id : "+id);
		List<Claim> claims =  claimRepo.findAll().stream().filter(p-> p.getMemberId() == id).collect(Collectors.toList());
		return claims;
	}

}

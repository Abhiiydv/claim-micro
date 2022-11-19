package com.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.claim.controller.HomeController;
import com.claim.entity.Claim;
import com.claim.entity.ClaimType;
import com.claim.service.ClaimService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {

	@Autowired
	private HomeController homecontroller;
	
	@MockBean
	private ClaimService claimService;
	
	Claim c = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
			ClaimType.Medical);

	@Test
	void contextLoads() {
	}
	
	@Test
	public void submitClaimm() {
		
		when(claimService.submitClaim(c)).thenReturn(c);
		assertEquals(c, homecontroller.submitClaim(c));
	}
	
	@Test
	public void getAllClaims() {
		Claim c1 = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		Claim c2 = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		List<Claim> listC =  new ArrayList<Claim>();
		listC.add(c1);
		listC.add(c2);
		
		
		when(claimService.getAllClaims()).thenReturn(listC);
		assertEquals(listC.size(), homecontroller.getAllClaims().size());
	}
	
	@Test
	public void getClaimsByMemberId() {
		long memberId=7;
		Claim c1 = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		Claim c2 = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		List<Claim> listC =  new ArrayList<Claim>();
		listC.add(c1);
		listC.add(c2);
		
		when(claimService.fetchClaimByMemberId(memberId)).thenReturn(listC);
		assertEquals(listC.size(), homecontroller.fetchClaimsByMemberId(memberId).size());
	}
	
	@Test
	public void getClaimByClaimId() {
		
		Integer id = 12;
		Optional<Claim> c = Optional.ofNullable(new Claim(12,
				(long)10,
		    	(long)100,"This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical));
		
		when(claimService.fetchClaimById(id)).thenReturn(c);
		assertEquals(c, homecontroller.fetchByClaimId(id));
	}
	@Test
	public void getClaimByClaimIdFailure() {
		
		Integer id = 11;
		Optional<Claim> c = Optional.ofNullable(new Claim(12,
				(long)10,
		    	(long)100,"This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical));
		
		when(claimService.fetchClaimById(id)).thenReturn(c);
		assertEquals(c, homecontroller.fetchByClaimId(id));
	}
	
}

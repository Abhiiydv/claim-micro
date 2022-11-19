package com.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.claim.entity.Claim;
import com.claim.entity.ClaimType;
import com.claim.repository.ClaimRepository;
import com.claim.service.ClaimService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClaimServiceApplicationTests {

	@Autowired
	private ClaimService claimServ;

	@MockBean
	private ClaimRepository claimRepo;

	@Test
	void contextLoads() {
	}

	Claim c = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
			ClaimType.Medical);

	@Test
	public void saveClaimTest() {
		when(claimRepo.save(c)).thenReturn(c);
		assertEquals(c.getClaim_id(), claimServ.submitClaim(c).getClaim_id());
	}

	@Test
	public void getAllClaimsTest() {
		when(claimRepo.findAll()).thenReturn(Stream.of(
				new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
						ClaimType.Medical),
				new Claim(11, (long) 8, (long) 1200, "This is for medicines claims", LocalDate.of(2022, 11, 17),
						ClaimType.Vision))
				.collect(Collectors.toList()));
		assertEquals(2, claimServ.getAllClaims().size());
	}
	
	@Test
	public void getClaimByMemberId() {
		Claim obj = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		Claim obj1 = new Claim(11, (long) 7, (long) 1500, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		List<Claim> list = new ArrayList<>();
		list.add(obj);
		list.add(obj1);
		
		
		when(claimServ.fetchClaimByMemberId((long)7)).thenReturn(list);
		assertEquals(list,claimServ.fetchClaimByMemberId((long)7));
	}
	@Test
	public void getClaimByMemberIdFailure() {
		Claim obj = new Claim(10, (long) 7, (long) 1200, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		Claim obj1 = new Claim(11, (long) 7, (long) 1500, "This is for fever claims", LocalDate.of(2022, 11, 17),
				ClaimType.Medical);
		List<Claim> list = new ArrayList<>();
		list.add(obj);
		list.add(obj1);
		
		
		when(claimServ.fetchClaimByMemberId((long)7)).thenReturn(list);
		assertEquals(list,claimServ.fetchClaimByMemberId((long)8));
	}
	
		@Test
		public void getClaimbyClaimId() {
			Integer id = 12;
			Optional<Claim> c = Optional.ofNullable(new Claim(12,
					(long)10,
			    	(long)100,"This is for fever claims", LocalDate.of(2022, 11, 17),
					ClaimType.Medical));
			when(claimRepo.findById(12)).thenReturn(c);
			assertEquals(c,claimServ.fetchClaimById(id));
		}
		
		@Test
		public void getClaimbyClaimIdFailure() {
			Integer id = 15;
			Optional<Claim> c = Optional.ofNullable(new Claim(12,
					(long)10,
			    	(long)100,"This is for fever claims", LocalDate.of(2022, 11, 17),
					ClaimType.Medical));
			when(claimRepo.findById(12)).thenReturn(c);
			assertEquals(c,claimServ.fetchClaimById(id));
		}

}


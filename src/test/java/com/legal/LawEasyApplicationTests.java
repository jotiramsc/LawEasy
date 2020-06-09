package com.legal;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.legal.service.PartyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LawEasyApplicationTests {

	@Autowired
	PartyService partyService;
	@Test
	public void contextLoads() {
		 partyService.getAllParties();
		 assertNotEquals("", "");
		
	}

}

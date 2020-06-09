package com.legal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.legal.repository.MatterRepository;
import com.legal.repository.PartyRepository;

@SpringBootApplication
public class LawEasyApplication implements CommandLineRunner {

	@Autowired
	public MatterRepository matterRepository;

	@Autowired
	public PartyRepository partyRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LawEasyApplication.class, args);
		Logger logger = LoggerFactory.getLogger(LawEasyApplication.class);
		logger.error("--------- LawEasy application started --------");

	}

	@Override
	public void run(String... args) throws Exception {
		/*This block does not having anything
		 * We will add code if required
		 * 
		 */
	}

}

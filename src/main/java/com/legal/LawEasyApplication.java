package com.legal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.legal.domain.MatterDomain;
import com.legal.domain.PartyDomain;
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
		System.out.println("--------- LawEasy application started --------");
		
	}

	@Override 
	public void run(String... args) throws Exception {
//		MatterDomain matter=new MatterDomain();
//		matter.setsubject("Case registred under murder");
//		
//		PartyDomain p1=new PartyDomain();
//		p1.setFirstName("Jotiram");
//		
//		PartyDomain p2=new PartyDomain();
//		p2.setFirstName("Sarika");
//		
//		
//		matter.getParties().add(p1);
//		matter.getParties().add(p2);
//		
//		
//		matterRepository.save(matter);
//		
		
	}

}

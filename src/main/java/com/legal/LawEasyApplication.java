package com.legal;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.legal.domain.MatterDomain;
import com.legal.domain.PartyDomain;
import com.legal.domain.TimeLineDomain;
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
		
//		MatterDomain d=new MatterDomain();
//		d.setSubject("dfkjds skjdfhs");
//		PartyDomain p=new PartyDomain();
//		p.setFirstName("partname");
//		p.setLastName("partlastname");
//		p.setMatter(d);
//		TimeLineDomain lineDomain=new TimeLineDomain();
//		
//		lineDomain.setName("timline");
//		lineDomain.setDescription("This block does not having anythinggfg");
//		lineDomain.setStatus("active");
//		lineDomain.setMatter(d);
//		List<PartyDomain> list=new ArrayList<>();
//		list.add(p);
//		d.setParties(list);
//		
//		List<TimeLineDomain> tlist=new ArrayList<>();
//		tlist.add(lineDomain);		
//		d.setTimeLines(tlist);
//		
//		matterRepository.save(d);
//		
		
	}

}

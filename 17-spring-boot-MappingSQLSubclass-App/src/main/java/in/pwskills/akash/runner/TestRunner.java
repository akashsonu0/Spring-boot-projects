package in.pwskills.akash.runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.beans.PoliticalParty;
import in.pwskills.akash.service.IPoliticalMgmtService;


@Component
public class TestRunner implements CommandLineRunner {
	
	@Autowired
	private IPoliticalMgmtService service;
		
	@Override
	public void run(String... args) throws Exception {
		PoliticalParty party = service.fetchPoliticalPartyDetailsByPartyId(2);
		System.out.println(party);
		
		System.out.println("************************");
		
		service.fetchPoliticalPartiesByNames("congress", "bjp").forEach(System.out::println);
		
		int count = service.modifyFlagColorsByPartyName("yellow", "congress");
		System.out.println("No of rows modified are :: "+count);
		
		}

}

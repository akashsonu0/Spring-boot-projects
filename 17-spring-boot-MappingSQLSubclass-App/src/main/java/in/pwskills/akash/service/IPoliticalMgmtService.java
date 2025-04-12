package in.pwskills.akash.service;

import java.util.List;

import in.pwskills.akash.beans.PoliticalParty;

public interface IPoliticalMgmtService {
	
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(Integer partyId);
	public List<PoliticalParty> fetchPoliticalPartiesByNames(String partyName1,String partyName2);
	public int modifyFlagColorsByPartyName(String newColor,String partyName);
	
}

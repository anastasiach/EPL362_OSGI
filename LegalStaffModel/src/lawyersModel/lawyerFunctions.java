package lawyersModel;

import java.sql.ResultSet;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public interface lawyerFunctions {
	
	ResultSet getCases(int clientid);
	
	void updateClientRecord(int clientid, int caseid, String r, String l, int s, String c);
	
	ResultSet getLastComments(int clientid, int caseid);
	
	ResultSet getLastStrategy(int clientid, int caseid);
	
	ResultSet getLastOpinion(int clientid, int caseid);
	
	ResultSet getLastRecommendation(int clientid , int caseid);
	
	void updateRisk(int clientid, Boolean risk);
	
	ResultSet getCurrentRisk(int clientid);
	
	ResultSet getClients();
	
	ResultSet getSideEffects();

	ResultSet getRandevous(int lawyer_id);

	ResultSet getRandevouInfo(int clientid);

	

}

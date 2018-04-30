package receptionistModel;

import java.sql.ResultSet;

/**
 * This is the interface of the receptionistService
 * 
 * @author Anastasia, Anastasia, Antonia, Marina
 *
 */

public interface receptionistFunctions {
	
	ResultSet getClients();
	
	boolean checkAvaliability(String date, int time, int d_id);
	
	ResultSet getStaff(String branchid);
	
	ResultSet getInfoForClient(int id);
	
	String getBranchName(int id);
	
	boolean creareNewRandevou(int cid, String date, int time, String branch, int sid, int drop, int cancel, int update, int append);
	
	String[][] getClientRecord(int client_id);
	
    String[][] getRL(int client_id);
	
	ResultSet getRandevous ();
	
	String getLawyerName(int did);
	
	 boolean attendRandevou(int rid);
	 
	 ResultSet getRL1(int client_id);
	
	 ResultSet getClientRecord1(int client_id);
	
}

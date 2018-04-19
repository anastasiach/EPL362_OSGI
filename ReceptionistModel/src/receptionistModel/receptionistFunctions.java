package receptionistModel;

import java.sql.ResultSet;

public interface receptionistFunctions {
	
	ResultSet getClients();
	
	boolean checkAvaliability(String date, int time, int d_id);
	
	ResultSet getStaff(String branchid);
	
	ResultSet getInfoForClient(int id);
	
	String getCliniName(int id);
	
	boolean creareNewRandevou(int cid, String date, int time, String branch, int sid, int drop, int cancel, int update, int append);
	
	String[] getLastConditionAndMedicationOfPatient(int patient_id);
	
	ResultSet getRandevous ();
	
	String getLawyerName(int did);
	
	 boolean attendRandevou(int rid);
	
}


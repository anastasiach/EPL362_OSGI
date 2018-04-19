package receptionistModel;

import java.sql.ResultSet;

public interface receptionistFunctions {
	
	ResultSet getPatients();
	
	boolean checkAvaliability(String date, int time, int d_id);
	
	ResultSet getStaff(String clinic);
	
	ResultSet getInfoForPatient(int id);
	
	String getCliniName(int id);
	
	boolean creareNewRandevou(int pid, String date, int time, String clinic, int did);
	
	String[] getLastConditionAndMedicationOfPatient(int patient_id);
	
	ResultSet getRandevous ();
	
	String getDoctorName(int did);
	
	 boolean attendRandevou(int rid);
	
}

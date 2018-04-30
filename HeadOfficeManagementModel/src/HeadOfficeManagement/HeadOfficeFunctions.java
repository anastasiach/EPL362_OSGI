package HeadOfficeManagement;

import java.sql.ResultSet;

/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */

public interface HeadOfficeFunctions {
	
	ResultSet getBranches();
	String [][] getWeeklyReport(String branch);
	String [][]getWeeklyReportCase(String branch);
	String [][] getClientsCases(int client_id , int case_id);
    ResultSet getCases(int client_id);
    
    ResultSet getClientsCases1(int client_id, int case_id);
	
	ResultSet getClients();

}

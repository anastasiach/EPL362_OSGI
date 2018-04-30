package HeadOfficeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dataBaseConnect.connectDB;
import HeadOfficeManagement.HeadOfficeFunctions;

public class headServiceImpl implements HeadOfficeFunctions {
	/**
	 * Get the list of clients 
	 */
	@Override
	public ResultSet getClients(){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM client";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return null;
	}
	/**
	 * Get the cases for a specific client id
	 * 
	 */
	public ResultSet getCases(int client_id){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT CaseID FROM `clientrecord` WHERE ClientID = "+client_id+" GROUP BY CaseID";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return null;
	}
/**
 * 
 * Get a list of the branches 
 */
	public ResultSet getBranches(){
		try {
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `branch`";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
		return null;
	}
	/**
	 * Get the Weekly report by selecting a specific branch
	 */
	
	@Override
	public String[][] getWeeklyReport(String branch) {
		// TODO Auto-generated method stub
		try {
			connectDB connection = new connectDB();
			String [][] table = new String[7][3]; //weekly (7 days showing!)
			for(int i=0;i<table.length; i++){
				//posoi ekanan append sto randevou
				Integer attend = 0;
				String query = "SELECT * FROM `randevou`,`branch`  WHERE branch.Name = '"+branch+"' and randevou.BranchID = branch.BranchID and Append = 1 and Date = CURDATE() -"+i+";";
				connection.resSet = connection.stmt.executeQuery(query);
				while(connection.resSet.next()){
					attend++;
				}
				
				Integer client_incase = 0;
				String query1 = "SELECT * FROM `randevou`,`branch` ,`client`,`case` WHERE branch.Name = '"+branch+"' and randevou.BranchID = branch.BranchID and case.CaseID = client.CaseID and Date = CURDATE() -"+i+";";
				connection.resSet = connection.stmt.executeQuery(query1);
				while(connection.resSet.next()){
					client_incase++;
				}
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -i);

				table[i][0]=new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
				table[i][1]= attend.toString();
				table[i][2] = client_incase.toString();
				
			}
			
			return table;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
		return null;
	}
	/**
	 * Get the weekly report for the cases, for a specific branch
	 */
	public String[][] getWeeklyReportCase(String branch) {
		Integer n=0;
		Integer r=0;
		Integer l=0;
		try {
			ResultSet cases;
			connectDB connection = new connectDB();
			String query = "SELECT COUNT(*) FROM `case`";
			//cases=connection.resSet = connection.stmt.executeQuery(query);
			cases = connection.stmt.executeQuery( "SELECT CaseID FROM `case`");
			while(cases.next()){
				String str = cases.getString("CaseID");
				n = Integer.parseInt(str);
			}
			System.out.println(n);
			String [][] table = new String[n*7][5]; //weekly (7 days showing!)
			for(int i=0;i<table.length; i++){
				 r=0;
				 l=0;
				Integer client_incase = 0;
				String query1 = "SELECT * FROM `randevou`,`branch` ,`client`,`case` WHERE branch.Name = '"+branch+"' and randevou.BranchID = branch.BranchID and case.CaseID = client.CaseID and Date = CURDATE() -"+i+";";
				connection.resSet = connection.stmt.executeQuery(query1);
				while(connection.resSet.next()){
					client_incase++;
				}
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -i);
				
				ResultSet recom;
				recom = connection.stmt.executeQuery("Select clientrecord.Recommentation FROM `clientrecord`,`case` WHERE clientrecord.CaseID = case.CaseID AND clientrecord.Recommentation IS NOT NULL and Date = CURDATE() -"+i+";");
				while(recom.next()){	
					r++;
				}
				System.out.println(r);
				
				recom = connection.stmt.executeQuery("Select clientrecord.LegalOpinion FROM `clientrecord`,`case` WHERE clientrecord.CaseID = case.CaseID AND clientrecord.LegalOpinion IS NOT NULL and Date = CURDATE() -"+i+";");
				while(recom.next()){
					l ++;
				}
				System.out.println(l);

				table[i][0]=n.toString();
				table[i][1]= client_incase.toString();
				table[i][2]=r.toString();
				table[i][3]=l.toString();
				table[i][4] = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
				
			}
			
			return table;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
		return null;
		
	}
	/**
	 * Get the case for a specific client
	 */
	
	public ResultSet getClientsCases1(int client_id, int case_id){
		
		try {
			connectDB connection = new connectDB();
			String query = "SELECT RecordID, Recommentation , LegalOpinion FROM `clientrecord` WHERE ClientID = "+client_id+" AND CaseID = "+case_id+" ";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
		return null;
		
	}
	
	
	/**
	 * Get the case for a specific client
	 */
	
	
	
	public String[][] getClientsCases(int client_id, int case_id) {
		int count = 0;
		// TODO Auto-generated method stub
	
		try{
			ResultSet cases;
			connectDB connection = new connectDB();
			cases = connection.stmt.executeQuery( "SELECT RecordID , CaseID FROM `clientrecord` WHERE CaseID = "+case_id+" AND ClientID = "+client_id+" ");
			while(cases.next()){
				String str = cases.getString("RecordID");
				//count = Integer.parseInt(str);
				count++;
			}
			System.out.println(count);
			String [][] ReturnTable = new String [count][2];
			for(int i=0;i<ReturnTable.length; i++){
				
				String query = "SELECT RecordID, Recommentation , LegalOpinion FROM `clientrecord` WHERE ClientID = "+client_id+" AND CaseID = "+case_id+" ";
				connection.resSet = connection.stmt.executeQuery(query);
				
				
				if(connection.resSet.next()){
				ReturnTable[i][0] = connection.resSet.getString("Recommentation").toString();
				ReturnTable[i][1] = connection.resSet.getString("LegalOpinion").toString();
				}
				
			}
			
			return ReturnTable;
			
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return null;
		
		
		
	}


}

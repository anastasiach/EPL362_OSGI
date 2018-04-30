package receptionistService;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataBaseConnect.connectDB;
import receptionistModel.receptionistFunctions;

public class receptionistService implements receptionistFunctions {

	
	
	
	/**
	 * This is a query to get all clients from the database
	 * 
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
	 * This is a query to check if a date is available to create a randevou
	 * @param date is the date
	 * @param time is the time
	 * @l_id is the lawyer that will see the client 
	 */
	
	public boolean checkAvaliability(String date, int time, int l_id){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM randevou WHERE Date = '"+date+"' and Time = "+time+" and StaffID="+l_id+";";
			connection.resSet = connection.stmt.executeQuery(query);
			if(connection.resSet.next()){
				return false;
			}
			return true;
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		
		return false;
	}

	
	/**
	 * this is a query to see a staff's info
	 * 
	 * @param branch is the name of the company branch
	 */
	public ResultSet getStaff(String branch){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `staff`,`branch` WHERE Lawyer = 1 and branch.Name='"+branch+"';";
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
	 * this is a query to get a client's info
	 * 
	 * @param id the id of the client
	 */
	public ResultSet getInfoForClient(int id){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `client` WHERE ClientID="+id;
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
	 * This query is to get the branch name
	 */
	public 	String getBranchName(int id){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `staff`, `branch` WHERE staff.BranchID = branch.BranchID and StaffID="+id;
			connection.resSet = connection.stmt.executeQuery(query);
			if(connection.resSet.next()){
				String clinic = connection.resSet.getString("Name"); //branch name
				return clinic;
			}
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return null;
	}
	
	/**
	 * This query is to create a new randevou
	 * 
	 * @param cid is the client id
	 * @param date is the date of the new randevou
	 * @param time is the time of the new randevou
	 * @param branch is the branch where the randevou will take placce
	 * @param sid is the staff id
	 * @param drop is to note if the client has droped in
	 * @param cancel is to cancel the randevou
	 * @param update is to make a change
	 * @param append is to note if the client appended
	 */
	public 	boolean creareNewRandevou(int cid, String date, int time, String branch, int sid, int drop, int cancel, int update, int append){
		try {
			connectDB connection = new connectDB();
			String query1= "INSERT INTO randevou (Date, Time,ClientID, StaffID, BranchID, DropIn, Canceled, Updated, Append) VALUES ('"
			+date+"' ,"+time+", "+cid+", "+sid+", '"+branch+"', "+drop+", "+cancel+", "+update+", "+append+");";
			
			
			System.out.println(query1);
			connection.stmt.executeUpdate(query1); 
			return true;
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      return false;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
			return false;
		}
		
	}
	
	
	/**
	 * This query is to get the records of a client
	 * 
	 * @param client_id is the id of the client
	 */
	public ResultSet getClientRecord1(int client_id){
		try {
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `clientrecord` WHERE ClientID = "+client_id+" ";
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
	 * This query is to get the records of a client
	 * 
	 * @param client_id is the id of the client
	 */
	public String[][] getClientRecord(int client_id) {
		int count = 0;
		// TODO Auto-generated method stub
	
		try{
			ResultSet cases;
			connectDB connection = new connectDB();
			cases = connection.stmt.executeQuery( "SELECT RecordID FROM `clientrecord` WHERE ClientID = "+client_id+" ");
			while(cases.next()){
				String str = cases.getString("RecordID");
				count = Integer.parseInt(str);
				//count++;
			}
			
			String [][] ReturnTable = new String [count][5];
			for(int i=0;i<ReturnTable.length; i++){
				String query = "SELECT * FROM `clientrecord` WHERE ClientID = "+client_id+" ";
				connection.resSet = connection.stmt.executeQuery(query);
				
				
				if(connection.resSet.next()){
				ReturnTable[i][0] = connection.resSet.getString("RecordID").toString();
				ReturnTable[i][1] = connection.resSet.getString("CaseID").toString();
				ReturnTable[i][2] = connection.resSet.getDate("Date").toString();
				ReturnTable[i][3] = connection.resSet.getString("Recommentation").toString();
				ReturnTable[i][4] = connection.resSet.getString("LegalOpinion").toString();
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
	
	/**
	 * THis query is to get the recomendation and legal opinion given to the client
	 */
	public ResultSet getRL1(int client_id){
		
		try {
			connectDB connection = new connectDB();
			String query = "SELECT Recommentation , LegalOpinion FROM `clientrecord` WHERE ClientID = "+client_id+" ";
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
	
	
	//Get client's recommendations and Legal Opinions
	public String[][] getRL(int client_id) {
		int count = 0;
		// TODO Auto-generated method stub
	
		try{
			ResultSet cases;
			connectDB connection = new connectDB();
			cases = connection.stmt.executeQuery( "SELECT RecordID FROM `clientrecord` WHERE ClientID = "+client_id+" ");
			while(cases.next()){
				String str = cases.getString("RecordID");
				count = Integer.parseInt(str);
			}
			
			String [][] ReturnTable = new String [count][2];
			for(int i=0;i<ReturnTable.length; i++){
				String query = "SELECT Recommentation , LegalOpinion FROM `clientrecord` WHERE ClientID = "+client_id+" ";
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
	
	public 	ResultSet getRandevous (){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `randevou`, `client` ,`staff`  WHERE randevou.ClientID = client.ClientID and randevou.StaffID = staff.StaffID and staff.Lawyer = '1' and  randevou.Date = CURDATE() and randevou.Append=0;";
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
	 * This query is to get the Lawyer's name
	 * 
	 * @param did is the id of the lawyer
	 */
	public String getLawyerName(int did){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `staff` WHERE StaffID = "+did+";";
			connection.resSet = connection.stmt.executeQuery(query);
			
			if(connection.resSet.next()){
				return connection.resSet.getString("FirstName");
			}
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		
		return null;
	}
	
	
	/**
	 * This query is to note if the client has attended the randevou
	 * 
	 */
	public boolean attendRandevou(int rid){
		
		try {
			connectDB connection = new connectDB();
			String query1= "UPDATE randevou SET  Append = '1' WHERE AppointmentID = "+rid+";";
					System.out.println(query1);
			connection.stmt.executeUpdate(query1); 
			return true;
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return false;
	}


	


}

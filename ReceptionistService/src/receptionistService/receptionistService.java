package receptionistService;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataBaseConnect.connectDB;
import receptionistModel.receptionistFunctions;

public class receptionistService implements receptionistFunctions {

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
	
	public 	String getCliniName(int id){
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
	
	public String[] getLastConditionAndMedicationOfPatient(int client_id) {
		// TODO Auto-generated method stub
	
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `randevou` WHERE ClientID = "+client_id+" and date IN (SELECT max(date) FROM `randevou` WHERE Date < CURDATE() and Append = 1 and Updated = 1 and ClientID = "+client_id+")";
			connection.resSet = connection.stmt.executeQuery(query);
			//return connection.resSet;
			String cond;
			int med;
			String [] ReternTable = new String [2];
			if(connection.resSet.next()){
				ReternTable[0] = connection.resSet.getString("Conditions");
				med = connection.resSet.getInt("Medication_ID");
				
				String q = "SELECT * FROM `drugs` WHERE Medication_ID ="+med+";";
				connection.resSet = connection.stmt.executeQuery(q);
				if(connection.resSet.next()){
					ReternTable[1] = connection.resSet.getString("Medication_Name");
					return ReternTable;
				}
				
			}
			
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

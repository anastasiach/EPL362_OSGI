package secretaryService;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataBaseConnect.connectDB;
import secretaryModel.secretaryFunctions;
/**
 * Method that get the side effects of strategy 
 * 
 */
public class secretaryFunctionImpl implements secretaryFunctions{
	/**
	 * method to get the clients
	 */
	public ResultSet getClients(){
		
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `client`";
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
	 * method to get information about client
	 * 
	 * @param id
	 */
	
	

	@Override
	public ResultSet getInfoForClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

package lawyersService;

import java.sql.ResultSet;
import java.sql.SQLException;

import lawyersModel.lawyerFunctions;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

import dataBaseConnect.connectDB;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class lawyerFunctionImpl implements lawyerFunctions {
	
	
	/**
	 * Method the return the cases of client id
	 */
	public ResultSet getCases(int clientid){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT CaseID FROM `clientrecord` WHERE ClientID = "+clientid+" GROUP BY CaseID";
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
	 * Method that the user can update client records.
	 * 
	 * @param clientid
	 * @param caseid
	 * @param r recommentation
	 * @param l legal opinion
	 * @param c legal strategy
	 * 
	 * 
	 */
	
	public void updateClientRecord(int clientid, int caseid, String r, String l, int s, String c){
		
		try{
			connectDB connection = new connectDB();
			String query = "INSERT INTO `clientrecord` (ClientID, CaseID, Date, Recommentation, LegalOpinion, LegalStrategyID , Comments) VALUES ("+clientid+", "+caseid+", CURDATE() ,'"+r+"', '"+l+"', "+s+", '"+c+"' )";
			connection.stmt.executeUpdate(query);
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		
	}
	/**
	 * Method that return the last recommendation
	 * 
	 * @param clientid
	 * @param caseid
	 */
	
	public ResultSet getLastRecommendation(int clientid, int caseid){

		try{
			connectDB connection = new connectDB();
			String query = "SELECT Recommentation, Date FROM `clientrecord` Where Date IN(SELECT max(Date) FROM `clientrecord` WHERE ClientID="+clientid+" AND CaseID="+caseid+")";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
			
	}
	/**
	 * Method that return the last legal opinion of client
	 * 
	 * @param clientid
	 * @param caseid
	 */
	public ResultSet getLastOpinion(int clientid, int caseid){

		try{
			connectDB connection = new connectDB();
			String query = "SELECT LegalOpinion, Date FROM `clientrecord` Where Date IN(SELECT max(Date) FROM `clientrecord` WHERE ClientID="+clientid+" AND CaseID="+caseid+")";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
			
	}
	/**
	 * Method that return the last legal strategy of client
	 * 
	 * @param clientid
	 * @param caseid
	 */
	public ResultSet getLastStrategy(int clientid, int caseid){

		try{
			connectDB connection = new connectDB();
			String query = "SELECT LegalStrategyID, Date FROM `clientrecord` Where Date IN(SELECT max(Date) FROM `clientrecord` WHERE ClientID="+clientid+" AND CaseID="+caseid+")";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
			
	}
	/**
	 * Method that return the last comments of client
	 * 
	 * @param clientid
	 * @param caseid
	 */
	public ResultSet getLastComments(int clientid, int caseid){

		try{
			connectDB connection = new connectDB();
			String query = "SELECT Comments, Date FROM `clientrecord` Where Date IN(SELECT max(Date) FROM `clientrecord` WHERE ClientID="+clientid+" AND CaseID="+caseid+")";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
			
	}
	/**
	 * Method to update the risk of client
	 * 
	 * @param clientid
	 * @param risk
	 */

	public void updateRisk(int clientid, Boolean risk){
		
		try{
			connectDB connection = new connectDB();
			String query = "UPDATE `client`  SET RiskStatus="+risk+" WHERE ClientID="+clientid+" ";
			connection.stmt.executeUpdate(query);
			//return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}

		
		
	}
	/**
	 * Method to get the current risk of client
	 * 
	 * @param clientid
	 */

	public ResultSet getCurrentRisk(int clientid){
		

		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `client` WHERE ClientID="+clientid+" ";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
		
	}
	/**
	 * Method to get the side effects of strategy 
	 * 
	 */
	public ResultSet getSideEffects(){
		
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `legalstrategy` ";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
		
	}
	
	/**
	 * Method to get the clients
	 * 
	 */
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
	 * Method to get the randevous of clients
	 * 
	 */
	
	public ResultSet getRandevous(int lawyer_id){
		try{
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `client` , `randevou` WHERE client.ClientID = randevou.ClientID AND  randevou.StaffID="+lawyer_id+" AND randevou.Date =CURDATE()  ";
			connection.resSet = connection.stmt.executeQuery(query);
			return connection.resSet;
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception ex){
			System.out.println("Eroor"+ ex);
		}
		return null;
		
	}
	/**
	 * Method to get the information about randevous
	 * 
	 * @param clientid
	 * 
	 */
	@Override
	public ResultSet getRandevouInfo(int clientid) {
		// TODO Auto-generated method stub
		try {
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `randevou` WHERE randevou.ClientID = "+clientid+"";
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

	

}

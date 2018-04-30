package loginService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import loginModel.loginFunction;
import dataBaseConnect.connectDB;

public class loginImpl implements loginFunction {
	
	/**
	 * Query to insert the data, to get a succesfull login in the system
	 * 
	 */
	@Override
	public int[] login(String username, String password) {
		// TODO Auto-generated method stub.
		try{
			//connectDB connection = new connectDB();
			connectDB connection = new connectDB();
			String query = "SELECT * FROM `staff` WHERE staff.Username = '"+username+"' and staff.Password = '"+password+"' ;";
			connection.resSet = connection.stmt.executeQuery(query);

			int[] a = new int[2];
			
			//ResultSet rs = factory.getRandevous(1111);
			try {
				if (connection.resSet.next()) {
					
					if (connection.resSet.getInt("Lawyer")==1) 
						a[0]=0;	
					if (connection.resSet.getInt("Secretary")==1) 
						a[0]=1;
					if (connection.resSet.getInt("Receptionist")==1) 
						a[0]=2;
					if (connection.resSet.getInt("Manager")==1) 
						a[0]=3;
					
					WriteFile(connection.resSet.getString(1),connection.resSet.getString(2));
				}
				else{
					a[0]=-1;
					return a;
				}				
				a[1]=connection.resSet.getInt("StaffID");
				return a;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}catch(SQLException se){
		      se.printStackTrace();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		
		
		return null;
	}
	
	
	
	/**
	 * 
	 * @param id of staff
	 * @param name of staff
	 * 
	 * Function to save all the logins that have been made to the system
	 */
	static void WriteFile(String id,String name){
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		try {
          PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logFile.txt", true)));
          out.println(id +" "+name+" "+timeStamp);
          out.close();

	    } catch ( IOException e ) {
	       e.printStackTrace();
	    }
        
        
	}
	

}

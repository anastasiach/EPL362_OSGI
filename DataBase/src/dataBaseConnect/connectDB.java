package dataBaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class connectDB {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	/**
	 * 
	 * @throws Exception
	 */

	public connectDB() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EPL362", "root","2016");
			stmt = conn.createStatement();
			
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}

	public static void main(String [] args) throws Exception{
		connectDB a = new connectDB();
	}

}

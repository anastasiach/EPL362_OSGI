package secretary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;

import dataBaseConnect.connectDB;
import secretaryModel.secretaryFunctions;
import secretaryFactory.secretaryServiceFactory;










import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Client_list extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ArrayList<Integer>l = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_list frame = new Client_list(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client_list(int ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Client List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(26, 30, 459, 349);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 424, 269);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		/*****************************LOAD LIST***************************************/
		DefaultTableModel model = new DefaultTableModel(0, 0);
		
		table.setModel(model);
		
		String header[] = new String[] { "Client ID","First Name", "Last Name" };
		model.setColumnIdentifiers(header);	
		
		
		secretaryFunctions factory= secretaryServiceFactory.getFactory();
		ResultSet rs = factory.getClients();
		
		
		try {
			int count=0;
			while (rs.next()) {
				Integer id = rs.getInt("ClientID");
				String name1 = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				
				//int sh = rs.getInt("Self_Harm");
				model.addRow(new Object[] { id, name1,lastname});
				l.add(id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**************************************************************/

		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 295, 117, 20);
		panel_1.add(textField);
		
		JButton button = new JButton("Download");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*final int no = Integer.parseInt(textField.getText()); 
				if (l.contains(no)){
					
				}
				//clientRecord frame = new clientRecord(no);
				//frame.setVisible(true);
				setVisible(false);*/
				//List data = new ArrayList();
				int client = Integer.parseInt(textField.getText());
				
				List<String> data = new ArrayList<String>();
				data.add("RecordID ClientID CaseID Date Recommendation LegalOpinion StrategyID Comments ");
		        try {
		        		//connectDB con = new connectDB();
		        		//String query = "SELECT * FROM `client`";
		    			//connection.resSet = connection.stmt.executeQuery(query);
		              //  Statement st = con.createStatement();
		        		Connection con = null;
	                    Class.forName("com.mysql.jdbc.Driver");
	                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EPL362", "root","2016");
	                    Statement st = con.createStatement();
		                ResultSet rs = st.executeQuery("Select * from `clientrecord` WHERE ClientID="+client+"");
		                System.out.println(client);
		                
		                while (rs.next()) {
		                		Integer record = rs.getInt("RecordID");
		                        Integer id1 = rs.getInt("ClientID");
		                        Integer caseid = rs.getInt("CaseID");
		                        String date = rs.getString("Date");
		                        String rec = rs.getString("Recommentation");
		                        String leg = rs.getString("LegalOpinion");
		                        Integer str = rs.getInt("LegalStrategyID");
		                        String com = rs.getString("Comments");
		                        data.add(record + " " +id1 + " " + caseid + " " + date + " " + rec+ " "+leg+ " "+ str+ " " +com);

		                }
		                writeToFile(data, "C:/Users/User/Desktop/Project 362/Client.txt");
		                rs.close();
		                st.close();
		                System.out.print("File downloaded");
		        } catch (Exception e) {
		                System.out.println(e);
		        }
		}

			
		});
		button.setBounds(85, 320, 101, 23);
		panel_1.add(button);
		
		JButton upload = new JButton("Upload");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int record;
			    int clientid;
			    int caseid;
			    String date;
			    String rec;
			    String leg;
			    int str;
			    String com;
			    java.sql.PreparedStatement ps = null;
			  //  Connection con = null;
			    ResultSet rs = null;
				
				 try
				    {
				        BufferedReader br = new BufferedReader(new FileReader("C:/Users/User/Desktop/Project 362/Client.txt"));
				        Connection con = null;
	                    Class.forName("com.mysql.jdbc.Driver");
	                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EPL362", "root","2016");
				        String line = null;
				       line = br.readLine(); 
				        while ((line = br.readLine()) != null)
				        {
		
				        	    
				            String tmp[] = line.split(" ");
				           record = Integer.parseInt(tmp[0]);
				            clientid = Integer.parseInt(tmp[1]);
				            caseid = Integer.parseInt(tmp[2]);
				            date = tmp[3];
				            rec = tmp[4];
				            leg = tmp[5];
				            str = Integer.parseInt(tmp[6]);
				            com = tmp[7];

				            System.out.println(record+ " \t"+ clientid + "\t" + caseid + "\t" + date +"\t" + rec +"\t" + leg +"\t" + str+"\t" + com );
				            String sql =
				                    "UPDATE `clientrecord` SET ClientID= "+clientid+", CaseID="+caseid+", Date='"+date+"', Recommentation='"+rec+"', LegalOpinion='"+leg+"', LegalStrategyID="+str+", Comments='"+com+"' WHERE RecordID="+record+"";

				            ps = con.prepareStatement(sql);
				            ps.executeUpdate();
				        	}
				        

				        br.close();
				        con.close();
				        ps.close();

				    }
				    catch (IOException | ClassNotFoundException | SQLException e)
				    {
				        e.printStackTrace();
				    }
				
			}
		});
		upload.setBounds(200, 320, 101, 23);
		panel_1.add(upload);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				secretary_gui frame = new secretary_gui(ID);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		buttonBack.setBounds(320, 320, 101, 23);
		panel_1.add(buttonBack);
		
		JLabel lblSelectPatientNumber = new JLabel("Select Client ID:");
		lblSelectPatientNumber.setBounds(20, 291, 149, 29);
		panel_1.add(lblSelectPatientNumber);
	}
	
	private static void writeToFile(java.util.List<String> list, String path) {
        BufferedWriter out = null;
        try {
                File file = new File(path);
                out = new BufferedWriter(new FileWriter(file, true));
                for (String s : list) {
                        out.write(s);
                        out.newLine();

                }
                out.close();
        } catch (IOException e) {
        }
		
		
	}
}

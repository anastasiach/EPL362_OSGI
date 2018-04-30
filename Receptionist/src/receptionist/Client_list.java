package receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;







import receptionistFactory.receptionistFactory;
import receptionistModel.receptionistFunctions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * This class is to show the Client list
 * @author  Anastasia, Anastasia, Antonia, Marina
 *
 */
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
					Client_list frame = new Client_list(1,0);
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
	public Client_list(int ID, int choise) {
		System.out.println(ID);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 457);
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
		panel_1.setBounds(26, 30, 476, 368);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 424, 269);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		/*****************************LOAD LIST***************************************/
		DefaultTableModel model = new DefaultTableModel(0, 0);
		
		table.setModel(model);
		
		String header[] = new String[] { "Client ID","Name" };
		model.setColumnIdentifiers(header);	
		
		receptionistFunctions factory = receptionistFactory.getFactory();	
		ResultSet rs = factory.getClients();
		
		try {
			int count=0;
			while (rs.next()) {
				Integer id = rs.getInt("ClientID");
				String name1 = rs.getString("FirstName");
				//int sh = rs.getInt("Self_Harm");
				model.addRow(new Object[] { id, name1});
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
		
		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				String s=textField.getText();
				if (choise == 0){
					if (s.matches("[0-9]+")) {
						final int no = Integer.parseInt(textField.getText()); 
						if(l.contains(no)){
							Clients_show_GUI frame = new Clients_show_GUI( ID ,no);
							frame.setVisible(true);
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null,"Error! error input",
								    "Insert error",
								    JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						System.out.print("oxi");
						JOptionPane.showMessageDialog(null,"Erron! error input",
							    "Insert error",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					final int no = Integer.parseInt(textField.getText()); 
					receptionistFunctions factory = receptionistFactory.getFactory();	
					String [][] condMed = factory.getClientRecord(no);
					/*if (condMed != null){
						lastTretment frame = new lastTretment(ID, no, condMed[0], condMed[1]);
						frame.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null,"No result",
							    "No previous Prescriptions",
							    JOptionPane.ERROR_MESSAGE);
					} */
				}
				
				
				
				
				
			}
		});
		button.setBounds(320, 294, 101, 23);
		panel_1.add(button);
		
		JLabel lblSelectPatientNumber = new JLabel("Select Client Number:");
		lblSelectPatientNumber.setBounds(20, 291, 149, 29);
		panel_1.add(lblSelectPatientNumber);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Receptionist_GUI frame = new Receptionist_GUI(ID);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(320, 334, 101, 23);
		panel_1.add(btnNewButton);
	}
}

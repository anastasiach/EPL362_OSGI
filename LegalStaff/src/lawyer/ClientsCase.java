package lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import lawyerFactory.lawyerServiceFactory;
import lawyersModel.lawyerFunctions;

/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */

public class ClientsCase extends JFrame  {
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ArrayList<Integer>l = new ArrayList<Integer>();
	private Integer id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsCase frame = new ClientsCase(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Gives the cases of client
	 * @param client_id
	 */
	public ClientsCase(int client_id){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Cases List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		String header[] = new String[] { "Case ID"  };
		model.setColumnIdentifiers(header);	
		
		lawyerFunctions factory = lawyerServiceFactory.getFactory();
		ResultSet rs = factory.getCases(client_id);
		
		try {
			int count=0;
			while (rs.next()) {
				Integer id = rs.getInt("CaseID");
				
				model.addRow(new Object[] { id});
				l.add(id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**************************************************************/

		//int casee = id;
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 295, 117, 20);
		panel_1.add(textField);
		
		JButton button = new JButton("Go");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				String s=textField.getText(); //case
				int caseid = Integer.parseInt(s);
				
				client_record_gui frame = new client_record_gui(client_id);
				frame.setVisible(true);
				setVisible(false);
				
	
				
				
			}
		});
		button.setBounds(320, 294, 101, 23);
		panel_1.add(button);
		
		JLabel lblSelectPatientNumber = new JLabel("Select Case Number:");
		lblSelectPatientNumber.setBounds(20, 291, 149, 29);
		panel_1.add(lblSelectPatientNumber);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Client_list frame = new Client_list(1);
				frame.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnNewButton.setBounds(320, 334, 101, 23);
		panel_1.add(btnNewButton);
	
	
	}
	

}

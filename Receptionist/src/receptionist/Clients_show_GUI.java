package receptionist;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;




//import HeadOffice.ClientsAttend;
//import HeadOfficeFactory.HeadOfficeFactoryService;
//import HeadOfficeManagement.HeadOfficeFunctions;
import receptionistFactory.receptionistFactory;
import receptionistModel.receptionistFunctions;

/**
 * This is the GUI to show the clients to the receptionist
 * @author  Anastasia, Anastasia, Antonia, Marina
 *
 */

public class Clients_show_GUI extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String> l = new ArrayList<String>();
	private ArrayList<String> l1 = new ArrayList<String>();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients_show_GUI frame = new Clients_show_GUI(0,1);
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
	//ID = 0 -> View Client Record
	//ID = 1 -> View Reccomendations & Legal Opinions!
	public Clients_show_GUI(int ID, int client_id) {
		
		if(ID==0){
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 128), 3), "Client Record",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(26, 30, 545, 361);
		panel.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 11, 424, 269);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel(0, 0);

		table.setModel(model);

		String header[] = new String[] { "RecordID", "CaseID", "Date","Recommendation", "Legal Opinions" };
		model.setColumnIdentifiers(header);
		
		ArrayList<String> records = new ArrayList<String>();
		ArrayList<String> cases = new ArrayList<String>();
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> recs = new ArrayList<String>();
		ArrayList<String> legals = new ArrayList<String>();
		

		receptionistFunctions factory = receptionistFactory.getFactory();
		ResultSet rs = factory.getClientRecord1(client_id);
		
		try {
			while (rs.next()) {
				
				String record = rs.getString("RecordID");
				records.add(record);
				String casee = rs.getString("CaseID");
				cases.add(casee);
				String date = rs.getString("Date");
				dates.add(date);
				String rec = rs.getString("Recommentation");
				recs.add(rec);
				String legal = rs.getString("LegalOpinion");
				legals.add(legal);
				
				model.addRow(new Object[] { record, casee, date, rec, legal });
				l.add(rec);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String[][] table = factory.getClientRecord(client_id); //!!!!
		for(int i=0;i<table.length;i++){
			model.addRow(new Object[] { table[i][0], table[i][1], table[i][2],table[i][3],table[i][4]});
		}

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Client_list frame = new Client_list(ID,0);

				 frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setBounds(195, 305, 101, 23);
		panel_1.add(btnBack);

	}
		else if (ID==1){
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 620, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setForeground(Color.BLACK);
			panel.setBorder(new TitledBorder(
					new LineBorder(new Color(0, 0, 128), 3), "Reccomendations & Legal Opinions",
					TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			contentPane.add(panel, BorderLayout.CENTER);

			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
			panel_1.setBackground(new Color(173, 216, 230));
			panel_1.setBounds(26, 30, 545, 361);
			panel.add(panel_1);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 11, 424, 269);
			panel_1.add(scrollPane);

			table = new JTable();
			scrollPane.setViewportView(table);

			DefaultTableModel model = new DefaultTableModel(0, 0);

			table.setModel(model);

			String header[] = new String[] { "Recommendation", "Legal Opinions" };
			model.setColumnIdentifiers(header);

			ArrayList<String> recs = new ArrayList<String>();
			ArrayList<String> legals = new ArrayList<String>();
			
			receptionistFunctions factory = receptionistFactory.getFactory();
			ResultSet rs = factory.getRL1(client_id);
			try {
				while (rs.next()) {

					String rec = rs.getString("Recommentation");
					recs.add(rec);
					String legal = rs.getString("LegalOpinion");
					legals.add(legal);
					
					model.addRow(new Object[] { rec, legal });
					l.add(rec);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			/*String[][] table = factory.getRL(client_id); //!!!!
			for(int i=0;i<table.length;i++){
				model.addRow(new Object[] { table[i][0], table[i][1]});
			}*/

			JButton btnBack = new JButton("Back");
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Client_list frame = new Client_list(ID,0);

					 frame.setVisible(true);
					setVisible(false);
				}
			});
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnBack.setBounds(195, 305, 101, 23);
			panel_1.add(btnBack);
			
		}
		
		
		

	}
}

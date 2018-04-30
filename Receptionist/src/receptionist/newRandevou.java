package receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import receptionistFactory.receptionistFactory;
import receptionistModel.receptionistFunctions;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is to create a new appointment 
 * @author  Anastasia, Anastasia, Antonia, Marina
 *
 */
public class newRandevou extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newRandevou frame = new newRandevou("1", 1);
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
	//lb -> branchID
	public newRandevou(String lb, int rec_id) {
		setBounds(100, 100, 575, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "New Randevou", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(24, 25, 497, 368);
		panel.add(panel_1);
		
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientId.setBounds(10, 23, 77, 21);
		panel_1.add(lblClientId);
		
		textField = new JTextField();
		textField.setBounds(97, 23, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblBranchId = new JLabel("Branch ID:");
		lblBranchId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBranchId.setBounds(230, 23, 77, 21);
		panel_1.add(lblBranchId);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 23, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		/*JLabel lblLawers = new JLabel("Lawers:");
		lblLawers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLawers.setBounds(10, 79, 57, 14);
		panel_1.add(lblLawers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 79, 376, 115);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		/*****************************LOAD LIST***************************************/
		//DefaultTableModel model = new DefaultTableModel(0, 0);
		
		/*table.setModel(model);
		
		String header[] = new String[] { "Lawer ID","Name" };
		model.setColumnIdentifiers(header);	
		
		
		receptionistFunctions factory = receptionistFactory.getFactory();	
		ResultSet rs = factory.getStaff(lb); 
		
		try {
			while (rs.next()) {
				
				Integer id = rs.getInt("StaffID");
				String name1 = rs.getString("Name");
				model.addRow(new Object[] { id, name1});
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/**************************************************************/
		
		JLabel lblLawerId = new JLabel("Lawer ID:");
		lblLawerId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLawerId.setBounds(10, 75, 77, 14);
		panel_1.add(lblLawerId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 75, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDropin = new JLabel("Drop in:");
		lblDropin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDropin.setBounds(230, 75, 77, 14);
		panel_1.add(lblDropin);
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 75, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(10, 120, 46, 14);
		panel_1.add(lblDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 120, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblYyyy = new JLabel("(yyyy-mm-dd)");
		lblYyyy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYyyy.setBounds(200, 120, 86, 14);
		panel_1.add(lblYyyy);
		
		JButton btnCheckAva = new JButton("Check Availability");
		btnCheckAva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dt = textField_2.getText();
				final int did = Integer.parseInt(textField_1.getText());
				int t = comboBox.getSelectedIndex() + 8;
				receptionistFunctions factory = receptionistFactory.getFactory();	
				if (factory.checkAvaliability(dt, t, did)){
					
					JOptionPane.showMessageDialog(null, "The day and Time is available");
					
				}else{
					JOptionPane.showMessageDialog(null,"There is other randevou that time!",
						    "Insert error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCheckAva.setBounds(230, 180, 142, 23);
		panel_1.add(btnCheckAva);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTime.setBounds(10, 180, 46, 14);
		panel_1.add(lblTime);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"}));
		comboBox.setBounds(97, 180, 86, 20);
		panel_1.add(comboBox);
		
		
		
		JButton btnCreatRandevou = new JButton("Creat Randevou");
		btnCreatRandevou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////////////////////////////////////////////
				int cid = Integer.parseInt(textField.getText());
				String date = textField_2.getText();
				final int sid = Integer.parseInt(textField_1.getText());
				String branch = textField_3.getText();
				int dropin = Integer.parseInt(textField_4.getText());
				System.out.println("AAAAAAAAAAAAAAAAAAAA"+sid);
				int time = comboBox.getSelectedIndex() + 8;
				receptionistFunctions factory = receptionistFactory.getFactory();	
				
				if (factory.creareNewRandevou(cid, date, time,branch /*lb */, sid, dropin,0,0,0)){
					JOptionPane.showMessageDialog(null, "New Randevou Added!");
					Receptionist_GUI frame = new Receptionist_GUI(rec_id);
					frame.setVisible(true);
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,"Erron! Could not add randevou",
						    "Insert error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCreatRandevou.setBounds(148, 250, 177, 23);
		panel_1.add(btnCreatRandevou);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Receptionist_GUI frame = new Receptionist_GUI(rec_id);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(148, 300, 101, 23);
		panel_1.add(btnNewButton);
		
		
	}
}

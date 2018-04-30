package lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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

public class RiskStatus extends JFrame {
	
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
					RiskStatus frame = new RiskStatus(2);
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
	public RiskStatus(int client_id) {
		setBounds(100, 100, 575, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Client's Risk Status", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(24, 25, 497, 368);
		panel.add(panel_1);
		
		JLabel lblClientId = new JLabel("Current Risk Status:");
		lblClientId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientId.setBounds(10, 23, 150, 21);
		panel_1.add(lblClientId);
		
	
		
		lawyerFunctions factory = lawyerServiceFactory.getFactory();	
		ResultSet rs = factory.getCurrentRisk(client_id);
		Boolean r=null;
		String risk="";
		
		
		
		try {
			while (rs.next()) {
				
				r = rs.getBoolean("RiskStatus");
				risk = String.valueOf(r);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel current = new JLabel(risk.toUpperCase());
		current.setFont(new Font("Tahoma", Font.BOLD, 14));
		current.setBounds(152, 23, 86, 20);
		panel_1.add(current);
		
		JLabel lblBranchId = new JLabel("Update Risk Status:");
		lblBranchId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBranchId.setBounds(10, 70, 150, 21);
		panel_1.add(lblBranchId);
		
		
		textField = new JTextField();
		textField.setBounds(152, 70, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		JButton btnCreatRandevou = new JButton("Save");
		btnCreatRandevou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////////////////////////////////////////////
				
				String risk = textField.getText();
				Boolean b = Boolean.parseBoolean(risk);
				
				System.out.print(b);
				lawyerFunctions factory = lawyerServiceFactory.getFactory();	
				factory.updateRisk(client_id ,b);
				
				lawyerFunctions factory1 = lawyerServiceFactory.getFactory();	
				factory1.getClients();
				lawyer_gui frame = new lawyer_gui(1);
				frame.setVisible(true);
				setVisible(false);
				
				
				
			}
		});
		btnCreatRandevou.setBounds(148, 250, 101, 23);
		panel_1.add(btnCreatRandevou);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Client_list frame = new Client_list(0);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(148, 300, 101, 23);
		panel_1.add(btnNewButton);
		
		
	}

}

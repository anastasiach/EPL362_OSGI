package lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import lawyerFactory.lawyerServiceFactory;
import lawyersModel.lawyerFunctions;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class client_record_gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JComboBox comboBox;
	private JTextArea textArea_1;
	private JTextArea textArea;
	JRadioButton rdbtnYes_1 ;
	JRadioButton rdbtnYes;
	private int selfHarm;
	private ArrayList<Integer>l = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_record_gui frame = new client_record_gui(1);
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
	public client_record_gui(int clientid) { 
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Client Record", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(26, 30, 515, 642);
		panel.add(panel_1);
		
		String id = String.valueOf(clientid);		
		
		JLabel lblclientId = new JLabel("Client ID:");
		lblclientId.setBounds(24, 26, 93, 14);
		panel_1.add(lblclientId);
		
		JLabel lblId = new JLabel(id);
		lblId.setBounds(100, 26, 93, 14);
		panel_1.add(lblId);
		
		JLabel lblcaseId = new JLabel("Case ID:");
		lblcaseId.setBounds(150, 26, 93, 14);
		panel_1.add(lblcaseId);
		
		
		
		lawyerFunctions factory = lawyerServiceFactory.getFactory();
		ResultSet rs = factory.getRandevouInfo(clientid);
		
		int c=0;
		String caseid="";

		try {
			while (rs.next()) {
				
				c = rs.getInt("CaseID");
				caseid = String.valueOf(c);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		JLabel lblcId = new JLabel(caseid);
		lblcId.setBounds(200, 26, 93, 14);
		panel_1.add(lblcId);
		
		JLabel lblrecommendation = new JLabel("Recommendation:");
		lblrecommendation.setBounds(24, 57, 110, 14);
		panel_1.add(lblrecommendation);
		
		
		lawyerFunctions factory1 = lawyerServiceFactory.getFactory();
		ResultSet rs1 = factory1.getLastRecommendation(clientid, c);
		
		String rec="";
		
		try {
			while (rs1.next()) {
				
				rec=rs1.getString("Recommentation");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		textField = new JTextField(); //recommendations
		textField.setBounds(152, 57, 110, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setText(rec);
		
		
		JLabel lbllegal = new JLabel("Legal Opinions:");
		lbllegal.setBounds(24, 180, 93, 14);
		panel_1.add(lbllegal);
		
		lawyerFunctions factory2 = lawyerServiceFactory.getFactory();
		ResultSet rs2 = factory2.getLastOpinion(clientid, c);
		
		String op="";
		
		try {
			while (rs2.next()) {
				
				op=rs2.getString("LegalOpinion");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_1 = new JTextField(); //legal opinion
		textField_1.setBounds(152,180, 110, 40);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(op);
		
		JLabel lblstrategy = new JLabel("Strategy ID:");
		lblstrategy.setBounds(24, 255, 93, 14);
		panel_1.add(lblstrategy);
		
		lawyerFunctions factory3 = lawyerServiceFactory.getFactory();
		ResultSet rs3 = factory3.getLastStrategy(clientid, c);
		
		String str="";
		
		
		try {
			while (rs3.next()) {
				
				int s=rs3.getInt("LegalStrategyID");
				str=String.valueOf(s);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_2 = new JTextField(); //strategy id
		textField_2.setBounds(152,255, 50, 25);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(str);
		
		
		JLabel lblcomments = new JLabel("Comments:");
		lblcomments.setBounds(24, 300, 93, 14);
		panel_1.add(lblcomments);
		
		lawyerFunctions factory4 = lawyerServiceFactory.getFactory();
		ResultSet rs4 = factory4.getLastComments(clientid, c);
		
		String com="";
		
		
		try {
			while (rs4.next()) {
				
				com=rs4.getString("Comments");
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField_3 = new JTextField(); //comments
		textField_3.setBounds(152,300, 300, 100);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(com);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int c = Integer.parseInt(lblcId.getText()); //caseid
				
				
				String r=textField.getText(); //updated recommendation
				String l=textField_1.getText(); //updated opinion
				Integer s = Integer.parseInt(textField_2.getText()); //updated StrategyID
				String comment = textField_3.getText(); //updated comments
				
				lawyerFunctions factory5 = lawyerServiceFactory.getFactory();
				factory5.updateClientRecord(clientid, c, r, l, s, comment );
				
			}
		});
		btnSubmit.setBounds(24, 450, 89, 23);
		panel_1.add(btnSubmit);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Lawyer_Randevous frame = new Lawyer_Randevous(1);
				
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(24, 500, 89, 23);
		panel_1.add(btnBack);
		
	}
}

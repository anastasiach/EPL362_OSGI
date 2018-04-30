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

public class Strategy_sideEffects extends JFrame  {
	
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
					Strategy_sideEffects frame = new Strategy_sideEffects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Gives the side effects of each strategy
	 * 
	 */
public Strategy_sideEffects(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Strategies / Side Effects", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		String header[] = new String[] { "Strategy ID" , "Strategy Name" , "Side Effects"  };
		model.setColumnIdentifiers(header);	
		
		lawyerFunctions factory = lawyerServiceFactory.getFactory();	
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> effects = new ArrayList<String>();
	
		
		ResultSet rs = factory.getSideEffects();
		
		try {
			int count=0;
			while (rs.next()) {
				Integer id = rs.getInt("LegalStrategyID");
				ids.add(id);
				String name = rs.getString("Name");
				names.add(name);
				String effect = rs.getString("Side-effects");
				effects.add(effect);
				
				model.addRow(new Object[] { id , name , effect});
				l.add(id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**************************************************************/

		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lawyer_gui frame = new lawyer_gui(1);
				frame.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnNewButton.setBounds(320, 290, 101, 23);
		panel_1.add(btnNewButton);
	}

}

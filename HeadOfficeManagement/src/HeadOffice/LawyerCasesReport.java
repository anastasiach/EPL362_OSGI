package HeadOffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import HeadOfficeFactory.HeadOfficeFactoryService;
import HeadOfficeManagement.HeadOfficeFunctions;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class LawyerCasesReport extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private ArrayList<String> l = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LawyerCasesReport frame = new LawyerCasesReport(1,1); //clientID
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Gives the lawyer cases 
	 * 
	 * @param clientid
	 * @param caseid
	 */
	
	
	public LawyerCasesReport(int clientid, int caseid) {
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
				new LineBorder(new Color(0, 0, 128), 3), "Consultation",
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

		String header[] = new String[] { "Recommendations", "Legal Opinions" };
		model.setColumnIdentifiers(header);


		HeadOfficeFunctions factory = HeadOfficeFactoryService.getFactory();
	
		ArrayList<String> recs = new ArrayList<String>();
		ArrayList<String> legals = new ArrayList<String>();
		
		ResultSet rs = factory.getClientsCases1(clientid, caseid) ;
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
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClientsCases frame = new ClientsCases(clientid);

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

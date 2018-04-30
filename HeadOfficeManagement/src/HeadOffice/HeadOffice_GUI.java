package HeadOffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import HeadOffice.*;
/*import receptionist.Receptionist_GUI;
 import receptionist.newRandevou;
 import receptionist.randevouList;*/
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
public class HeadOffice_GUI extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadOffice_GUI frame = new HeadOffice_GUI(125);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * 
	 * @param ID
	 */
	public HeadOffice_GUI(int ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 128), 3),
				"Head Office Interface", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(24, 25, 400, 272);
		panel.add(panel_1);

		JButton btnCtreatRandevou = new JButton("Client cases");
		btnCtreatRandevou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client_list frame = new Client_list(1, 0);
				frame.setVisible(true);
				setVisible(false);

			}
		});
		btnCtreatRandevou.setBounds(104, 30, 181, 28);
		panel_1.add(btnCtreatRandevou);

		JButton btnListOfClients = new JButton("Weekly Reports");
		btnListOfClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BranchesList frame = new BranchesList();
				frame.setVisible(true);
				setVisible(false);

			}
		});
		btnListOfClients.setBounds(104, 80, 181, 28);
		panel_1.add(btnListOfClients);

	}

}

package receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import receptionistFactory.receptionistFactory;
import receptionistModel.receptionistFunctions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * This is the GUI that helps the receptionist to show a new randevou
 * @author  Anastasia, Anastasia, Antonia, Marina
 *
 */
public class Receptionist_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist_GUI frame = new Receptionist_GUI(125);
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
	public Receptionist_GUI(int ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Receptionist Interface", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(24, 25, 400, 272);
		panel.add(panel_1);
		
		JButton btnCtreatRandevou = new JButton("Creat Randevou");
		btnCtreatRandevou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receptionistFunctions factory = receptionistFactory.getFactory();	
				String lb = factory.getBranchName(ID);
				newRandevou frame =new newRandevou(lb,ID);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnCtreatRandevou.setBounds(104, 30, 181, 28);
		panel_1.add(btnCtreatRandevou);
		
		JButton btnListOfClients = new JButton("List of Clients");
		btnListOfClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////////
				Client_list frame = new Client_list(ID, 0);
				frame.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnListOfClients.setBounds(104, 80, 181, 28);
		panel_1.add(btnListOfClients);
		
		JButton btnListOfRandevous = new JButton("List Of Randevous");
		btnListOfRandevous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randevouList frame = new randevouList(ID);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnListOfRandevous.setBounds(104, 130, 181, 28);
		panel_1.add(btnListOfRandevous);
		
		JButton btnNewButton = new JButton("View Client's Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_list frame = new Client_list(/*ID*/0, 0);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
		btnNewButton.setBounds(104, 180, 181, 28);
		panel_1.add(btnNewButton);
		

		JButton btnRL = new JButton("View Reccomendations");
		btnRL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_list frame = new Client_list(1, 0);
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnRL.setBounds(104, 230, 181, 28);
		panel_1.add(btnRL);
	}
}

package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import HeadOffice.BranchesList;
import HeadOffice.HeadOffice_GUI;
import receptionist.Receptionist_GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import loginFactory.loginFactory;
import loginModel.loginFunction;
import lawyer.lawyer_gui;
import secretary.Client_list;
import secretary.secretary_gui;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Log in", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(10, 23, 301, 157);
		panel.add(panel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loginFunction factory = loginFactory.getFactory();
				
				final String u = user.getText();
				final String p = pass.getText();

				
				int a[] =factory.login(u, p);				
				
				System.out.println(a[0]+" "+a[1]);
				
				if(a[0]==0){ //lawyer
					try {
						lawyer_gui frame = new lawyer_gui(a[1]);
						frame.setVisible(true);
						setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(a[0]==1){ 	// secretary
					try {
						secretary_gui frame = new secretary_gui(a[1]);
						frame.setVisible(true);
						setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(a[0]==2){    //receptionist
					try {
						Receptionist_GUI frame = new Receptionist_GUI(a[1]);
						frame.setVisible(true);
						setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(a[0]==3){    // manager
					try {
						HeadOffice_GUI frame = new HeadOffice_GUI (a[1]);
						frame.setVisible(true);
						setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				
				if(a[0]==-1){
					JOptionPane.showMessageDialog(null,
						    "You didn't insert valid data!!!",
						    "Try again",
						    JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
		btnLogin.setBounds(162, 106, 89, 23);
		panel_1.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(47, 34, 82, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(47, 70, 82, 14);
		panel_1.add(lblPassword);
		
		user = new JTextField();
		user.setBounds(165, 31, 86, 20);
		panel_1.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(165, 67, 86, 20);
		panel_1.add(pass);
	}
}

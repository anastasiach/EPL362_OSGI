package secretary;

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

import secretary.Client_list;


public class secretary_gui extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secretary_gui frame = new secretary_gui(1);
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
	public secretary_gui(int secretary_id) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Secretary Interface", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(10, 27, 284, 228);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("View Clients");  
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Client_list frame = new Client_list(1);
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(63, 49, 152, 28);
		panel_1.add(btnNewButton);
		
		
	}

}

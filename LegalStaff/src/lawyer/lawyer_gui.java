package lawyer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class lawyer_gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lawyer_gui frame = new lawyer_gui(1111);
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
	public lawyer_gui(int lawyer_id) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Lawyer Interface", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(10, 27, 284, 228);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("Show Rantevous");  
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Lawyer_Randevous frame = new Lawyer_Randevous(1);
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(63, 49, 152, 28);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Client Record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Client_list frame = new Client_list(1); //choise 1
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(63, 90, 152, 28);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Side Effects");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strategy_sideEffects frame = new Strategy_sideEffects();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(63, 130, 152, 28);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Risk Status");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_list frame = new Client_list(0); // choise 0
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(63, 170, 152, 28);
		panel_1.add(btnNewButton_3);
	}
}

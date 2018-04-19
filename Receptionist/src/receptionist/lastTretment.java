package receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lastTretment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					lastTretment frame = new lastTretment();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public lastTretment(int ID,Integer pid, String cond, String med) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Patient Last Prescription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(26, 30, 430, 307);
		panel.add(panel_1);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(28, 28, 75, 14);
		panel_1.add(lblPatientId);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(113, 25, 86, 20);
		textField.setText(pid.toString());
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCondition = new JLabel("Condition:");
		lblCondition.setBounds(28, 72, 75, 14);
		panel_1.add(lblCondition);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setBounds(113, 72, 263, 71);
		textArea.setText(cond);
		panel_1.add(textArea);
		
		JLabel lblMedication = new JLabel("Medication:");
		lblMedication.setBounds(28, 183, 75, 14);
		panel_1.add(lblMedication);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(113, 180, 263, 20);
		textField_1.setText(med);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receptionist_GUI frame = new Receptionist_GUI(ID);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(168, 246, 89, 23);
		panel_1.add(btnBack);
	}
}

package com.csis3275.Boundry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BookingGUI {

	private JFrame frame;
	private JTextField textPassword;
	private JTextField textId;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textEmail;
	private JTextField textPNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingGUI window = new BookingGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_299459863946400");
		panelLogin.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(37, 49, 46, 14);
		panelLogin.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 107, 46, 14);
		panelLogin.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(37, 132, 188, 20);
		panelLogin.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(37, 163, 89, 23);
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(136, 163, 89, 23);
		panelLogin.add(btnRegister);
		
		textId = new JTextField();
		textId.setBounds(37, 76, 188, 20);
		panelLogin.add(textId);
		textId.setColumns(10);
		
		JPanel panelRegister = new JPanel();
		frame.getContentPane().add(panelRegister, "name_299472625629900");
		panelRegister.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(30, 30, 79, 14);
		panelRegister.add(lblFirstName);
		
		textFName = new JTextField();
		textFName.setBounds(30, 55, 126, 20);
		panelRegister.add(textFName);
		textFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(189, 30, 79, 14);
		panelRegister.add(lblLastName);
		
		textLName = new JTextField();
		textLName.setBounds(189, 55, 126, 20);
		panelRegister.add(textLName);
		textLName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 86, 63, 14);
		panelRegister.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(30, 111, 126, 20);
		panelRegister.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(189, 86, 79, 14);
		panelRegister.add(lblPhoneNumber);
		
		textPNumber = new JTextField();
		textPNumber.setBounds(189, 111, 126, 20);
		panelRegister.add(textPNumber);
		textPNumber.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(127, 172, 89, 23);
		panelRegister.add(btnSubmit);
		
		JPanel panelSchedule = new JPanel();
		frame.getContentPane().add(panelSchedule, "name_299475262638900");
		panelSchedule.setLayout(null);
	}
}

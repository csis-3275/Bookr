package com.csis3275.Boundry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Font;

public class BookingGUI {

	private JFrame frame;
	private JTextField textPassword;
	private JTextField textId;
	private JTextField textFirstName;
	private JTextField textLName;
	private JTextField textEmail;
	private JTextField textPhoneNumber;
	private JTextField textBookingNumber;
	private JTextField textRoomNumber;
	private JTextField textNumGuests;
	private JTextField textField;

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
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginPage.setBounds(37, 11, 89, 27);
		panelLogin.add(lblLoginPage);
		
		JPanel panelRegister = new JPanel();
		frame.getContentPane().add(panelRegister, "name_299472625629900");
		panelRegister.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(30, 60, 79, 14);
		panelRegister.add(lblFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(30, 85, 126, 20);
		panelRegister.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(189, 60, 79, 14);
		panelRegister.add(lblLastName);
		
		textLName = new JTextField();
		textLName.setBounds(189, 85, 126, 20);
		panelRegister.add(textLName);
		textLName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 116, 63, 14);
		panelRegister.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(30, 141, 126, 20);
		panelRegister.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(189, 116, 79, 14);
		panelRegister.add(lblPhoneNumber);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(189, 141, 126, 20);
		panelRegister.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(127, 172, 89, 23);
		panelRegister.add(btnSubmit);
		
		JLabel lblRegistrationPage = new JLabel("Registration Page");
		lblRegistrationPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrationPage.setBounds(30, 11, 126, 30);
		panelRegister.add(lblRegistrationPage);
		
		JPanel panelSchedule = new JPanel();
		frame.getContentPane().add(panelSchedule, "name_306961155065300");
		panelSchedule.setLayout(null);
		
		JLabel lblSelectDateAnd = new JLabel("Select Date and Time");
		lblSelectDateAnd.setBounds(30, 42, 114, 14);
		panelSchedule.add(lblSelectDateAnd);
		
		DateTimePicker dateTimePicker_1 = new DateTimePicker();
		dateTimePicker_1.setBounds(30, 67, 221, 23);
		panelSchedule.add(dateTimePicker_1);
		
		JLabel lblEnterRoomNumber = new JLabel("Enter Room Number");
		lblEnterRoomNumber.setBounds(30, 101, 130, 14);
		panelSchedule.add(lblEnterRoomNumber);
		
		textRoomNumber = new JTextField();
		textRoomNumber.setBounds(30, 126, 86, 20);
		panelSchedule.add(textRoomNumber);
		textRoomNumber.setColumns(10);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of Guests");
		lblEnterNumberOf.setBounds(30, 157, 130, 14);
		panelSchedule.add(lblEnterNumberOf);
		
		textNumGuests = new JTextField();
		textNumGuests.setBounds(30, 182, 86, 20);
		panelSchedule.add(textNumGuests);
		textNumGuests.setColumns(10);
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.setBounds(30, 213, 114, 23);
		panelSchedule.add(btnConfirmBooking);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBounds(154, 213, 89, 23);
		panelSchedule.add(btnCancel_1);
		
		JLabel lblSchedulePage = new JLabel("Schedule Page");
		lblSchedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchedulePage.setBounds(30, 11, 114, 20);
		panelSchedule.add(lblSchedulePage);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(170, 101, 46, 14);
		panelSchedule.add(lblMessage);
		
		JTextArea textMessage = new JTextArea();
		textMessage.setBounds(170, 124, 207, 78);
		panelSchedule.add(textMessage);
		
		JPanel panelReschedule = new JPanel();
		frame.getContentPane().add(panelReschedule, "name_299475262638900");
		panelReschedule.setLayout(null);
		
		JLabel lblEnterBookingNumber = new JLabel("Enter Booking Number");
		lblEnterBookingNumber.setBounds(30, 43, 127, 14);
		panelReschedule.add(lblEnterBookingNumber);
		
		textBookingNumber = new JTextField();
		textBookingNumber.setBounds(30, 68, 86, 20);
		panelReschedule.add(textBookingNumber);
		textBookingNumber.setColumns(10);
		
		JLabel lblSelectNewDate = new JLabel("Select New Date and Time");
		lblSelectNewDate.setBounds(30, 99, 150, 14);
		panelReschedule.add(lblSelectNewDate);
		
		DateTimePicker dateTimePicker = new DateTimePicker();
		dateTimePicker.setBounds(30, 124, 221, 23);
		panelReschedule.add(dateTimePicker);
		
		JButton btnConfirmRequest = new JButton("Confirm Request");
		btnConfirmRequest.setBounds(30, 220, 113, 23);
		panelReschedule.add(btnConfirmRequest);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(153, 220, 89, 23);
		panelReschedule.add(btnCancel);
		
		JLabel lblEnterNumberOf_1 = new JLabel("Enter Number of Guests");
		lblEnterNumberOf_1.setBounds(30, 158, 139, 14);
		panelReschedule.add(lblEnterNumberOf_1);
		
		textField = new JTextField();
		textField.setBounds(30, 183, 86, 20);
		panelReschedule.add(textField);
		textField.setColumns(10);
		
		JLabel lblReschedulePage = new JLabel("Reschedule Page");
		lblReschedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReschedulePage.setBounds(30, 11, 139, 21);
		panelReschedule.add(lblReschedulePage);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_307857570675100");
		panel.setLayout(null);
	}
}

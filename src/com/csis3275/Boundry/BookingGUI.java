package com.csis3275.Boundry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.DatePicker;

public class BookingGUI {

	private JFrame frame;
	private JTextField textPassword;
	private JTextField textId;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textEmail;
	private JTextField textPhoneNumber;
	private JTextField textBookingNumber;
	private JTextField textNumGuests;
	private JTextField textRNumGuests;
	private JTable tblReschedule;
	private JTextField textOldDate;
	private JTextField textOldTime;
	private JTextField textOldNumGuests;
	private JTextField textNewDate;
	private JTextField textNewTime;
	private JTextField textNewNumGuests;
	
	private JPanel panelLogin;
	private JPanel panelRegister;
	private JPanel panelSchedule;
	private JPanel Reschedule;
	private JPanel panelSupport;
	private JPanel panelProfile;
	private JTextField txtBobSmith;
	private JTextField txtBobgmailcom;
	private JTable table_1;
	private JTextField textRescheduleMessage;

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
		panelLogin.setVisible(true);
		
		JPanel panelRegister = new JPanel();
		frame.getContentPane().add(panelRegister, "name_299472625629900");
		panelRegister.setLayout(null);
		panelRegister.setVisible(false);
		
		JPanel panelSchedule = new JPanel();
		frame.getContentPane().add(panelSchedule, "name_306961155065300");
		panelSchedule.setLayout(null);
		panelSchedule.setVisible(false);
		
		JPanel panelReschedule = new JPanel();
		frame.getContentPane().add(panelReschedule, "name_299475262638900");
		panelReschedule.setLayout(null);
		panelReschedule.setVisible(false);
		
		JPanel panelSupport = new JPanel();
		frame.getContentPane().add(panelSupport, "name_307857570675100");
		panelSupport.setLayout(null);
		panelSupport.setVisible(false);
		
		JPanel panelProfile = new JPanel();
		frame.getContentPane().add(panelProfile, "name_391028971924000");
		panelProfile.setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfilePage.setBounds(30, 28, 108, 14);
		panelProfile.add(lblProfilePage);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(30, 66, 46, 14);
		panelProfile.add(lblName);
		
		txtBobSmith = new JTextField();
		txtBobSmith.setText("Bob Smith");
		txtBobSmith.setBounds(132, 63, 108, 20);
		panelProfile.add(txtBobSmith);
		txtBobSmith.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setBounds(30, 91, 46, 14);
		panelProfile.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number: ");
		lblNewLabel_3.setBounds(30, 116, 77, 14);
		panelProfile.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Reservations");
		lblNewLabel_4.setBounds(30, 141, 77, 14);
		panelProfile.add(lblNewLabel_4);
		
		txtBobgmailcom = new JTextField();
		txtBobgmailcom.setText("bob@gmail.com");
		txtBobgmailcom.setBounds(132, 94, 108, 20);
		panelProfile.add(txtBobgmailcom);
		txtBobgmailcom.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(132, 141, 108, 65);
		panelProfile.add(table_1);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSchedule.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnSchedule.setBounds(277, 62, 108, 23);
		panelProfile.add(btnSchedule);
		
		JButton btnNewButton_1 = new JButton("Reschedule");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelReschedule.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(277, 91, 108, 23);
		panelProfile.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sign Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(277, 132, 108, 23);
		panelProfile.add(btnNewButton_2);
		panelProfile.setVisible(false);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(37, 49, 66, 14);
		panelLogin.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 107, 89, 14);
		panelLogin.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setText("********");
		textPassword.setBounds(37, 132, 188, 20);
		panelLogin.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = textId.getText();
				String userPass = textPassword.getText();
				
				
				if (userId == "admin") {
					panelSupport.setVisible(true);
					panelLogin.setVisible(false);
				} else {
					panelProfile.setVisible(true);
					panelLogin.setVisible(false);
				}
			}
		});
		btnLogin.setBounds(37, 163, 89, 23);
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(136, 163, 89, 23);
		panelLogin.add(btnRegister);
		
		textId = new JTextField();
		textId.setText("Bob Smith");
		textId.setBounds(37, 76, 188, 20);
		panelLogin.add(textId);
		textId.setColumns(10);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginPage.setBounds(37, 11, 89, 27);
		panelLogin.add(lblLoginPage);
		
		
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(30, 60, 79, 14);
		panelRegister.add(lblFirstName);
		
		textFName = new JTextField();
		textFName.setBounds(30, 85, 126, 20);
		panelRegister.add(textFName);
		textFName.setColumns(10);
		
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
		
		
		
		JLabel lblSelectDateAnd = new JLabel("Select Date and Time");
		lblSelectDateAnd.setBounds(30, 42, 114, 14);
		panelSchedule.add(lblSelectDateAnd);
		
		JLabel lblEnterRoomNumber = new JLabel("Select Room Number");
		lblEnterRoomNumber.setBounds(30, 101, 130, 14);
		panelSchedule.add(lblEnterRoomNumber);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of Guests");
		lblEnterNumberOf.setBounds(30, 157, 163, 14);
		panelSchedule.add(lblEnterNumberOf);
		
		textNumGuests = new JTextField();
		textNumGuests.setBounds(30, 182, 86, 20);
		panelSchedule.add(textNumGuests);
		textNumGuests.setColumns(10);
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.setBounds(30, 213, 135, 23);
		panelSchedule.add(btnConfirmBooking);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(true);
				panelSchedule.setVisible(false);
			}
		});
		btnCancel_1.setBounds(175, 213, 89, 23);
		panelSchedule.add(btnCancel_1);
		
		JLabel lblSchedulePage = new JLabel("Schedule Page");
		lblSchedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchedulePage.setBounds(30, 11, 114, 20);
		panelSchedule.add(lblSchedulePage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "104", "105"}));
		comboBox.setBounds(51, 126, 61, 20);
		panelSchedule.add(comboBox);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(30, 67, 139, 20);
		panelSchedule.add(datePicker);
		
		TimePicker timePicker = new TimePicker();
		timePicker.setBounds(197, 65, 80, 23);
		panelSchedule.add(timePicker);
		
		
		
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
		
		JButton btnConfirmRequest = new JButton("Confirm Request");
		btnConfirmRequest.setBounds(30, 220, 150, 23);
		panelReschedule.add(btnConfirmRequest);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(true);
				panelReschedule.setVisible(false);
			}
		});
		btnCancel.setBounds(192, 220, 89, 23);
		panelReschedule.add(btnCancel);
		
		JLabel lblEnterNumberOf_1 = new JLabel("Enter Number of Guests");
		lblEnterNumberOf_1.setBounds(30, 158, 139, 14);
		panelReschedule.add(lblEnterNumberOf_1);
		
		textRNumGuests = new JTextField();
		textRNumGuests.setBounds(30, 183, 86, 20);
		panelReschedule.add(textRNumGuests);
		textRNumGuests.setColumns(10);
		
		JLabel lblReschedulePage = new JLabel("Reschedule Page");
		lblReschedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReschedulePage.setBounds(30, 11, 139, 21);
		panelReschedule.add(lblReschedulePage);
		
		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.setBounds(30, 124, 139, 20);
		panelReschedule.add(datePicker_1);
		
		TimePicker timePicker_1 = new TimePicker();
		timePicker_1.setBounds(201, 122, 80, 23);
		panelReschedule.add(timePicker_1);
		
		JLabel lblMessage_1 = new JLabel("Message");
		lblMessage_1.setBounds(194, 43, 46, 14);
		panelReschedule.add(lblMessage_1);
		
		textRescheduleMessage = new JTextField();
		textRescheduleMessage.setBounds(195, 68, 182, 45);
		panelReschedule.add(textRescheduleMessage);
		textRescheduleMessage.setColumns(10);
		
		
		
		JLabel lblSupportPage = new JLabel("Support Page");
		lblSupportPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupportPage.setBounds(30, 11, 113, 25);
		panelSupport.add(lblSupportPage);
		
		JLabel lblNewLabel = new JLabel("Reschedule Requests");
		lblNewLabel.setBounds(30, 47, 113, 14);
		panelSupport.add(lblNewLabel);
		
		tblReschedule = new JTable();
		tblReschedule.setBounds(30, 72, 154, 64);
		panelSupport.add(tblReschedule);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setBounds(202, 47, 46, 14);
		panelSupport.add(lblNewLabel_1);
		
		textOldDate = new JTextField();
		textOldDate.setBounds(202, 69, 86, 20);
		panelSupport.add(textOldDate);
		textOldDate.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(202, 100, 46, 14);
		panelSupport.add(lblTime);
		
		textOldTime = new JTextField();
		textOldTime.setBounds(202, 125, 86, 20);
		panelSupport.add(textOldTime);
		textOldTime.setColumns(10);
		
		JLabel lblNumberOfGuests = new JLabel("Num of Guests");
		lblNumberOfGuests.setBounds(202, 156, 86, 14);
		panelSupport.add(lblNumberOfGuests);
		
		textOldNumGuests = new JTextField();
		textOldNumGuests.setBounds(202, 181, 86, 20);
		panelSupport.add(textOldNumGuests);
		textOldNumGuests.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(30, 147, 46, 14);
		panelSupport.add(lblMessage);
		
		JTextArea textMessage = new JTextArea();
		textMessage.setBounds(30, 179, 154, 84);
		panelSupport.add(textMessage);
		
		JLabel lblNewDate = new JLabel("New Date");
		lblNewDate.setBounds(299, 47, 70, 14);
		panelSupport.add(lblNewDate);
		
		textNewDate = new JTextField();
		textNewDate.setBounds(298, 69, 86, 20);
		panelSupport.add(textNewDate);
		textNewDate.setColumns(10);
		
		JLabel lblNewTime = new JLabel("New Time");
		lblNewTime.setBounds(299, 100, 61, 14);
		panelSupport.add(lblNewTime);
		
		textNewTime = new JTextField();
		textNewTime.setBounds(298, 125, 86, 20);
		panelSupport.add(textNewTime);
		textNewTime.setColumns(10);
		
		JLabel lblNewNumOf = new JLabel("New Num of Guests");
		lblNewNumOf.setBounds(298, 156, 102, 14);
		panelSupport.add(lblNewNumOf);
		
		textNewNumGuests = new JTextField();
		textNewNumGuests.setBounds(298, 181, 86, 20);
		panelSupport.add(textNewNumGuests);
		textNewNumGuests.setColumns(10);
		
		JButton btnNewButton = new JButton("Approve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Approved");
			}
		});
		btnNewButton.setBounds(199, 212, 89, 23);
		panelSupport.add(btnNewButton);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.setBounds(299, 212, 89, 23);
		panelSupport.add(btnDeny);
		
		
	}
}

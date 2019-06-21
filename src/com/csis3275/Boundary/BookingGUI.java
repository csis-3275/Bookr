package com.csis3275.Boundary;

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
	private JTextField txtPassword;
	private JTextField txtId;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtBookingNumber;
	private JTextField txtNumGuests;
	private JTextField txtRNumGuests;
	private JTable tblReschedule;
	private JTextField txtOldDate;
	private JTextField txtOldTime;
	private JTextField txtOldNumGuests;
	private JTextField txtNewDate;
	private JTextField txtNewTime;
	private JTextField txtNewNumGuests;
	
	private JPanel panelLogin;
	private JPanel panelRegister;
	private JPanel panelSchedule;
	private JPanel Reschedule;
	private JPanel panelSupport;
	private JPanel panelProfile;
	private JTextField txtUserName;
	private JTextField txtUserEmail;
	private JTable tblReservations;
	private JTextField txtRescheduleMessage;
	private JTextField txtUserPhoneNumber;
	private JTextField txtRescheduleMsg;

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
		frame.setBounds(100, 100, 573, 447);
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
		lblProfilePage.setBounds(235, 11, 108, 14);
		panelProfile.add(lblProfilePage);
		
		JLabel lblPName = new JLabel("Name: ");
		lblPName.setBounds(55, 112, 46, 14);
		panelProfile.add(lblPName);
		
		txtUserName = new JTextField();
		txtUserName.setText("Bob Smith");
		txtUserName.setBounds(180, 109, 135, 20);
		panelProfile.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPEmail = new JLabel("Email: ");
		lblPEmail.setBounds(55, 155, 46, 14);
		panelProfile.add(lblPEmail);
		
		JLabel lblPPhoneNum = new JLabel("Phone Number: ");
		lblPPhoneNum.setBounds(55, 199, 95, 14);
		panelProfile.add(lblPPhoneNum);
		
		JLabel lblResNum = new JLabel("Reservation Numbers");
		lblResNum.setBounds(55, 234, 115, 14);
		panelProfile.add(lblResNum);
		
		txtUserEmail = new JTextField();
		txtUserEmail.setText("bob@gmail.com");
		txtUserEmail.setBounds(180, 152, 135, 20);
		panelProfile.add(txtUserEmail);
		txtUserEmail.setColumns(10);
		
		tblReservations = new JTable();
		tblReservations.setBounds(180, 234, 135, 65);
		panelProfile.add(tblReservations);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSchedule.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnSchedule.setBounds(375, 108, 108, 23);
		panelProfile.add(btnSchedule);
		
		JButton btnReschedule = new JButton("Reschedule");
		btnReschedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelReschedule.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnReschedule.setBounds(375, 151, 108, 23);
		panelProfile.add(btnReschedule);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnSignOut.setBounds(375, 195, 108, 23);
		panelProfile.add(btnSignOut);
		
		txtUserPhoneNumber = new JTextField();
		txtUserPhoneNumber.setText("604-999-9932");
		txtUserPhoneNumber.setBounds(180, 196, 135, 20);
		panelProfile.add(txtUserPhoneNumber);
		txtUserPhoneNumber.setColumns(10);
		panelProfile.setVisible(false);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(178, 119, 66, 14);
		panelLogin.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(178, 186, 89, 14);
		panelLogin.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setText("********");
		txtPassword.setBounds(178, 222, 188, 20);
		panelLogin.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = txtId.getText();
				String userPass = txtPassword.getText();
				
				
				if (userId == "admin") {
					panelSupport.setVisible(true);
					panelLogin.setVisible(false);
				} else {
					panelProfile.setVisible(true);
					panelLogin.setVisible(false);
				}
			}
		});
		btnLogin.setBounds(178, 269, 89, 23);
		panelLogin.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(296, 269, 89, 23);
		panelLogin.add(btnRegister);
		
		txtId = new JTextField();
		txtId.setText("Bob Smith");
		txtId.setBounds(178, 144, 188, 20);
		panelLogin.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginPage.setBounds(230, 11, 89, 27);
		panelLogin.add(lblLoginPage);
		
		
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(212, 73, 79, 14);
		panelRegister.add(lblFirstName);
		
		txtFName = new JTextField();
		txtFName.setBounds(212, 98, 126, 20);
		panelRegister.add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(212, 126, 79, 14);
		panelRegister.add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setBounds(212, 151, 126, 20);
		panelRegister.add(txtLName);
		txtLName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(212, 182, 63, 14);
		panelRegister.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(212, 207, 126, 20);
		panelRegister.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(212, 243, 103, 14);
		panelRegister.add(lblPhoneNumber);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(212, 268, 126, 20);
		panelRegister.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(226, 331, 89, 23);
		panelRegister.add(btnSubmit);
		
		JLabel lblRegistrationPage = new JLabel("Registration Page");
		lblRegistrationPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrationPage.setBounds(212, 11, 126, 30);
		panelRegister.add(lblRegistrationPage);
		
		
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setBounds(204, 80, 114, 14);
		panelSchedule.add(lblSelectDate);
		
		JLabel lblEnterRoomNumber = new JLabel("Select Room Number");
		lblEnterRoomNumber.setBounds(204, 204, 130, 14);
		panelSchedule.add(lblEnterRoomNumber);
		
		JLabel lblEnterNumGuests = new JLabel("Enter Number of Guests");
		lblEnterNumGuests.setBounds(204, 271, 163, 14);
		panelSchedule.add(lblEnterNumGuests);
		
		txtNumGuests = new JTextField();
		txtNumGuests.setBounds(204, 296, 86, 20);
		panelSchedule.add(txtNumGuests);
		txtNumGuests.setColumns(10);
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.setBounds(180, 340, 135, 23);
		panelSchedule.add(btnConfirmBooking);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(true);
				panelSchedule.setVisible(false);
			}
		});
		btnCancel_1.setBounds(325, 340, 89, 23);
		panelSchedule.add(btnCancel_1);
		
		JLabel lblSchedulePage = new JLabel("Schedule Page");
		lblSchedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchedulePage.setBounds(233, 11, 114, 20);
		panelSchedule.add(lblSchedulePage);
		
		JComboBox RoomBox = new JComboBox();
		RoomBox.setModel(new DefaultComboBoxModel(new String[] {"", "101", "102", "103", "104", "105"}));
		RoomBox.setBounds(204, 229, 61, 20);
		panelSchedule.add(RoomBox);
		
		TimePicker timePicker = new TimePicker();
		timePicker.setBounds(204, 161, 80, 23);
		panelSchedule.add(timePicker);
		
		JLabel lblSelectTime = new JLabel("Select Time");
		lblSelectTime.setBounds(204, 136, 111, 14);
		panelSchedule.add(lblSelectTime);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(204, 105, 139, 20);
		panelSchedule.add(datePicker);
		
		
		
		JLabel lblEnterBookingNumber = new JLabel("Enter Booking Number");
		lblEnterBookingNumber.setBounds(158, 63, 127, 14);
		panelReschedule.add(lblEnterBookingNumber);
		
		txtBookingNumber = new JTextField();
		txtBookingNumber.setBounds(158, 88, 86, 20);
		panelReschedule.add(txtBookingNumber);
		txtBookingNumber.setColumns(10);
		
		JLabel lblSelectNewDate = new JLabel("Select New Date");
		lblSelectNewDate.setBounds(158, 119, 106, 14);
		panelReschedule.add(lblSelectNewDate);
		
		JButton btnConfirmRequest = new JButton("Confirm Request");
		btnConfirmRequest.setBounds(201, 340, 150, 23);
		panelReschedule.add(btnConfirmRequest);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(true);
				panelReschedule.setVisible(false);
			}
		});
		btnCancel.setBounds(234, 374, 89, 23);
		panelReschedule.add(btnCancel);
		
		JLabel lblEnterNumberGuests = new JLabel("Enter Number of Guests");
		lblEnterNumberGuests.setBounds(158, 175, 139, 14);
		panelReschedule.add(lblEnterNumberGuests);
		
		txtRNumGuests = new JTextField();
		txtRNumGuests.setBounds(158, 200, 86, 20);
		panelReschedule.add(txtRNumGuests);
		txtRNumGuests.setColumns(10);
		
		JLabel lblReschedulePage = new JLabel("Reschedule Page");
		lblReschedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReschedulePage.setBounds(224, 11, 139, 21);
		panelReschedule.add(lblReschedulePage);
		
		JLabel lblReasonReschedule = new JLabel("Reason for Reschedule");
		lblReasonReschedule.setBounds(158, 231, 165, 14);
		panelReschedule.add(lblReasonReschedule);
		
		txtRescheduleMessage = new JTextField();
		txtRescheduleMessage.setBounds(158, 256, 250, 77);
		panelReschedule.add(txtRescheduleMessage);
		txtRescheduleMessage.setColumns(10);
		
		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.setBounds(158, 144, 139, 20);
		panelReschedule.add(datePicker_1);
		
		TimePicker timePicker_1 = new TimePicker();
		timePicker_1.setBounds(328, 142, 80, 23);
		panelReschedule.add(timePicker_1);
		
		JLabel lblSelectNewTime = new JLabel("Select New Time");
		lblSelectNewTime.setBounds(327, 119, 118, 14);
		panelReschedule.add(lblSelectNewTime);
		
		
		
		JLabel lblSupportPage = new JLabel("Support Page");
		lblSupportPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupportPage.setBounds(223, 11, 113, 25);
		panelSupport.add(lblSupportPage);
		
		JLabel lblRescheduleNum = new JLabel("Reschedule Request Numbers");
		lblRescheduleNum.setBounds(204, 77, 154, 14);
		panelSupport.add(lblRescheduleNum);
		
		tblReschedule = new JTable();
		tblReschedule.setBounds(204, 102, 154, 64);
		panelSupport.add(tblReschedule);
		
		JLabel lblSDate = new JLabel("Date");
		lblSDate.setBounds(10, 177, 46, 14);
		panelSupport.add(lblSDate);
		
		txtOldDate = new JTextField();
		txtOldDate.setBounds(81, 174, 86, 20);
		panelSupport.add(txtOldDate);
		txtOldDate.setColumns(10);
		
		JLabel lblSTime = new JLabel("Time");
		lblSTime.setBounds(177, 177, 46, 14);
		panelSupport.add(lblSTime);
		
		txtOldTime = new JTextField();
		txtOldTime.setBounds(239, 174, 86, 20);
		panelSupport.add(txtOldTime);
		txtOldTime.setColumns(10);
		
		JLabel lblNumGuests = new JLabel("Number of Guests");
		lblNumGuests.setBounds(333, 177, 106, 14);
		panelSupport.add(lblNumGuests);
		
		txtOldNumGuests = new JTextField();
		txtOldNumGuests.setBounds(461, 174, 86, 20);
		panelSupport.add(txtOldNumGuests);
		txtOldNumGuests.setColumns(10);
		
		JLabel lblMessage = new JLabel("Reason for Reschedule");
		lblMessage.setBounds(160, 253, 165, 14);
		panelSupport.add(lblMessage);
		
		JLabel lblNewDate = new JLabel("New Date");
		lblNewDate.setBounds(10, 228, 63, 14);
		panelSupport.add(lblNewDate);
		
		txtNewDate = new JTextField();
		txtNewDate.setBounds(83, 222, 86, 20);
		panelSupport.add(txtNewDate);
		txtNewDate.setColumns(10);
		
		JLabel lblNewTime = new JLabel("New Time");
		lblNewTime.setBounds(177, 228, 52, 14);
		panelSupport.add(lblNewTime);
		
		txtNewTime = new JTextField();
		txtNewTime.setBounds(239, 222, 86, 20);
		panelSupport.add(txtNewTime);
		txtNewTime.setColumns(10);
		
		JLabel lblNewNumGuests = new JLabel("New Number of Guests");
		lblNewNumGuests.setBounds(333, 228, 118, 14);
		panelSupport.add(lblNewNumGuests);
		
		txtNewNumGuests = new JTextField();
		txtNewNumGuests.setBounds(461, 225, 86, 20);
		panelSupport.add(txtNewNumGuests);
		txtNewNumGuests.setColumns(10);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Approved");
			}
		});
		btnApprove.setBounds(170, 374, 89, 23);
		panelSupport.add(btnApprove);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.setBounds(311, 374, 89, 23);
		panelSupport.add(btnDeny);
		
		txtRescheduleMsg = new JTextField();
		txtRescheduleMsg.setColumns(10);
		txtRescheduleMsg.setBounds(160, 278, 250, 77);
		panelSupport.add(txtRescheduleMsg);
		
		
	}
}

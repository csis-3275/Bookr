package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.DatePicker;

/*
 * Importing Entities
 */

import com.csis3275.Entities.*;

/*
 * Importing boundaries
 */

import com.csis3275.Boundary.*;

/**
 * 
 * @author Minh Dinh
 * @author Ayodeji Tolu-ojo
 *
 */



public class BookingGUI {

	private JFrame frmRoomBookingApplication;
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
	

	private JTextField txtUserName;
	private JTextField txtUserEmail;
	private JTable tblReservations;
	private DefaultTableModel tm;
	private JTextField txtRescheduleMessage;
	private JTextField txtUserPhoneNumber;

	
	
	
	private ReservationDAOImpl ri = new ReservationDAOImpl(); 
	private RoomDAOImpl roi = new RoomDAOImpl();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingGUI window = new BookingGUI();
					window.frmRoomBookingApplication.setVisible(true);
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
		
		if(roi.readAllRooms().isEmpty())
		{
			populateRoomsTable(6);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmRoomBookingApplication = new JFrame();
		frmRoomBookingApplication.setTitle("Room Booking Application (Alpha)");
		frmRoomBookingApplication.setBounds(100, 100, 573, 447);
		frmRoomBookingApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRoomBookingApplication.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelLogin, "name_299459863946400");
		panelLogin.setLayout(null);
		panelLogin.setVisible(true);
		
		JPanel panelRegister = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelRegister, "name_299472625629900");
		panelRegister.setLayout(null);
		panelRegister.setVisible(false);
		
		JPanel panelSchedule = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelSchedule, "name_306961155065300");
		panelSchedule.setLayout(null);
		panelSchedule.setVisible(false);
		
		JPanel panelReschedule = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelReschedule, "name_299475262638900");
		panelReschedule.setLayout(null);
		panelReschedule.setVisible(false);
		
		JPanel panelSupport = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelSupport, "name_307857570675100");
		panelSupport.setLayout(null);
		panelSupport.setVisible(false);
		
		JPanel panelProfile = new JPanel();
		frmRoomBookingApplication.getContentPane().add(panelProfile, "name_391028971924000");
		panelProfile.setLayout(null);
		
		JLabel lblProfilePage = new JLabel("Profile Page");
		lblProfilePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfilePage.setBounds(235, 11, 108, 14);
		panelProfile.add(lblProfilePage);
		
		JLabel lblPName = new JLabel("Name: ");
		lblPName.setBounds(55, 112, 46, 14);
		panelProfile.add(lblPName);
		
		/**
		 * User full name in Profile page
		 */
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
		
		/**
		 * User email in Profile page
		 */
		txtUserEmail = new JTextField();
		txtUserEmail.setText("bob@gmail.com");
		txtUserEmail.setBounds(180, 152, 135, 20);
		panelProfile.add(txtUserEmail);
		txtUserEmail.setColumns(10);
		
		/**
		 * Table in user Profile page showing user reservation numbers created from Schedule page
		 */
		tblReservations = new JTable();

		tblReservations.setBounds(180, 234, 135, 65);
		panelProfile.add(tblReservations);
		
		/**
		 * Button to go from user Profile page to Schedule page
		 */
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSchedule.setVisible(true);
				panelProfile.setVisible(false);
				Reservation nr = new Reservation();
				
			}
		});
		btnSchedule.setBounds(375, 108, 108, 23);
		panelProfile.add(btnSchedule);
		
		/**
		 * Button to go from user Profile page to Reschedule page
		 */
		JButton btnReschedule = new JButton("Reschedule");
		btnReschedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelReschedule.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnReschedule.setBounds(375, 151, 108, 23);
		panelProfile.add(btnReschedule);
		
		/**
		 * Button to go from user Profile page back to Login page
		 */
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(true);
				panelProfile.setVisible(false);
			}
		});
		btnSignOut.setBounds(375, 195, 108, 23);
		panelProfile.add(btnSignOut);
		
		/**
		 * User phone number in profile page
		 */
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
		
		/**
		 * Password field in sign in page
		 */
		txtPassword = new JTextField();
		txtPassword.setText("********");
		
		txtPassword.setBounds(178, 222, 188, 20);
		panelLogin.add(txtPassword);
		txtPassword.setColumns(10);
		
		/**
		 * Login button
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = txtId.getText().trim();
				String userPass = txtPassword.getText();
				
				
				if (userId.equals("admin")) {
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
		
		/**
		 * Register button
		 */
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setBounds(296, 269, 89, 23);

		panelLogin.add(btnRegister);
		
		/**
		 * Name field in Login page
		 */
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
		
		/**
		 * Number of guest field in Schedule page
		 */
		txtNumGuests = new JTextField();
		txtNumGuests.setBounds(204, 296, 86, 20);
		panelSchedule.add(txtNumGuests);
		txtNumGuests.setColumns(10);

		/**
		 * Roombox selector in Schedule page
		 */
		JComboBox RoomBox = new JComboBox();
		RoomBox.setModel(new DefaultComboBoxModel(new String[] {"", "100", "101", "102", "103", "104", "105"}));
		RoomBox.setBounds(204, 229, 61, 20);
		panelSchedule.add(RoomBox);

		/**
		 * Date picker in Schedule page
		 */
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(204, 105, 139, 20);
		panelSchedule.add(datePicker);
		
		/**
		 * Time picker in Schedule page
		 */
		TimePicker timePicker = new TimePicker();
		timePicker.setBounds(204, 161, 80, 23);
		panelSchedule.add(timePicker);
		
		/**
		 * Confirm booking button in Schedule page
		 */
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		btnConfirmBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int room_id = RoomBox.getSelectedIndex();
				String date = datePicker.getDateStringOrEmptyString();
				String time = timePicker.getTimeStringOrEmptyString();
				String status = "Confirmed";
				String res_number = "RBADMG"+room_id;
				
				Reservation nr = new Reservation();
				nr.set_reservation_number(res_number);
				nr.set_room_id(room_id+1);
				nr.set_date(date);
				nr.set_time(time);
				nr.set_status(status);
				ri.createReservation(nr);
			}
		});
		btnConfirmBooking.setBounds(204, 327, 135, 23);
		panelSchedule.add(btnConfirmBooking);

		JLabel lblSelectTime = new JLabel("Select Time");
		lblSelectTime.setBounds(204, 136, 111, 14);
		panelSchedule.add(lblSelectTime);
		
		

		/**
		 * Cancel button in Schedule page, brings you back to Profile page
		 */
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(true);
				panelSchedule.setVisible(false);
			}
		});
		btnCancel_1.setBounds(229, 361, 89, 23);
		panelSchedule.add(btnCancel_1);
		
		JLabel lblSchedulePage = new JLabel("Schedule Page");
		lblSchedulePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchedulePage.setBounds(204, 11, 148, 14);
		panelSchedule.add(lblSchedulePage);
		
		JLabel lblEnterBookingNumber = new JLabel("Enter Booking Number");
		lblEnterBookingNumber.setBounds(158, 63, 127, 14);
		panelReschedule.add(lblEnterBookingNumber);
		
		/**
		 * Booking number field in Reschedule page
		 */
		txtBookingNumber = new JTextField();
		txtBookingNumber.setBounds(158, 88, 86, 20);
		panelReschedule.add(txtBookingNumber);
		txtBookingNumber.setColumns(10);
		
		JLabel lblSelectNewDate = new JLabel("Select New Date");
		lblSelectNewDate.setBounds(158, 119, 106, 14);
		panelReschedule.add(lblSelectNewDate);
		
		/**
		 * Confirm request button in Reschedule page
		 */
		JButton btnConfirmRequest = new JButton("Confirm Request");
		btnConfirmRequest.setBounds(201, 340, 150, 23);
		panelReschedule.add(btnConfirmRequest);
		
		/**
		 * Cancel button in Reschedule page, brings you back to Profile page
		 */
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
		
		/**
		 * Number of guest field in Reschedule page
		 */
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
		
		/**
		 * Message field in Reschedule page
		 */
		txtRescheduleMessage = new JTextField();
		txtRescheduleMessage.setBounds(158, 256, 250, 77);
		panelReschedule.add(txtRescheduleMessage);
		txtRescheduleMessage.setColumns(10);
		
		/**
		 * Date picker in Reschedule page
		 */
		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.setBounds(158, 144, 139, 20);
		panelReschedule.add(datePicker_1);
		
		/**
		 * Time picker in Reschedule page
		 */
		TimePicker timePicker_1 = new TimePicker();
		timePicker_1.setBounds(328, 142, 80, 23);
		panelReschedule.add(timePicker_1);

		JLabel lblSelectNewTime = new JLabel("Select New Time");
		lblSelectNewTime.setBounds(327, 119, 118, 14);
		panelReschedule.add(lblSelectNewTime);

		
		
		
		JLabel lblSupportPage = new JLabel("Support Page");
		lblSupportPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupportPage.setBounds(223, 11, 154, 25);
		panelSupport.add(lblSupportPage);
		
		JLabel lblRescheduleNum = new JLabel("Reschedule Request Numbers");
		lblRescheduleNum.setBounds(13, 81, 180, 14);
		panelSupport.add(lblRescheduleNum);
		
		/**
		 * Table showing booking numbers for rescheduling requests
		 */
		tblReschedule = new JTable();

		tblReschedule.setBounds(13, 102, 154, 64);

		panelSupport.add(tblReschedule);
		
		JLabel lblSDate = new JLabel("Date");
		lblSDate.setBounds(203, 81, 46, 14);
		panelSupport.add(lblSDate);
		
		/**
		 * Old date field in Support page
		 */
		txtOldDate = new JTextField();
		txtOldDate.setBounds(203, 110, 86, 20);
		panelSupport.add(txtOldDate);
		txtOldDate.setColumns(10);
		
		JLabel lblSTime = new JLabel("Time");
		lblSTime.setBounds(299, 81, 46, 14);
		panelSupport.add(lblSTime);
		
		/**
		 * Old time field in Support page
		 */
		txtOldTime = new JTextField();
		txtOldTime.setBounds(299, 110, 86, 20);
		panelSupport.add(txtOldTime);
		txtOldTime.setColumns(10);
		
		JLabel lblNumGuests = new JLabel("Number of Guests");
		lblNumGuests.setBounds(395, 81, 106, 14);
		panelSupport.add(lblNumGuests);
		
		/**
		 * Old number of guest field in Support page
		 */
		txtOldNumGuests = new JTextField();
		txtOldNumGuests.setBounds(395, 110, 86, 20);
		panelSupport.add(txtOldNumGuests);
		txtOldNumGuests.setColumns(10);
		
		JLabel lblMessage = new JLabel("Reason for Reschedule");
		lblMessage.setBounds(160, 253, 165, 14);
		panelSupport.add(lblMessage);
		

		JLabel lblNewDate = new JLabel("New Date");
		lblNewDate.setBounds(203, 152, 63, 14);
		panelSupport.add(lblNewDate);
		
		/**
		 * New date field in Support page
		 */
		txtNewDate = new JTextField();
		txtNewDate.setBounds(203, 177, 86, 20);
		panelSupport.add(txtNewDate);
		txtNewDate.setColumns(10);
		
		JLabel lblNewTime = new JLabel("New Time");
		lblNewTime.setBounds(299, 152, 78, 14);
		panelSupport.add(lblNewTime);
		
		/**
		 * New time field in Support page
		 */
		txtNewTime = new JTextField();
		txtNewTime.setBounds(299, 177, 86, 20);
		panelSupport.add(txtNewTime);
		txtNewTime.setColumns(10);
		
		JLabel lblNewNumGuests = new JLabel("New Number of Guests");
		lblNewNumGuests.setBounds(395, 152, 152, 14);
		panelSupport.add(lblNewNumGuests);
		
		/**
		 * New number of guest field in Support page
		 */
		txtNewNumGuests = new JTextField();
		txtNewNumGuests.setBounds(395, 177, 86, 20);
		panelSupport.add(txtNewNumGuests);
		txtNewNumGuests.setColumns(10);
		
		/**
		 * Support button to approve reschedule request
		 */
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Approved");
			}
		});
		btnApprove.setBounds(170, 374, 89, 23);
		panelSupport.add(btnApprove);
		
		/**
		 * Support button to deny reschedule request
		 */
		JButton btnDeny = new JButton("Deny");
		btnDeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Request Denied");
			}
		});
		btnDeny.setBounds(311, 374, 89, 23);
		panelSupport.add(btnDeny);
		
		/**
		 * TextArea for showing message linked to rescheduling request number
		 */
		JTextArea txtRescheduleMsg = new JTextArea();
		txtRescheduleMsg.setBounds(160, 278, 250, 77);
		panelSupport.add(txtRescheduleMsg);
		
		
	}
	
	
	/**
	 * @return void
	 * @param n = number of rooms to generate
	 */
	// this method generates a variable number of rooms
	private void populateRoomsTable(int n) {
		int room_number = 100;
		int maximum_capacity;
		
		String[] types = new String[] {"Personal Office", "Team Office", "Boardroom", "Convention Hall"};
		int t = types.length;
		
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		Room new_room = new Room();
		
		for(int i = 0; i < n; i++)
		{
			int type_index = randomize(t, 0);
			new_room.set_room_number(room_number++);
			new_room.set_type(types[type_index]);
			new_room.set_availability("Available");
			switch(type_index)
			{
				case 0:
					new_room.set_maximum_capacity(1);
					break;
				case 1:
					new_room.set_maximum_capacity(4);
					break;
				case 2: 
					new_room.set_maximum_capacity(10);
					break;
				case 3: 
					new_room.set_maximum_capacity(50);
					break;
				default:
					new_room.set_maximum_capacity(1);
					break;
			}
			
			roi.createRoom(new_room);
			rooms.add(new_room);
		}
	}
	
	private int randomize(int x, int y)
	{
		int rand = (int)((Math.random()*x)+y);
		return rand;
	}
	
	private void updateTable() {

		tm = new DefaultTableModel();
			
		//Setup the columns
		tm.addColumn("Id");
		tm.addColumn("Room");
		tm.addColumn("Date");
		tm.addColumn("Time");
		tm.addColumn("Reservation Number");
		
		//Populate the rows
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		res = ri.readAllReservations();
		
		for (Reservation r : res) {
			tm.addRow(r.getVector());
		}
		
		tblReservations.setModel(tm);
		
		
		//Default Row Sorter
		tblReservations.setRowSorter(new TableRowSorter(tm));
	}
}

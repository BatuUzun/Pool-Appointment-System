package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.GeneralManager;
import Classes.Lifeguard;
import Classes.Servant;
import Classes.Staff;
import Classes.User;
import Classes.UserSys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GeneralManagerScreenFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> workingDays;
	private ArrayList<String> workingDaysPending;
	private String workingDaysStr="";
	private String pendingWorkingDaysStr="";
	private User selectedUser;
	private User selectedPending;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralManagerScreenFrame frame = new GeneralManagerScreenFrame(null);
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
	public GeneralManagerScreenFrame(User currentUser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logInTypeLabel = new JLabel("");
		logInTypeLabel.setBounds(41, 22, 267, 13);
		contentPane.add(logInTypeLabel);
		
		JLabel lblNewLabel = new JLabel("Your name:");
		lblNewLabel.setBounds(10, 58, 77, 13);
		contentPane.add(lblNewLabel);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setBounds(112, 58, 196, 13);
		contentPane.add(nameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Your ID:");
		lblNewLabel_2.setBounds(10, 94, 58, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel idLabel = new JLabel("New label");
		idLabel.setBounds(112, 94, 113, 13);
		contentPane.add(idLabel);
		
		JPanel panelStaff = new JPanel();
		panelStaff.setBounds(10, 152, 215, 481);
		contentPane.add(panelStaff);
		panelStaff.setLayout(null);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Staff Information");
		lblNewLabel_1.setBounds(66, 13, 99, 13);
		panelStaff.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(10, 90, 54, 13);
		panelStaff.add(lblNewLabel_3);
		
		JLabel staffIdLabel = new JLabel("");
		staffIdLabel.setBounds(88, 90, 117, 13);
		panelStaff.add(staffIdLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Working days:");
		lblNewLabel_4.setBounds(10, 127, 99, 13);
		panelStaff.add(lblNewLabel_4);
		
		JTextArea textAreaStaff = new JTextArea();
		textAreaStaff.setOpaque(false);
		textAreaStaff.setBackground(new Color(240, 240, 240));
		textAreaStaff.setForeground(new Color(0, 0, 0));
		textAreaStaff.setEditable(false);
		textAreaStaff.setBounds(10, 155, 195, 105);
		panelStaff.add(textAreaStaff);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Information");
		lblNewLabel_7.setBounds(48, 270, 117, 13);
		panelStaff.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Tel No:");
		lblNewLabel_6.setBounds(10, 293, 54, 13);
		panelStaff.add(lblNewLabel_6);
		
		JLabel tellNoStaff = new JLabel("");
		tellNoStaff.setBounds(66, 293, 124, 13);
		panelStaff.add(tellNoStaff);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setBounds(10, 316, 54, 13);
		panelStaff.add(lblNewLabel_9);
		
		JLabel addressStaff = new JLabel("");
		addressStaff.setBounds(66, 316, 139, 13);
		panelStaff.add(addressStaff);
		
		JLabel lblNewLabel_11 = new JLabel("E-mail:");
		lblNewLabel_11.setBounds(10, 339, 45, 13);
		panelStaff.add(lblNewLabel_11);
		
		JLabel emailStaff = new JLabel("");
		emailStaff.setBounds(66, 339, 139, 13);
		panelStaff.add(emailStaff);
		
		
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Type:");
		lblNewLabel_8.setBounds(10, 362, 45, 13);
		panelStaff.add(lblNewLabel_8);
		
		JLabel typeStaff = new JLabel("");
		typeStaff.setBounds(66, 362, 77, 13);
		panelStaff.add(typeStaff);
		
		JPanel panelPending = new JPanel();
		panelPending.setBounds(239, 152, 215, 481);
		contentPane.add(panelPending);
		panelPending.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Request");
		lblNewLabel_5.setBounds(62, 10, 113, 13);
		panelPending.add(lblNewLabel_5);
		
		
		
		JLabel lblNewLabel_3_1 = new JLabel("ID:");
		lblNewLabel_3_1.setBounds(10, 89, 54, 13);
		panelPending.add(lblNewLabel_3_1);
		
		JLabel pendingIdLabel = new JLabel("");
		pendingIdLabel.setBounds(88, 89, 117, 13);
		panelPending.add(pendingIdLabel);
		
		JLabel lblNewLabel_4_1 = new JLabel("Working days:");
		lblNewLabel_4_1.setBounds(10, 126, 99, 13);
		panelPending.add(lblNewLabel_4_1);
		
		JTextArea textAreaPending = new JTextArea();
		textAreaPending.setOpaque(false);
		textAreaPending.setForeground(Color.BLACK);
		textAreaPending.setEditable(false);
		textAreaPending.setBackground(SystemColor.menu);
		textAreaPending.setBounds(10, 154, 195, 105);
		panelPending.add(textAreaPending);
		
		JLabel lblNewLabel_7_1 = new JLabel("Contact Information");
		lblNewLabel_7_1.setBounds(48, 269, 117, 13);
		panelPending.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tel No:");
		lblNewLabel_6_1.setBounds(10, 292, 54, 13);
		panelPending.add(lblNewLabel_6_1);
		
		JLabel tellNoPending = new JLabel("");
		tellNoPending.setBounds(66, 292, 124, 13);
		panelPending.add(tellNoPending);
		
		JLabel lblNewLabel_9_1 = new JLabel("Address:");
		lblNewLabel_9_1.setBounds(10, 315, 54, 13);
		panelPending.add(lblNewLabel_9_1);
		
		JLabel addressPending = new JLabel("");
		addressPending.setBounds(66, 315, 139, 13);
		panelPending.add(addressPending);
		
		JLabel lblNewLabel_11_1 = new JLabel("E-mail:");
		lblNewLabel_11_1.setBounds(10, 338, 45, 13);
		panelPending.add(lblNewLabel_11_1);
		
		JLabel emailPending = new JLabel("");
		emailPending.setBounds(66, 338, 139, 13);
		panelPending.add(emailPending);
		
		
		
		
		
		JComboBox comboBoxCurrentUsers = new JComboBox(fillStaffComboBox());
		comboBoxCurrentUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullCb = comboBoxCurrentUsers.getSelectedItem().toString();
				
				
					String[] cbItems = fullCb.split(" ");
					selectedUser = UserSys.searchUserByTcNo(cbItems[cbItems.length-1]);
				
				
				
				if(!comboBoxCurrentUsers.getSelectedItem().toString().equalsIgnoreCase("Choose")) {
					if(selectedUser instanceof Servant) {
						typeStaff.setText("Servant");
					}
					else if(selectedUser instanceof Lifeguard){
						typeStaff.setText("Lifeguard");
					}
					else;
				
				staffIdLabel.setText(selectedUser.getTcNo());
				tellNoStaff.setText(selectedUser.getUserContactInformation().getTelNo());
				emailStaff.setText(selectedUser.getUserContactInformation().getEmail());
				addressStaff.setText(selectedUser.getUserContactInformation().getAddress());
				
				workingDays = ((Staff)(selectedUser)).getWorkingDays();
				for(int i = 0;i<workingDays.size();i++) {
					workingDaysStr += workingDays.get(i)+"\n";
					
				}
				textAreaStaff.setText(workingDaysStr);
				workingDaysStr = "";
				
			}
				else {
					
						
					staffIdLabel.setText("");
					tellNoStaff.setText("");
					emailStaff.setText("");
					addressStaff.setText("");
					textAreaStaff.setText("");
					typeStaff.setText("");
					
				}
				
		}
		});
		comboBoxCurrentUsers.setBounds(10, 36, 155, 30);
		panelStaff.add(comboBoxCurrentUsers);
		
		nameLabel.setText(currentUser.getName()+" "+currentUser.getSurname());
		idLabel.setText(currentUser.getTcNo());
		logInTypeLabel.setText(((GeneralManager)(currentUser)).userLoginType());
		
		JButton deleteButton = new JButton("DELETE STAFF");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserSys.deleteUser(selectedUser.getTcNo());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboBoxCurrentUsers.setModel(new DefaultComboBoxModel(fillStaffComboBox()));
				staffIdLabel.setText("");
				tellNoStaff.setText("");
				emailStaff.setText("");
				addressStaff.setText("");
				textAreaStaff.setText("");
				typeStaff.setText("");
			}
		});
		deleteButton.setBounds(10, 433, 195, 38);
		panelStaff.add(deleteButton);
		
		JButton alterButton = new JButton("ALTER WORKING DAYS");
		alterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxCurrentUsers.getSelectedItem().toString().equalsIgnoreCase("choose")) {
					ChangeWorkingDayFrame changeFrame = new ChangeWorkingDayFrame(selectedUser);
					changeFrame.setVisible(true);
				}
				
				
			}
		});
		
		alterButton.setBounds(10, 385, 195, 38);
		panelStaff.add(alterButton);
		
		JLabel typePending = new JLabel("");
		typePending.setBounds(62, 362, 91, 13);
		panelPending.add(typePending);
		
		JComboBox comboBoxPending = new JComboBox(fillPendingComboBox());
		comboBoxPending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullCb = comboBoxPending.getSelectedItem().toString();
				
				
				String[] cbItems = fullCb.split(" ");
				selectedPending = UserSys.searchPendingByTcNo(cbItems[cbItems.length-1]);
			
			
			
			if(!comboBoxPending.getSelectedItem().toString().equalsIgnoreCase("Choose")) {
				if(selectedPending instanceof Servant) {
					typePending.setText("Servant");
				}
				else if(selectedPending instanceof Lifeguard){
					typePending.setText("Lifeguard");
				}
				else;
			
			pendingIdLabel.setText(selectedPending.getTcNo());
			tellNoPending.setText(selectedPending.getUserContactInformation().getTelNo());
			emailPending.setText(selectedPending.getUserContactInformation().getEmail());
			addressPending.setText(selectedPending.getUserContactInformation().getAddress()); 
			workingDaysPending = ((Staff)(selectedPending)).getWorkingDays(); 
			for(int i = 0;i<workingDaysPending.size();i++) { 
				pendingWorkingDaysStr += workingDaysPending.get(i)+"\n"; 
				
			} 
			textAreaPending.setText(pendingWorkingDaysStr);
			pendingWorkingDaysStr = "";
		
			}
			else {
				
					
				pendingIdLabel.setText("");
				tellNoPending.setText("");
				emailPending.setText("");
				addressPending.setText("");
				textAreaPending.setText("");
				typePending.setText("");
				
			}
			}
		});
		comboBoxPending.setBounds(10, 39, 165, 30);
		panelPending.add(comboBoxPending);
		
		JLabel lblNewLabel_10 = new JLabel("Type:");
		lblNewLabel_10.setBounds(10, 362, 45, 13);
		panelPending.add(lblNewLabel_10);
		
		JButton acceptButton = new JButton("ACCEPT STAFF");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectedPending = UserSys.deletePendingUser(selectedPending.getTcNo());
					if(selectedPending instanceof Servant)
						UserSys.addNewUserIntoAl("servant", selectedPending.getName(), selectedPending.getSurname(), selectedPending.getTcNo(), selectedPending.getBloodType(), selectedPending.getGender(), ((Servant)(selectedPending)).getSgkNo(), selectedPending.getUserContactInformation().getTelNo(), selectedPending.getUserContactInformation().getAddress(), selectedPending.getUserContactInformation().getEmail(), ((Staff)(selectedPending)).getWorkingDays().toArray(new String[0]));
					else
						UserSys.addNewUserIntoAl("lifeguard", selectedPending.getName(), selectedPending.getSurname(), selectedPending.getTcNo(), selectedPending.getBloodType(), selectedPending.getGender(), ((Lifeguard)(selectedPending)).getCertificationNumber(), selectedPending.getUserContactInformation().getTelNo(), selectedPending.getUserContactInformation().getAddress(), selectedPending.getUserContactInformation().getEmail(), ((Staff)(selectedPending)).getWorkingDays().toArray(new String[0]));

					UserSys.writeIntoRequest();
					UserSys.writeIntoFile();
					UserSys.readFromFile();					
					UserSys.readFromRequest();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboBoxPending.setModel(new DefaultComboBoxModel(fillPendingComboBox()));
				comboBoxCurrentUsers.setModel(new DefaultComboBoxModel(fillStaffComboBox()));
				pendingIdLabel.setText("");
				tellNoPending.setText("");
				emailPending.setText("");
				addressPending.setText("");
				textAreaPending.setText("");
				typePending.setText("");
			}
		});
		acceptButton.setBounds(10, 385, 195, 38);
		panelPending.add(acceptButton);
		
		JButton denyButton = new JButton("DENY STAFF");
		denyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectedPending = UserSys.deletePendingUser(selectedPending.getTcNo());
					
					UserSys.writeIntoRequest();
					
					UserSys.readFromRequest();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboBoxPending.setModel(new DefaultComboBoxModel(fillPendingComboBox()));
				comboBoxCurrentUsers.setModel(new DefaultComboBoxModel(fillStaffComboBox()));
				pendingIdLabel.setText("");
				tellNoPending.setText("");
				emailPending.setText("");
				addressPending.setText("");
				textAreaPending.setText("");
				typePending.setText("");
			}
		});
		denyButton.setBounds(10, 433, 195, 38);
		panelPending.add(denyButton);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInOrRegisterFrame logOrReg = new LogInOrRegisterFrame();
				logOrReg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(345, 18, 99, 21);
		contentPane.add(btnNewButton);
	}
	public String[] fillStaffComboBox() {
		String[] a = UserSys.getStaffNamesAndSurnames();
		return a;
	}
	
	public String[] fillPendingComboBox() {
		
		String[] a = UserSys.getPendingStaffNamesAndSurnames();
		return a;
	}
	
}

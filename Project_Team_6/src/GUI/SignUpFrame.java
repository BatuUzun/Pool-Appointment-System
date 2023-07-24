package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.AppointmentSys;
import Classes.User;
import Classes.UserSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.concurrent.TimeUnit;

import javax.swing.JRadioButton;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField tcTextField;
	private JTextField studentIdTextField;
	private String selectedType;
	private String tcString = "";
	private LogInOrRegisterFrame log = new LogInOrRegisterFrame();
	private JTextField speTextField;
	private String id="";
	private JTextField tellNoTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private String tellNo = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame frame = new SignUpFrame();
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
	public SignUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 680);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 28, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setBounds(10, 63, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC No:");
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Blood Type");
		lblNewLabel_3.setBounds(10, 199, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(10, 244, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("I am a ...");
		lblNewLabel_5.setBounds(10, 285, 66, 14);
		contentPane.add(lblNewLabel_5);
		
		nameTextField = new JTextField();
		nameTextField.setBackground(new Color(255, 255, 255));
		nameTextField.setBounds(93, 25, 118, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBackground(new Color(255, 255, 255));
		surnameTextField.setBounds(93, 60, 118, 20);
		contentPane.add(surnameTextField);
		surnameTextField.setColumns(10);
		
		tcTextField = new JTextField();
		tcTextField.setEditable(false);
		
		
		tcTextField.setBounds(93, 96, 118, 20);
		contentPane.add(tcTextField);
		tcTextField.setColumns(10);
		
		JComboBox bloodTypeComboBox = new JComboBox();
		bloodTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"ARh+", "ARh-", "BRh+", "BRh-", "0Rh+", "0Rh-", "ABRh+", "ABRh-"}));
		bloodTypeComboBox.setToolTipText("");
		bloodTypeComboBox.setBounds(93, 195, 86, 22);
		contentPane.add(bloodTypeComboBox);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderComboBox.setBounds(93, 240, 86, 22);
		contentPane.add(genderComboBox);
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Student id");
		lblNewLabel_6.setBounds(10, 11, 73, 14);
		
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(112, 8, 118, 20);
		
		studentIdTextField.setColumns(10);
		

		
		
		
		JButton goBackButton = new JButton("Back");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.setVisible(true);
				dispose();
			}
		});
		goBackButton.setBounds(70, 597, 89, 23);
		contentPane.add(goBackButton);
		
		
		
		
		JLabel cannotBeEmptyName = new JLabel("a");
		cannotBeEmptyName.setBounds(251, 28, 96, 14);
		contentPane.add(cannotBeEmptyName);
		
		JLabel cannotBeEmptySurname = new JLabel("a");
		cannotBeEmptySurname.setBounds(251, 63, 96, 14);
		contentPane.add(cannotBeEmptySurname);
		
		JLabel cannotBeEmptyTc = new JLabel("a");
		cannotBeEmptyTc.setBounds(251, 99, 189, 14);
		contentPane.add(cannotBeEmptyTc);
		
		JLabel cannotBeEmptySpe = new JLabel("a");
		cannotBeEmptySpe.setBounds(251, 317, 189, 20);
		contentPane.add(cannotBeEmptySpe);
		
		
	
		JButton okButton = new JButton("OK");
		okButton.setBounds(228, 597, 89, 23);
		contentPane.add(okButton);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="1";
				}
					
				tcTextField.setText(tcString);
			}
		});
		btn1.setBounds(10, 127, 54, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="2";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn2.setBounds(70, 127, 54, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="3";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn3.setBounds(134, 127, 54, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="4";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn4.setBounds(198, 127, 54, 23);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="5";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn5.setBounds(263, 127, 54, 23);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="6";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn6.setBounds(10, 158, 54, 23);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="7";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn7.setBounds(70, 158, 54, 23);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="8";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn8.setBounds(134, 158, 54, 23);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="9";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn9.setBounds(198, 158, 54, 23);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcString.length()<11) {
					tcString+="0";
					
				}
				tcTextField.setText(tcString);
			}
		});
		btn0.setBounds(263, 158, 54, 23);
		contentPane.add(btn0);
		
		JLabel informationLabel = new JLabel("Student id");
		informationLabel.setBounds(10, 323, 105, 14);
		contentPane.add(informationLabel);
		
		speTextField = new JTextField();
		speTextField.setEditable(false);
		speTextField.setBounds(125, 317, 118, 20);
		contentPane.add(speTextField);
		speTextField.setColumns(10);
		JComboBox typeComboBox = new JComboBox();
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Servant", "Lifeguard"}));
		typeComboBox.setBounds(93, 281, 86, 22);
		contentPane.add(typeComboBox);
		
		cannotBeEmptyName.setVisible(false);
		cannotBeEmptySpe.setVisible(false);
		cannotBeEmptySurname.setVisible(false);
		cannotBeEmptyTc.setVisible(false);
		
		JButton btn1_1 = new JButton("1");
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="1";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="1";
						
					}
				}
				speTextField.setText(id);
				
			}
		});
		btn1_1.setBounds(10, 348, 54, 23);
		contentPane.add(btn1_1);
		
		JButton btn6_1 = new JButton("6");
		btn6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="6";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="6";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn6_1.setBounds(10, 382, 54, 23);
		contentPane.add(btn6_1);
		
		JButton btn7_1 = new JButton("7");
		btn7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="7";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="7";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn7_1.setBounds(70, 382, 54, 23);
		contentPane.add(btn7_1);
		
		JButton btn2_1 = new JButton("2");
		btn2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="2";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="2";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn2_1.setBounds(70, 348, 54, 23);
		contentPane.add(btn2_1);
		
		JButton btn3_1 = new JButton("3");
		btn3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="3";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="3";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn3_1.setBounds(134, 348, 54, 23);
		contentPane.add(btn3_1);
		
		JButton btn8_1 = new JButton("8");
		btn8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="8";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="8";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn8_1.setBounds(134, 382, 54, 23);
		contentPane.add(btn8_1);
		
		JButton btn9_1 = new JButton("9");
		btn9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="9";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="9";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn9_1.setBounds(198, 382, 54, 23);
		contentPane.add(btn9_1);
		
		JButton btn4_1 = new JButton("4");
		btn4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="4";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="4";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn4_1.setBounds(198, 348, 54, 23);
		contentPane.add(btn4_1);
		
		JButton btn5_1 = new JButton("5");
		btn5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="5";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="5";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn5_1.setBounds(263, 348, 54, 23);
		contentPane.add(btn5_1);
		
		JButton btn0_1 = new JButton("0");
		btn0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					if(id.length()<8)
					{
						id+="0";
						
					}
					
					
				}
				else  {
					if(id.length()<3) {
						id+="0";
						
					}
				}
				speTextField.setText(id);
			}
		});
		btn0_1.setBounds(263, 382, 54, 23);
		contentPane.add(btn0_1);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcString = tcString.substring(0, tcString.length()-1);
				tcTextField.setText(tcString);
				
				
				
				
			}
		});
		btnNewButton.setBounds(348, 127, 92, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id.substring(0, id.length()-1);
				speTextField.setText(id);
				
				
			}
		});
		btnNewButton_1.setBounds(348, 348, 94, 57);
		contentPane.add(btnNewButton_1);
		
		JPanel workingDaysPanel = new JPanel();
		workingDaysPanel.setBounds(228, 195, 212, 111);
		contentPane.add(workingDaysPanel);
		workingDaysPanel.setLayout(null);
		workingDaysPanel.setVisible(false);
		
		JLabel lblNewLabel_7 = new JLabel("Select Working Days");
		lblNewLabel_7.setBounds(15, 11, 125, 14);
		workingDaysPanel.add(lblNewLabel_7);
		
		JRadioButton sundayBtn = new JRadioButton("Sunday");
		sundayBtn.setSelected(true);
		sundayBtn.setBounds(6, 32, 77, 23);
		workingDaysPanel.add(sundayBtn);
		
		JRadioButton tuesdayBtn = new JRadioButton("Tuesday");
		tuesdayBtn.setBounds(6, 58, 77, 23);
		workingDaysPanel.add(tuesdayBtn);
		
		JRadioButton wednesdayBtn = new JRadioButton("Wednesday");
		wednesdayBtn.setBounds(6, 84, 109, 23);
		workingDaysPanel.add(wednesdayBtn);
		
		JRadioButton thursdayBtn = new JRadioButton("Thursday");
		thursdayBtn.setBounds(117, 32, 89, 23);
		workingDaysPanel.add(thursdayBtn);
		
		JRadioButton fridayBtn = new JRadioButton("Friday");
		fridayBtn.setBounds(117, 58, 66, 23);
		workingDaysPanel.add(fridayBtn);
		
		JRadioButton saturdayBtn = new JRadioButton("Saturday");
		saturdayBtn.setBounds(117, 84, 77, 23);
		workingDaysPanel.add(saturdayBtn);
		
		JLabel lblNewLabel_8 = new JLabel("Tell No");
		lblNewLabel_8.setBounds(10, 427, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address");
		lblNewLabel_9.setBounds(10, 528, 54, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail");
		lblNewLabel_10.setBounds(10, 556, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		tellNoTextField = new JTextField();
		tellNoTextField.setEditable(false);
		tellNoTextField.setBounds(66, 424, 113, 20);
		contentPane.add(tellNoTextField);
		tellNoTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(66, 525, 145, 20);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(66, 553, 145, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel cannotBeEmptyTellNo = new JLabel("a");
		cannotBeEmptyTellNo.setBounds(213, 427, 180, 14);
		contentPane.add(cannotBeEmptyTellNo);
		
		JButton btn1_1_1 = new JButton("1");
		btn1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="1";
					tellNoTextField.setText(tellNo);
				}
			}
		});
		btn1_1_1.setBounds(10, 452, 54, 23);
		contentPane.add(btn1_1_1);
		
		JButton btn6_1_1 = new JButton("6");
		btn6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="6";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn6_1_1.setBounds(10, 486, 54, 23);
		contentPane.add(btn6_1_1);
		
		JButton btn7_1_1 = new JButton("7");
		btn7_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="7";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn7_1_1.setBounds(70, 486, 54, 23);
		contentPane.add(btn7_1_1);
		
		JButton btn2_1_1 = new JButton("2");
		btn2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="2";
					tellNoTextField.setText(tellNo);					
				}
			}
		});
		btn2_1_1.setBounds(70, 452, 54, 23);
		contentPane.add(btn2_1_1);
		
		
		JButton btn3_1_1 = new JButton("3");
		btn3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="3";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn3_1_1.setBounds(134, 452, 54, 23);
		contentPane.add(btn3_1_1);
		
		JButton btn8_1_1 = new JButton("8");
		btn8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="8";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn8_1_1.setBounds(134, 486, 54, 23);
		contentPane.add(btn8_1_1);
		
		JButton btn9_1_1 = new JButton("9");
		btn9_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="9";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn9_1_1.setBounds(198, 486, 54, 23);
		contentPane.add(btn9_1_1);
		
		JButton btn4_1_1 = new JButton("4");
		btn4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="4";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn4_1_1.setBounds(198, 452, 54, 23);
		contentPane.add(btn4_1_1);
		
		JButton btn5_1_1 = new JButton("5");
		btn5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="5";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn5_1_1.setBounds(263, 452, 54, 23);
		contentPane.add(btn5_1_1);
		
		JButton btn0_1_1 = new JButton("0");
		btn0_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tellNo.length()<11)
				{
					tellNo+="0";
					tellNoTextField.setText(tellNo);
					
				}
			}
		});
		btn0_1_1.setBounds(263, 486, 54, 23);
		contentPane.add(btn0_1_1);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tellNo = tellNo.substring(0, tellNo.length()-1);
				tellNoTextField.setText(tellNo);
				
				
			}
		});
		btnNewButton_1_1.setBounds(348, 452, 92, 57);
		contentPane.add(btnNewButton_1_1);
		
		JLabel cannotBeEmptyAddress = new JLabel("a");
		cannotBeEmptyAddress.setBounds(251, 528, 174, 14);
		contentPane.add(cannotBeEmptyAddress);
		
		JLabel cannotBeEmptyEmail = new JLabel("a");
		cannotBeEmptyEmail.setBounds(251, 556, 142, 14);
		contentPane.add(cannotBeEmptyEmail);
		typeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeComboBox.getSelectedItem().equals("Student")) {
					informationLabel.setText("Student Id");
					id="";
					speTextField.setText(id);
					cannotBeEmptySpe.setText("");
					workingDaysPanel.setVisible(false);
				}
					
				else if(typeComboBox.getSelectedItem().equals("Servant")) {
					informationLabel.setText("SGK No");
					id="";
					speTextField.setText(id);
					cannotBeEmptySpe.setText("");
					workingDaysPanel.setVisible(true);
				}
				else {
					informationLabel.setText("Certification No");
					id="";
					speTextField.setText(id);
					cannotBeEmptySpe.setText("");
					workingDaysPanel.setVisible(true);
				}
					
			}
		});
		
		cannotBeEmptyAddress.setVisible(false);
		cannotBeEmptyEmail.setVisible(false);
		cannotBeEmptyTellNo.setVisible(false);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cannotBeEmptyName.setVisible(true);
				cannotBeEmptySpe.setVisible(true);
				cannotBeEmptySurname.setVisible(true);
				cannotBeEmptyTc.setVisible(true);
				
				cannotBeEmptyAddress.setVisible(true);
				cannotBeEmptyEmail.setVisible(true);
				cannotBeEmptyTellNo.setVisible(true);
				if(tellNoTextField.getText().isEmpty()) {
					cannotBeEmptyTellNo.setText("cannot be empty");
				}
				else {
					if(tellNo.length()<11) {
						cannotBeEmptyTellNo.setText("Tell No must be 11 digits");
					}
					else
						cannotBeEmptyTellNo.setText("");
				}
				
				if(emailTextField.getText().isEmpty()) {
					cannotBeEmptyEmail.setText("cannot be empty");
				}
				else {
					cannotBeEmptyEmail.setText("");
				}
				
				
				if(addressTextField.getText().isEmpty()) {
					cannotBeEmptyAddress.setText("cannot be empty");
				}
				else {
					cannotBeEmptyAddress.setText("");
				}
				
				
				
				if(nameTextField.getText().isEmpty()) {
					cannotBeEmptyName.setText("cannot be empty");
					
				}
				else {
					cannotBeEmptyName.setText("");
					
				}
					
				
				if(surnameTextField.getText().isEmpty()) {
					cannotBeEmptySurname.setText("cannot be empty");
					
				}
				else {
					cannotBeEmptySurname.setText("");
					
				}
					
				
				if(tcTextField.getText().isEmpty()) {
					
					cannotBeEmptyTc.setText("cannot be empty");
					
				}
				else {
					if(tcString.length()<11) {
						cannotBeEmptyTc.setText("TC must be 11 digits");
						
					}
					else {
						cannotBeEmptyTc.setText("");
						
					}
						
				}
					
				
				
				if(speTextField.getText().isEmpty()) {
					cannotBeEmptySpe.setText("cannot be empty");
					
				}
				else {
					if(typeComboBox.getSelectedItem().equals("Student")) {
						if(id.length()<8)
							cannotBeEmptySpe.setText("Id must be 8 digits");
						else
							cannotBeEmptySpe.setText("");

						
					}
					
					if(typeComboBox.getSelectedItem().equals("Servant")) {
						if(id.length()<3)
							cannotBeEmptySpe.setText("SGK No must be 3 digits");
						else
							cannotBeEmptySpe.setText("");
					}
					
					if(typeComboBox.getSelectedItem().equals("Lifeguard")) {
						if(id.length()<3)
							cannotBeEmptySpe.setText("Certification No must be 3 digits");
						else
							cannotBeEmptySpe.setText("");
					}
					
				}
				/*
				 String type***, String name****, String surname****,
			 String tcNo***,String bloodType***,String gender***, String id***, String telNo, String address,
			 String email, String[] days
				 */
				User checkUser;
				User checkPendingUser;
				String capital="";
				checkUser = UserSys.searchUserByTcNo(tcString);
				checkPendingUser = UserSys.searchPendingByTcNo(tcString);
				int size = 0;
				String[] days;
				if(cannotBeEmptyName.getText().isEmpty() && cannotBeEmptySpe.getText().isEmpty() 
						&& cannotBeEmptySurname.getText().isEmpty() && cannotBeEmptyTc.getText().isEmpty()
						&& cannotBeEmptyAddress.getText().isEmpty() && cannotBeEmptyEmail.getText().isEmpty()
						&& cannotBeEmptyTellNo.getText().isEmpty()) {
					if(sundayBtn.isSelected()) {
						size++;
						capital +="Sunday,";
					}
					if(tuesdayBtn.isSelected()) {
						size++;
						capital +="Tuesday,";
					}
					if(wednesdayBtn.isSelected()) {
						size++;
						capital +="Wednesday,";
					}
					if(thursdayBtn.isSelected()) {
						size++;
						capital +="Thursday,";
					}
					if(fridayBtn.isSelected()) {
						size++;
						capital +="Friday,";
					}
					if(saturdayBtn.isSelected()) {
						size++;
						capital +="Saturday,";
					}		
					if(capital.equalsIgnoreCase(""))
						capital = "Sunday,";
					capital=capital.substring(0, capital.length()-1);
					days = capital.split("\\,", size);
					
					if(surnameTextField.getText().contains(" ")) {
						surnameTextField.setText(surnameTextField.getText().replace(" ", ""));
					}
					if(addressTextField.getText().contains(" ")) {
						addressTextField.setText(addressTextField.getText().replace(" ", "/"));
					}
					if(emailTextField.getText().contains(" ")) {
						emailTextField.setText(emailTextField.getText().replace(" ", ""));
					}
					
					
					if(checkUser == null && checkPendingUser == null) {
						
						capital = nameTextField.getText().substring(0,1).toUpperCase();
						nameTextField.setText(capital+nameTextField.getText().substring(1));
						
						capital = surnameTextField.getText().substring(0,1).toUpperCase();
						surnameTextField.setText(capital+surnameTextField.getText().substring(1));
						if(typeComboBox.getSelectedItem().equals("Student")) {
							
							UserSys.addNewUserIntoAl("student", nameTextField.getText(), 
									surnameTextField.getText(), tcTextField.getText(), 
									bloodTypeComboBox.getSelectedItem().toString(), 
									genderComboBox.getSelectedItem().toString(),speTextField.getText(), 
									tellNoTextField.getText(), addressTextField.getText(),
									emailTextField.getText(), days);
							
							
						}
						else if(typeComboBox.getSelectedItem().equals("Servant")) {
							
							UserSys.addPendingUser("Servant", nameTextField.getText(), 
									surnameTextField.getText(), tcTextField.getText(), 
									bloodTypeComboBox.getSelectedItem().toString(), 
									genderComboBox.getSelectedItem().toString(),speTextField.getText(), 
									tellNoTextField.getText(), addressTextField.getText(),
									emailTextField.getText(), days);
							
							
							
							
							
							
						}
						
						else {
							UserSys.addPendingUser("Lifeguard", nameTextField.getText(), 
									surnameTextField.getText(), tcTextField.getText(), 
									bloodTypeComboBox.getSelectedItem().toString(), 
									genderComboBox.getSelectedItem().toString(),speTextField.getText(), 
									tellNoTextField.getText(), addressTextField.getText(),
									emailTextField.getText(), days);
							
							
							
							
						}
						
						try {
							UserSys.writeIntoRequest();
							UserSys.readFromRequest();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						okButton.setBackground(Color.green);
						
					}
					else {//tc is exist
						okButton.setBackground(Color.red);
						cannotBeEmptyTc.setText("TC is already exist");
						
					}
					
				
					

				
				
				
				}
				else {
					okButton.setBackground(Color.red);
				}
			try {
				UserSys.writeIntoFile();
				//AppointmentSys.writeIntoAppointment();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		
		
		
	}
}

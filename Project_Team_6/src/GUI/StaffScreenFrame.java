package GUI;

import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Lifeguard;
import Classes.Servant;
import Classes.Staff;
import Classes.User;
import Classes.UserSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class StaffScreenFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> workingDays = new ArrayList();
	private String workingDaysStr="";
	private NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
	private String moneyText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffScreenFrame frame = new StaffScreenFrame(null);
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
	public StaffScreenFrame(User currentUser) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your ID:");
		lblNewLabel.setBounds(37, 80, 92, 13);
		contentPane.add(lblNewLabel);
		
		JLabel logInTypeLabel = new JLabel("");
		logInTypeLabel.setBounds(37, 41, 273, 13);
		contentPane.add(logInTypeLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Your name:");
		lblNewLabel_2.setBounds(37, 121, 81, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your work days:");
		lblNewLabel_3.setBounds(37, 172, 101, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Your salary: ");
		lblNewLabel_5.setBounds(37, 412, 86, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel idLabel = new JLabel("");
		idLabel.setBounds(145, 80, 200, 13);
		contentPane.add(idLabel);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(145, 121, 200, 13);
		contentPane.add(nameLabel);
		
		JLabel salaryLabel = new JLabel("");
		salaryLabel.setBounds(145, 412, 200, 13);
		contentPane.add(salaryLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
		textArea.setEditable(false);
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(148, 171, 241, 106);
		contentPane.add(textArea);
		
		workingDays = ((Staff)(currentUser)).getWorkingDays();
		for(int i = 0;i<workingDays.size();i++) {
			workingDaysStr += workingDays.get(i)+"\n";
			
		}
		textArea.setText(workingDaysStr);
		
		JLabel lblNewLabel_1 = new JLabel("Your e-mail:");
		lblNewLabel_1.setBounds(37, 300, 81, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel emailLabel = new JLabel("New label");
		emailLabel.setBounds(145, 300, 200, 13);
		contentPane.add(emailLabel);
		emailLabel.setText(currentUser.getUserContactInformation().getEmail());
		nameLabel.setText(currentUser.getName().toUpperCase()+" "+currentUser.getSurname().toUpperCase());
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInOrRegisterFrame logOrReg = new LogInOrRegisterFrame();
				logOrReg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(337, 33, 85, 21);
		contentPane.add(btnNewButton);
		if(currentUser instanceof Lifeguard) {
			((Lifeguard)(currentUser)).setSalary(((Lifeguard)(currentUser)).calculateSalary());
			moneyText = formatter.format(((Staff)(currentUser)).getSalary());
			logInTypeLabel.setText(((Lifeguard)(currentUser)).userLoginType().toUpperCase());
			
			idLabel.setText(Integer.toString(((Staff)(currentUser)).getStaffId()));
			salaryLabel.setText(moneyText);
			
			
			
		}
		else {
			((Servant)(currentUser)).setSalary(((Servant)(currentUser)).calculateSalary());
			moneyText = formatter.format(((Staff)(currentUser)).getSalary());
			logInTypeLabel.setText(((Servant)(currentUser)).userLoginType().toUpperCase());
			
			idLabel.setText(Integer.toString(((Staff)(currentUser)).getStaffId()));
			salaryLabel.setText(moneyText);
			
			
		}
		
		
	}
}

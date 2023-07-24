package GUI;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.AppointmentSys;
import Classes.UserSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogInOrRegisterFrame extends JFrame {

	private ImageIcon poolPng = new ImageIcon("images/pool.png");
	
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInOrRegisterFrame frame = new LogInOrRegisterFrame();
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
	public LogInOrRegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel poolPhoto = new JLabel("");
		poolPhoto.setBounds(0, 11, 450, 223);
		contentPane.add(poolPhoto);
		poolPhoto.setIcon(poolPng);
		
		JButton signUpButton = new JButton("Create an acoount");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						UserSys.readFromFile();
						UserSys.readFromRequest();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SignUpFrame signUp = new SignUpFrame();
				dispose();
				signUp.setVisible(true);
				
				
			}
		});
		signUpButton.setBounds(10, 251, 159, 23);
		contentPane.add(signUpButton);
		
		JButton studentLogInButton = new JButton("Student");
		studentLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserSys.readFromFile();
					AppointmentSys.readFromAppointment();
					
					UserSys.writeIntoFile();
					UserSys.readFromFile();
					
					UserSys.readFromRequest();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				StudentLogInFrame stuLog = new StudentLogInFrame();
				stuLog.setVisible(true);
				dispose();
			}
		});
		studentLogInButton.setBounds(10, 346, 81, 23);
		contentPane.add(studentLogInButton);
		
		JButton ServantLogInButton = new JButton("Servant");
		ServantLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserSys.readFromFile();
					UserSys.readFromRequest();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ServantLogInFrame servantLogIn = new ServantLogInFrame();
				servantLogIn.setVisible(true);
				dispose();
			}
		});
		ServantLogInButton.setBounds(200, 346, 89, 23);
		contentPane.add(ServantLogInButton);
		
		JButton lifeGuardLogInButton = new JButton("Lifeguard");
		lifeGuardLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserSys.readFromFile();
					UserSys.readFromRequest();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LifeguardLogInFrame lifeguardLog = new LifeguardLogInFrame();
				lifeguardLog.setVisible(true);
				dispose();
			}
		});
		lifeGuardLogInButton.setBounds(101, 346, 89, 23);
		contentPane.add(lifeGuardLogInButton);
		
		JButton managerLogInButton = new JButton("General Manager");
		managerLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserSys.readFromFile();
					UserSys.readFromRequest();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GeneralManagerLogInFrame managerLogIn = new GeneralManagerLogInFrame();
				managerLogIn.setVisible(true);
				dispose();
			}
		});
		managerLogInButton.setBounds(299, 346, 141, 23);
		contentPane.add(managerLogInButton);
		
		JLabel lblNewLabel = new JLabel("OR, I am a");
		lblNewLabel.setBounds(173, 305, 116, 14);
		contentPane.add(lblNewLabel);
	}
}

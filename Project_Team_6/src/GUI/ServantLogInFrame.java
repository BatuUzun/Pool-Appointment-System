package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Servant;
import Classes.User;
import Classes.UserSys;

public class ServantLogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String tcNo="";
	private User searchedUser;
	private ImageIcon poolPng = new ImageIcon("images/servant.jpg");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServantLogInFrame frame = new ServantLogInFrame();
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
	public ServantLogInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC No");
		lblNewLabel.setBounds(29, 341, 57, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(121, 338, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="1";
				}
				textField.setText(tcNo);
			}
		});
		btn1.setBounds(10, 369, 54, 23);
		contentPane.add(btn1);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="6";
				}
				textField.setText(tcNo);
			}
		});
		btn6.setBounds(10, 400, 54, 23);
		contentPane.add(btn6);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="2";
				}
				textField.setText(tcNo);
			}
		});
		btn2.setBounds(70, 369, 54, 23);
		contentPane.add(btn2);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="7";
				}
				textField.setText(tcNo);
			}
		});
		btn7.setBounds(70, 400, 54, 23);
		contentPane.add(btn7);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="3";
				}
				textField.setText(tcNo);
			}
		});
		btn3.setBounds(134, 369, 54, 23);
		contentPane.add(btn3);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="8";
				}
				textField.setText(tcNo);
			}
		});
		btn8.setBounds(134, 400, 54, 23);
		contentPane.add(btn8);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="4";
				}
				textField.setText(tcNo);
			}
		});
		btn4.setBounds(198, 369, 54, 23);
		contentPane.add(btn4);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="9";
				}
				textField.setText(tcNo);
			}
		});
		btn9.setBounds(198, 400, 54, 23);
		contentPane.add(btn9);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="5";
				}
				textField.setText(tcNo);
			}
		});
		btn5.setBounds(263, 369, 54, 23);
		contentPane.add(btn5);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcNo.length()<11) {
					tcNo+="0";
				}
				textField.setText(tcNo);
			}
		});
		btn0.setBounds(263, 400, 54, 23);
		contentPane.add(btn0);
		
		JButton btnDel = new JButton("DELETE");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcNo = tcNo.substring(0, tcNo.length()-1);
				textField.setText(tcNo);
			}
		});
		btnDel.setBounds(348, 369, 102, 54);
		contentPane.add(btnDel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 481, 450, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setBounds(10, 21, 95, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("***Password is your SGK no***");
		lblNewLabel_2.setBounds(10, 56, 202, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 18, 132, 17);
		panel.add(passwordField);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(((Servant)(searchedUser)).getSgkNo().equalsIgnoreCase(String.valueOf(passwordField.getPassword()))) {
					StaffScreenFrame staffScreenFrame = new StaffScreenFrame(searchedUser);
					staffScreenFrame.setVisible(true);
					dispose();
				}
				else {
					okBtn.setBackground(Color.red);
				}
			}
		});
		okBtn.setBounds(158, 96, 89, 23);
		panel.add(okBtn);
		
		JButton contButton = new JButton("CONTINUE");
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchedUser = UserSys.searchUserByTcNo(textField.getText());
				if(searchedUser == null || !(searchedUser instanceof Servant)) {
					contButton.setBackground(Color.red);
				}
				else {
					panel.setVisible(true);
					contButton.setBackground(Color.green);
					btn1.setEnabled(false);
					btn2.setEnabled(false);
					btn3.setEnabled(false);
					btn4.setEnabled(false);
					btn5.setEnabled(false);
					btn6.setEnabled(false);
					btn7.setEnabled(false);
					btn8.setEnabled(false);
					btn9.setEnabled(false);
					btn0.setEnabled(false);
					btnDel.setEnabled(false);
					
					
				}
				
			}
		});
		contButton.setBounds(282, 447, 118, 23);
		contentPane.add(contButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInOrRegisterFrame logIn = new LogInOrRegisterFrame();
				logIn.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(85, 447, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel imageLbl = new JLabel("");
		imageLbl.setBounds(0, 11, 460, 311);
		contentPane.add(imageLbl);
		imageLbl.setIcon(poolPng);
		
	}
}

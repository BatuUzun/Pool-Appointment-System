package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.AppointmentSys;
import Classes.Student;
import Classes.User;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class StudentScreenFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScreenFrame frame = new StudentScreenFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public StudentScreenFrame(User currentUser) throws FileNotFoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logTypeLabel = new JLabel("New label");
		logTypeLabel.setBounds(46, 51, 238, 13);
		contentPane.add(logTypeLabel);
		logTypeLabel.setText(((Student)(currentUser)).userLoginType());
		
		JTextArea textAreaInfo = new JTextArea(((Student)(currentUser)).toString());
		textAreaInfo.setOpaque(false);
		textAreaInfo.setBackground(new Color(240, 240, 240));
		textAreaInfo.setBounds(46, 119, 337, 252);
		contentPane.add(textAreaInfo);
		textAreaInfo.setText(((Student)(currentUser)).toString());
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInOrRegisterFrame logOrReg = new LogInOrRegisterFrame();
				logOrReg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(331, 25, 102, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESERVATION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentBookFrame bookFrame = new StudentBookFrame(currentUser);
				
				bookFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(46, 381, 124, 43);
		contentPane.add(btnNewButton_1);
		if(((Student)(currentUser)).getAppointment()[0] ==0 || ((Student)(currentUser)).getAppointment()[1] ==0) {
			btnNewButton_1.setEnabled(true);
		}
		else {
			btnNewButton_1.setEnabled(false);

		}
			
	}
}

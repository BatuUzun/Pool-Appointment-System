package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.User;
import Classes.UserSys;
import Classes.Staff;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ChangeWorkingDayFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeWorkingDayFrame frame = new ChangeWorkingDayFrame(null);
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
	public ChangeWorkingDayFrame(User selectedUser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select working days");
		lblNewLabel.setBounds(189, 53, 138, 13);
		contentPane.add(lblNewLabel);
		
		JRadioButton sundayRB = new JRadioButton("Sunday");
		sundayRB.setSelected(true);
		sundayRB.setBounds(83, 102, 103, 21);
		contentPane.add(sundayRB);
		
		JRadioButton tuesdayRB = new JRadioButton("Tuesday");
		tuesdayRB.setBounds(83, 139, 103, 21);
		contentPane.add(tuesdayRB);
		
		JRadioButton wednesdayRB = new JRadioButton("Wednesday");
		wednesdayRB.setBounds(83, 184, 103, 21);
		contentPane.add(wednesdayRB);
		
		JRadioButton thursdayRB = new JRadioButton("Thursday");
		thursdayRB.setBounds(297, 102, 103, 21);
		contentPane.add(thursdayRB);
		
		JRadioButton fridayRB = new JRadioButton("Friday");
		fridayRB.setBounds(297, 139, 103, 21);
		contentPane.add(fridayRB);
		
		JRadioButton saturdayRB = new JRadioButton("Saturday");
		saturdayRB.setBounds(297, 184, 103, 21);
		contentPane.add(saturdayRB);
		
		JButton saveBtn = new JButton("SAVE");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> days = new ArrayList();
				boolean isSelected = false;
				if(sundayRB.isSelected()) {
					days.add("Sunday");
					isSelected = true;

				}
				if(tuesdayRB.isSelected()) {
					days.add("Tuesday");
					isSelected = true;
				}
				if(wednesdayRB.isSelected()) {
					days.add("Wednesday");
					isSelected = true;
				}
				if(thursdayRB.isSelected()) {
					days.add("Thursday");
					isSelected = true;
				}
				if(fridayRB.isSelected()) {
					days.add("Friday");
					isSelected = true;
				}
				if(saturdayRB.isSelected()) {
					days.add("Saturday");
					isSelected = true;
				}
				if(isSelected) {
					((Staff)(selectedUser)).setWorkingDays(days);
					try {
						
						UserSys.writeIntoFile();
						UserSys.readFromFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					dispose();
				}
				else {
					saveBtn.setBackground(Color.red);
				}
					
			}
		});
		saveBtn.setBounds(97, 247, 103, 21);
		contentPane.add(saveBtn);
		
		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backBtn.setBounds(297, 247, 103, 21);
		contentPane.add(backBtn);
	}
	public String dayText(String str) {
		return str;
	}
}

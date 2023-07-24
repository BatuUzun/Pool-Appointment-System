package GUI;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Classes.AppointmentSys;
import Classes.Student;
import Classes.User;
import Classes.UserSys;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentBookFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentBookFrame frame = new StudentBookFrame(null);
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
    public StudentBookFrame(User currentUser) {
    	AppointmentSys.calcAppointment();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reservation Table");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(272, 10, 226, 53);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Please choose the day and hour for your appointment.");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(37, 121, 391, 53);
        contentPane.add(lblNewLabel_1);
        
        

        // Create labels for days
        String[] days = {"","Sunday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < days.length; i++) {
            JLabel dayLabel = new JLabel(days[i]);
            dayLabel.setBounds(10, 30 * (i-1) + 230, 60, 20);
            contentPane.add(dayLabel);
        }

        // Create labels for hours
        String[] hours = {"","9.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00"};
        for (int i = 1; i < hours.length; i++) {
            JLabel hourLabel = new JLabel(hours[i]);
            hourLabel.setBounds(70 * (i + 1) + 5, 10 + 190, 60, 20);
            contentPane.add(hourLabel);
        }

     // Create selectable buttons
        JButton[][] buttons = new JButton[days.length][hours.length];
        Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 6);
        for (int i = 1; i < days.length; i++) {
            for (int j = 1; j < hours.length; j++) {
                int dayIndex = i; // capture day index for ActionListener
                int hourIndex = j; // capture hour index for ActionListener

                JButton button = new JButton("Reserve");
                button.setBounds(70 * (j + 1), 30 * (i ) + 200, 60, 20);
                button.setFont(buttonFont);
                buttons[i][j] = button;
                contentPane.add(button);
                //AppointmentSys.calcAppointment();
                // Disable button if appointmentCounter exceeds 5
                if (AppointmentSys.appointmentCounter[dayIndex][hourIndex] >= 5) {
                    button.setEnabled(false);
                }

                // Add ActionListener to the button
                button.addActionListener(e -> {
                    int result = JOptionPane.showConfirmDialog(contentPane,
                            "Do you want to get an appointment for " + days[dayIndex] + " " + hours[hourIndex] + "?",
                            "Appointment Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        int[] arrayName = new int[2];
                        
                        	arrayName[0] = dayIndex;
                        
                        arrayName[1] = hourIndex;

                        if (AppointmentSys.appointmentCounter[dayIndex][hourIndex] <=6 ) {
                            AppointmentSys.addNewAppointment((Student) currentUser, arrayName);
                            JOptionPane.showMessageDialog(contentPane, "Appointment booked!");
                            ((Student)(currentUser)).setAppointment(arrayName);
                            try {
								
								//AppointmentSys.addNewAppointment(((Student)(currentUser)), arrayName);
								UserSys.readFromFile();
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                            button.setEnabled(true);
                        } else {
                            button.setEnabled(false);
                            JOptionPane.showMessageDialog(contentPane, "No more appointments available for " + days[dayIndex] + " " + hours[hourIndex]);
                        }
                        
                        
                        
                        try {
							StudentScreenFrame screenFrm = new StudentScreenFrame(currentUser);
							screenFrm.setVisible(true);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        
                        //AppointmentSys.calcAppointment();
                        
                        dispose();
                    }
                    
                });
            }
        }


    }
}
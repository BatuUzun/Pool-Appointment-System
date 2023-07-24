package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentSys {
	public static int[][] appointmentCounter = new int[7][9];
	private static String[] daysIndextoName = {"", "Sunday","Tuesday", "Wednesday","Thursday","Friday",
													"Saturday"};
	private static String[] hoursIndextoName = {"","From 9am-10am", 
												"From 10am-11am",
												"From 11am-12pm",
												"From 12pm-1pm",
												"From 1pm-2pm",
												"From 2pm-3pm",
												"From 3pm-4pm",
												"From 4pm-5pm"};
	
	private static final int MAXAPPOINTMENTPERHOUR = 6;
	

	public static void calcAppointment() {
	    Path appointmentFile = Paths.get("txtfiles/Appointment.txt");

	    try (Scanner scanner = new Scanner(appointmentFile)) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] appointmentData = line.split(" ");

	            if (appointmentData.length == 3) {
	            	long studentID = Long.parseLong(appointmentData[0]);
	                int dayIndex = Integer.parseInt(appointmentData[1]);
	                int hourIndex = Integer.parseInt(appointmentData[2]);

	                if (dayIndex > 0 && dayIndex < 7 && hourIndex > 0 && hourIndex < 9) {
	                    appointmentCounter[dayIndex][hourIndex]++;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }}

	public static boolean addNewAppointment(Student stuObj, int[] indexOfAppointment) {
		
	    if (appointmentCounter[indexOfAppointment[0]][indexOfAppointment[1]] < MAXAPPOINTMENTPERHOUR) {
	        //appointmentCounter[indexOfAppointment[0]][indexOfAppointment[1]]++;
	        stuObj.setAppointment(indexOfAppointment);
	        
	        try {
	            FileWriter writer = new FileWriter("txtfiles/Appointment.txt", true);
	            writer.write(stuObj.getTcNo()+" "+indexOfAppointment[0] + " " + indexOfAppointment[1] + "\n");
	            writer.close();
	            
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	
	public static String displayAppointment(int[] indexOfAppointment) {
		
		return "Your appointment day is " + daysIndextoName[indexOfAppointment[0]] + 
				"\nYour appointment hour is " + hoursIndextoName[indexOfAppointment[1]];
	}
	
	public static void readFromAppointment() throws FileNotFoundException {
		File appointmentStudent = new File("txtfiles/Appointment.txt");
		if (!appointmentStudent.exists()) {
			System.out.println("ERROR: File does not exists!");
			System.exit(0);
		}
		else {
			Scanner input = new Scanner(appointmentStudent);
			int[] indexesOfAppointments = new int[2];
			while (input.hasNext()) {
				String tc= input.next();
				indexesOfAppointments[0] = input.nextInt();
				indexesOfAppointments[1] = input.nextInt();
				User stu = UserSys.searchUserByTcNo(tc);
				boolean isAdded;
				if(stu != null) {
					if(indexesOfAppointments != null) {
						((Student)(stu)).setAppointment(indexesOfAppointments);
					}
						
					
				}
			}
			input.close();
		}
		
		
	}
	
	public static void writeIntoAppointment() throws IOException {
		FileWriter outputAppointment = new FileWriter("txtfiles/Appointment.txt", false);
		ArrayList<User> userList = UserSys.getUserList();
		String addLine;
		for(int i = 0;i<userList.size();i++) {
			if(userList.get(i) instanceof Student) {
				String tc = userList.get(i).getTcNo();
				int index1 =  ((Student)(userList).get(i)).getAppointment()[0], 
						index2=  ((Student)(userList).get(i)).getAppointment()[1];
				addLine = tc+ " "+index1+" "+index2+"\n";
				
					outputAppointment.write(addLine);
				
			}
			
			
		}
		outputAppointment.close();
	}
	
}
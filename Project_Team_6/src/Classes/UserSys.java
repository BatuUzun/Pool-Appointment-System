package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

import java.util.ArrayList;


public class UserSys {
	
	private static ArrayList<User> userList=new ArrayList(); 
	private static ArrayList<User> pendingList=new ArrayList();
	
	public static ArrayList<User> getUserList() {
		return userList;
	}
	
	public static User searchPendingByTcNo(String tcNo) {
		for(int i = 0;i<pendingList.size();i++) {
			if(pendingList.get(i).findUser(tcNo))
				return pendingList.get(i);
		}
		
		return null;
	}
	
	public static String[] getPendingStaffNamesAndSurnames() {
		ArrayList<String> tc = new ArrayList<>();
		tc.add("Choose");
		for(int i = 0;i<pendingList.size();i++) {
			if(pendingList.get(i) instanceof Staff) {
				tc.add(pendingList.get(i).getName()+" "+pendingList.get(i).getSurname()+" "+pendingList.get(i).getTcNo());
			}
		}
		
		
		return tc.toArray(new String[0]);
		
	}
	
	public static String[] getStaffNamesAndSurnames() {
		
		
		ArrayList<String> tc = new ArrayList<>();
		tc.add("Choose");
		for(int i = 0;i<userList.size();i++) {
			if(userList.get(i) instanceof Staff) {
				tc.add(userList.get(i).getName()+" "+userList.get(i).getSurname()+" "+userList.get(i).getTcNo());
			}
		}
		
		
		return tc.toArray(new String[0]);
	}
	
	public static void readFromRequest() throws FileNotFoundException {
		File fileRequest = new File("txtfiles/request.txt");
		if (!fileRequest.exists()) {
			System.out.println("ERROR: File does not exists!");
			System.exit(0);
		}
		else {
			pendingList = new ArrayList();
			Scanner input = new Scanner(fileRequest);
			while (input.hasNext()) {
				String type=input.next();
				String name =input.next();
				if(name.contains(",")) {
					String[] divideName = name.split("\\,");
					name = "";
					for(int i = 0;i<divideName.length;i++) {
						name += divideName[i]+" ";
					}
					name = name.substring(0, name.length()-1);
				}
				String Surname = input.next();
				String tc= input.next();
				String bloodType= input.next();
				String gender= input.next();
				String id= input.next();
				String workedDays= input.next();
				String[] days = workedDays.split("\\,");
				String telNo= input.next();
				String address= input.next();
				String email= input.next();
				if(type.equalsIgnoreCase("s")) {
					User staff=new Servant(name,Surname,tc,bloodType,gender,id,days);
					staff.setUserContactInformation(telNo,address,email);
					pendingList.add(staff);
				}
				else if(type.equalsIgnoreCase("l")) {
					User staff=new Lifeguard(name,Surname,tc,bloodType,gender,id,days);
					staff.setUserContactInformation(telNo,address,email);
					pendingList.add(staff);
				}
				else;
			}
			input.close();
		}
		
	}
	public static void readFromFile() throws FileNotFoundException {
		File fileStudent = new File("txtfiles/Student.txt");
		if (!fileStudent.exists()) {
			System.out.println("ERROR: File does not exists!");
			System.exit(0);
		}
		else {
			userList = new ArrayList();
			Scanner input = new Scanner(fileStudent);
			while (input.hasNext()) {
				String name =input.next();
				if(name.contains(",")) {
					String[] divideName = name.split("\\,");
					name = "";
					for(int i = 0;i<divideName.length;i++) {
						name += divideName[i]+" ";
					}
					name = name.substring(0, name.length()-1);
				}
				String Surname = input.next();
				String tc= input.next();
				String bloodType= input.next();
				String gender= input.next();
				String id= input.next();
				String telNo= input.next();
				String address= input.next();
				String email= input.next();
				User student=new Student(name,Surname,tc,bloodType,gender,id);
				student.setUserContactInformation(telNo,address,email);
				int[] app = new int[2];
				app[0] = input.nextInt();
				app[1] = input.nextInt();
				((Student)(student)).setAppointment(app);
				userList.add(student);
			}
			input.close();
		}
		
		File fileStaff = new File("txtfiles/Staff.txt");
		if (!fileStaff.exists()) {
			System.out.println("ERROR: File does not exists!");
			System.exit(0);
		}
		else {
			Scanner input = new Scanner(fileStaff);
			while (input.hasNext()) {
				String type=input.next();
				String name =input.next();
				if(name.contains(",")) {
					String[] divideName = name.split("\\,");
					name = "";
					for(int i = 0;i<divideName.length;i++) {
						name += divideName[i]+" ";
					}
					name = name.substring(0, name.length()-1);
				}
				String Surname = input.next();
				String tc= input.next();
				String bloodType= input.next();
				String gender= input.next();
				String id= input.next();
				String workedDays= input.next();
				String[] days = workedDays.split("\\,",7);
				String telNo= input.next();
				String address= input.next();
				String email= input.next();
				if(type.equalsIgnoreCase("s")) {
					User staff=new Servant(name,Surname,tc,bloodType,gender,id,days);
					staff.setUserContactInformation(telNo,address,email);
					userList.add(staff);
				}
				else if(type.equalsIgnoreCase("l")) {
					User staff=new Lifeguard(name,Surname,tc,bloodType,gender,id,days);
					staff.setUserContactInformation(telNo,address,email);
					userList.add(staff);
				}
				else;
			}
			input.close();
		}
		
		File fileGeneralManager = new File("txtfiles/GeneralManager.txt");
		if (!fileGeneralManager.exists()) {
			System.out.println("ERROR: File does not exists!");
			System.exit(0);
		}
		else {
			Scanner input = new Scanner(fileGeneralManager);
			while (input.hasNext()) {
				String name =input.next();
				if(name.contains(",")) {
					String[] divideName = name.split("\\,");
					name = "";
					for(int i = 0;i<divideName.length;i++) {
						name += divideName[i]+" ";
					}
					name = name.substring(0, name.length()-1);
				}
				String Surname = input.next();
				String tc= input.next();
				String bloodType= input.next();
				String gender= input.next();
				String telNo= input.next();
				String address= input.next();
				String email= input.next();
				User GeneralManager1=new GeneralManager(name,Surname,tc,bloodType,gender);
				GeneralManager1.setUserContactInformation(telNo, address, email);
				userList.add(GeneralManager1);
			}
			input.close();
		}
	}
	public static void writeIntoRequest() throws IOException {
		FileWriter outputRequest = new FileWriter("txtfiles/request.txt", false);
		String addLine;
		for(int i = 0;i<pendingList.size();i++) {
			if(pendingList.get(i) instanceof Lifeguard) {
				addLine = "l"+" "+ pendingList.get(i).getName()+" " +
						pendingList.get(i).getSurname()+" "+ pendingList.get(i).getTcNo()+" "+ 
						pendingList.get(i).getBloodType()+" "+ 
						pendingList.get(i).getGender()+" "+((Lifeguard)(pendingList).get(i)).getCertificationNumber()+" "+ 
						String.join(",", ((Staff)(pendingList.get(i))).getWorkingDays().toArray(new String[0]))+" "+ pendingList.get(i).getUserContactInformation().getTelNo()+" "+ 
						pendingList.get(i).getUserContactInformation().getAddress()+" "+
						pendingList.get(i).getUserContactInformation().getEmail()+"\n";
				
			}
			else {
				addLine = "s"+" "+ pendingList.get(i).getName()+" " +
						pendingList.get(i).getSurname()+" "+ pendingList.get(i).getTcNo()+" "+ 
						pendingList.get(i).getBloodType()+" "+ 
						pendingList.get(i).getGender()+" "+((Servant)(pendingList).get(i)).getSgkNo()+" "+ 
						String.join(",", ((Staff)(pendingList.get(i))).getWorkingDays().toArray(new String[0]))+" "+ pendingList.get(i).getUserContactInformation().getTelNo()+" "+ 
						pendingList.get(i).getUserContactInformation().getAddress()+" "+
						pendingList.get(i).getUserContactInformation().getEmail()+"\n";
				
				
			}
			outputRequest.write(addLine);
			
			
		}
		outputRequest.close();
		
		/*
		
		
				
				*/
		/*
		String addLine;
		addLine = "l"+" "+ nameTextField.getText()+" " +
				surnameTextField.getText()+" "+ tcTextField.getText()+" "+ 
				bloodTypeComboBox.getSelectedItem().toString()+" "+ 
				genderComboBox.getSelectedItem().toString()+" "+speTextField.getText()+" "+ 
				String.join(",", days)+" "+ tellNoTextField.getText()+" "+ 
				addressTextField.getText()+" "+
				emailTextField.getText(); */
		
		
	}
	public static void writeIntoFile() throws IOException {
		FileWriter outputStudent = new FileWriter("txtfiles/Student.txt", false);
		FileWriter outputStaff = new FileWriter("txtfiles/Staff.txt",false);
		FileWriter outputGeneralManager = new FileWriter("txtfiles/GeneralManager.txt",false);
		String addLineForStudent;
		String addLineForStaff;
		String addLineForGeneralManager;
		String newName;
		int k = 0;
		for(int i =0;i<userList.size();i++) {
			newName = userList.get(i).getName();
			if(userList.get(i).getName().contains(" ")) {
				newName = userList.get(i).getName().replaceAll(" ", ",");
				
			}
			
			if(userList.get(i) instanceof Student) {
				//Murat Salman 56482345621 ARh+ Male 22003488 05483214568 Ankara/Etimesgut murat@ug.bilkent.edu.tr
				
				addLineForStudent = newName+" "+userList.get(i).getSurname()+" "+
						userList.get(i).getTcNo()+" "+userList.get(i).getBloodType()+" "+
						userList.get(i).getGender()+" "+((Student)(userList.get(i))).getStudentId()+" "+
						userList.get(i).getUserContactInformation().getTelNo()+" "+
						userList.get(i).getUserContactInformation().getAddress()+" "+
						userList.get(i).getUserContactInformation().getEmail()+
						" "+((Student)(userList.get(i))).getAppointment()[0]
								+" "+((Student)(userList.get(i))).getAppointment()[1]+"\n";
				
				outputStudent.write(addLineForStudent);
			}
			//s Hasan Ayrik 76321852031 BRh- Male 123 Sunday,Monday,Tuesday,Wednesday 05345210213 Ankara/Cankaya hasan@gmail.com
			else if(userList.get(i) instanceof Servant) {
				addLineForStaff = "s "+newName+" "+userList.get(i).getSurname()+" "+
						userList.get(i).getTcNo()+" "+userList.get(i).getBloodType()+" "+
						userList.get(i).getGender()+ " "+((Servant)(userList.get(i))).getSgkNo()+" ";
				
				for( k = 0;k<(((Staff)(userList.get(i))).getWorkingDays()).size();k++) {
					addLineForStaff += (((Staff)(userList.get(i))).getWorkingDays()).get(k);
				if(k + 1!=(((Staff)(userList.get(i))).getWorkingDays()).size()) {
					addLineForStaff+=",";
				}
				
			}
				addLineForStaff +=" "+userList.get(i).getUserContactInformation().getTelNo()+" "+
						userList.get(i).getUserContactInformation().getAddress()+" "+
						userList.get(i).getUserContactInformation().getEmail()+"\n";
				outputStaff.write(addLineForStaff);
			}
			//l Hatice Yilmaz 62345780123 0Rh- Female 333 Wednesday,Thursday,Friday,Saturday 05064758621 Ankara/Kecioren hatice@gmail.com
			else if(userList.get(i) instanceof Lifeguard) {
				addLineForStaff = "l "+newName+" "+userList.get(i).getSurname()+" "+
						userList.get(i).getTcNo()+" "+userList.get(i).getBloodType()+" "+
						userList.get(i).getGender()+" "+((Lifeguard)(userList.get(i))).getCertificationNumber()+" ";
				
				for( k = 0;k<(((Staff)(userList.get(i))).getWorkingDays()).size();k++) {
					addLineForStaff += (((Staff)(userList.get(i))).getWorkingDays()).get(k);
				if(k + 1!=(((Staff)(userList.get(i))).getWorkingDays()).size()) {
					addLineForStaff+=",";
				}
				
			}
				addLineForStaff +=" "+userList.get(i).getUserContactInformation().getTelNo()+" "+
						userList.get(i).getUserContactInformation().getAddress()+" "+
						userList.get(i).getUserContactInformation().getEmail()+"\n";
				outputStaff.write(addLineForStaff);
				
			}
			//Burak Mutlu 15975364210 ARh+ Male 05324568712 Ankara/Cankaya burak@gmail.com
			else {
				addLineForGeneralManager = newName+" "+userList.get(i).getSurname()+" "+
						userList.get(i).getTcNo()+" "+userList.get(i).getBloodType()+" "+
						userList.get(i).getGender()+" "+
						userList.get(i).getUserContactInformation().getTelNo()+" "+
						userList.get(i).getUserContactInformation().getAddress()+" "+
						userList.get(i).getUserContactInformation().getEmail()+"\n";
				
				outputGeneralManager.write(addLineForGeneralManager);
				
			}
			
			
		}
		outputGeneralManager.close();
		outputStaff.close();
		outputStudent.close();
		
	}
	
	
	/*
	User staff=new Servant(name,Surname,tc,bloodType,gender,id,days); ok
	staff.setUserContactInformation(telNo,address,email); ok
	
	User Student=new Student(name,Surname,tc,bloodType,gender,id); ok
	Student.setUserContactInformation(telNo,address,email); ok
	
	User GeneralManager1=new GeneralManager(name,Surname,tc,bloodType,gender);
	GeneralManager1.setUserContactInformation(telNo, address, email);
	
	User staff=new Lifeguard(name,Surname,tc,bloodType,gender,id,days);
	staff.setUserContactInformation(telNo,address,email);
	*/
	
	
	public static boolean addPendingUser(String type, String name, String surname,
			 String tcNo,String bloodType,String gender, String id, String telNo, String address,
			 String email, String[] days) {
		boolean isAdded = false;
		if(type.equalsIgnoreCase("servant")) {
			User staff=new Servant(name,surname,tcNo,bloodType,gender,id,days);
			staff.setUserContactInformation(telNo,address,email);
			pendingList.add(staff);
			isAdded = true;
		}
	 
		else if(type.equalsIgnoreCase("lifeguard")) {
			User staff=new Lifeguard(name,surname,tcNo,bloodType,gender,id,days);
			staff.setUserContactInformation(telNo,address,email);
			pendingList.add(staff);
			isAdded = true;
		}
		return isAdded;
	}
	
	public static boolean addNewUserIntoAl(String type, String name, String surname,
			 String tcNo,String bloodType,String gender, String id, String telNo, String address,
			 String email, String[] days){
		boolean isAdded = false;
		if(type.equalsIgnoreCase("student")) {
			User student=new Student(name,surname,tcNo,bloodType,gender,id);
			student.setUserContactInformation(telNo,address,email);
			userList.add(student);
			isAdded = true;
		}
		
		else if(type.equalsIgnoreCase("servant")) {
			User staff=new Servant(name,surname,tcNo,bloodType,gender,id,days);
			staff.setUserContactInformation(telNo,address,email);
			userList.add(staff);
			isAdded = true;
		}
	 
		else if(type.equalsIgnoreCase("lifeguard")) {
			User staff=new Lifeguard(name,surname,tcNo,bloodType,gender,id,days);
			staff.setUserContactInformation(telNo,address,email);
			userList.add(staff);
			isAdded = true;
		}
		
		else {
			User generalManager1=new GeneralManager(name,surname,tcNo,bloodType,gender);
			generalManager1.setUserContactInformation(telNo, address, email);
			userList.add(generalManager1);
			isAdded = true;
		}
	 
	 
		
		return isAdded;
	}
	
	
	public static void displayUserList() {
		for(User a: userList ) {
			System.out.println(a.toString());
		}
	}
	
	public static User searchUserByTcNo(String tcNo) {
		for(int i = 0;i<userList.size();i++) {
			if(userList.get(i).findUser(tcNo))
				return userList.get(i);
		}
		
		return null;
	}
	//
	public static User deletePendingUser(String tcNo) throws IOException {
		User deletedUser;
		for(int i = 0;i<pendingList.size();i++) {
			if(pendingList.get(i).findUser(tcNo)) {
				deletedUser = pendingList.get(i);
				pendingList.remove(i);
				
				return deletedUser;
			}
				
		}
		
		return null;
	}
	//
	public static User deleteUser(String tcNo) throws IOException {
		User deletedUser;
		for(int i = 0;i<userList.size();i++) {
			if(userList.get(i).findUser(tcNo)) {
				deletedUser = userList.get(i);
				userList.remove(i);
				writeIntoFile();
				return deletedUser;
			}
				
		}
		
		return null;
	}
	
	public static void calculateStaffSalary() {
		for(int i = 0;i<userList.size();i++) {
			 if(userList.get(i) instanceof Staff) {
				((Staff) userList.get(i)).setSalary(((Staff) userList.get(i)).calculateSalary());
			 }
		}		
	}
	
	
	
	
	
	
}
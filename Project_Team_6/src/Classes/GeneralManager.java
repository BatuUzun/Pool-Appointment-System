package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralManager extends User implements LoginType{
	private static int managerNo = 1;
	private int managerId;

	public GeneralManager(String name,String surname,String tcNo,String bloodType,String gender) {
		super(name,surname,tcNo,bloodType,gender);
		managerId = managerNo++;
	}
	
	@Override
	public String userLoginType() {
		return "You logged in as a general manager";
	}
	
	public int getManagerId() {
		return this.managerId;
	}
	
	@Override
	public String toString() {
		String output= "General Manager";
		output+=super.toString();
		return output += "\nManagerId= "+managerId;
	}
	
	
}
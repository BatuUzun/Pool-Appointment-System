package Classes;

import java.util.ArrayList;

public class Servant extends Staff implements LoginType{
	private String sgkNo;
	private final double BASEPRICE = 2000;
	
	public Servant(String name,String surname,String tcNo,String bloodType,String gender,String sgkNo,String[] s) {
		super(name,surname,tcNo,bloodType,gender,s);
		this.sgkNo = sgkNo;
	}
	@Override
	public String userLoginType() {
		return "You logged in as a servant";
	}
	public String getSgkNo() {
		return sgkNo;
	}
	
	public double calculateSalary() {
		double salary = 0;
		ArrayList<String> alCalc = getWorkingDays();
		salary = BASEPRICE+ alCalc.size()*BASEPRICE;
		return salary;
	}
	
	public String toString() {
		String output = "\nServant"+super.toString();
		output += "\nSGK No= "+sgkNo+"\n";
		return output;
	}
}
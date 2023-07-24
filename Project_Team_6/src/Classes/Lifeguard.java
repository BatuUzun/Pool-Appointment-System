package Classes;

import java.util.ArrayList;

public class Lifeguard extends Staff implements LoginType{
	private String certificationNumber;
	private final double BASEPRICE = 3000;
	
	
	public Lifeguard(String name,String surname,String tcNo,String bloodType,String gender,String certificationNumber,String[] s) {
		super(name,surname,tcNo,bloodType,gender,s);
		this.certificationNumber = certificationNumber;
	}
	
	@Override
	public String userLoginType() {
		return "You logged in as a lifeguard";
	}
	
	public String getCertificationNumber() {
		return certificationNumber;
	}
	
	@Override
	public double calculateSalary(){
		double salary = 0;
		ArrayList<String> alCalc = getWorkingDays();
		salary = BASEPRICE+ alCalc.size()*BASEPRICE;
		return salary;
	}
	
	
	
	@Override
	public String toString() {
		String output = "\n\nLifeguard"+super.toString();
		output += "Certification Number= "+certificationNumber;
		return output;
	}
}
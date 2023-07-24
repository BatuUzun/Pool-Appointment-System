package Classes;

import java.util.ArrayList;

public abstract class Staff extends User {
	protected static int staffNo = 99;
	protected int staffId;
	protected ArrayList<String> workingDays = new ArrayList();
	protected double salary;

	public Staff() {
		
		
	}

	public Staff(String name,String surname,String tcNo,String bloodType,String gender,String[] b) {
		
		super(name,surname,tcNo,bloodType,gender);
		staffNo++;
		staffId = staffNo;
		for (String day : b) {
			addWorkingDay(day);
		}
	}
	public void setWorkingDays(ArrayList<String> a) {
		workingDays = a;
	}
	public void addWorkingDay(String day) {
		boolean add = true;
		for (int i = 0; i < workingDays.size(); i++) {
			if (workingDays.get(i).equalsIgnoreCase(day)) {
				add = false;
			}

		}
		if (add) {
			workingDays.add(day);
		}
	}
	public int getStaffId() {
		return staffId;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void removeWorkingDay(String day) {
		for (int i = 0; i < workingDays.size(); i++) {
			if (workingDays.get(i).equalsIgnoreCase(day)) {
				workingDays.remove(i);
			}

		}
	}
	
	public ArrayList<String> getWorkingDays(){
		return workingDays;
	}
	
	public abstract double calculateSalary();
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		String output = super.toString();
		output += "\nStaff id= "+staffId
				+"\nSalary= "+salary+"\nWorking days= ";
		for(int i = 0; i<workingDays.size(); i++) {
			output+=workingDays.get(i)+" ";
		}
		return output;
	}
}
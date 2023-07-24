package Classes;

public class Student extends User implements LoginType{
	private String studentId;
	private int[] appointment = new int[2];
	
	Student(String name,String surname,String tcNo,String bloodType,String gender,String studentId){
		super(name, surname, tcNo, bloodType, gender);		
		setStudentId(studentId);
	}

	public String getStudentId() {
		return studentId;
	}
	
	@Override
	public String userLoginType() {
		return "You logged in as a student";
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int[] getAppointment() {
		
		return appointment;
	}

	public void setAppointment(int[] appointment) {
		
		
		this.appointment[0] = appointment[0];
		this.appointment[1] = appointment[1];
	}

	@Override
	public String toString() {
		String output = super.toString();
		String app ="";
		
		if(appointment[0] !=0 && appointment[1]!=0) {
			
			 app = AppointmentSys.displayAppointment(this.appointment);
		}
			
		else
			app = "No appointment";
		return output += "\nStudent id= "+studentId+"\nStudent appointment:\n"+app;
	}


	

	
	
	
}

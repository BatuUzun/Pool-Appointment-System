package Classes;

public class User {
	protected String name;
	protected String surname;
	protected String tcNo;
	protected String bloodType;
	protected String gender;
	protected UserContact UserContactInformation=new UserContact();
	
	User(){
		
		
	}
	
	User(String name,String surname,String tcNo){
		this.name=name;
		this.surname=surname;
		this.tcNo=tcNo;
		
	}
	
	User(String name,String surname,String tcNo,String bloodType,String gender){

		this.name=name;
		this.surname=surname;
		this.tcNo=tcNo;
		this.bloodType=bloodType;
		this.gender=gender;
		
		
		
	}

	public String getName() {
		return name;
	}

	public boolean findUser(String tcNo) {
		if(tcNo.equalsIgnoreCase(this.tcNo))
			return true;
		return false;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTcNo() {
		return tcNo;
	}

	
	public String toString() {
		return "\nName=" + name + "\nSurname=" + surname + "\nTcNo=" + tcNo + "\nBloodType=" + bloodType
				+ "\nGender=" + gender+ "\n"+UserContactInformation.toString();
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserContact getUserContactInformation() {
		return UserContactInformation;
	}

	public void setUserContactInformation(String telNo, String address, String email) {
		UserContactInformation.setAddress(address);
		UserContactInformation.setEmail(email);
		UserContactInformation.setTelNo(telNo);
	}
	
	
}

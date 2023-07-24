package Classes;

public class UserContact {
	private String telNo;
	private String address;
	private String email;
	
	public UserContact(){
		
		
	}
	
	public UserContact(String telNo, String address, String email){
		this.telNo=telNo;
		this.address=address;
		this.email=email;
	}
	
	
	public String getTelNo() {
		return telNo;
	}
	
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserContact \nTelNo=" + telNo + " \nAddress=" + address + "\nEmail=" + email + "";
	}
	
	
}

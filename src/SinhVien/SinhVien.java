package SinhVien;

public class SinhVien {
	private int ID;
	private String fullName, gender, email, phoneNumber;
	private int age;
	public SinhVien() {
		
	}
	public SinhVien(int iD, String fullName, String gender, String email, String phoneNumber, int age) {
		ID = iD;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	public SinhVien(String fullName, String gender, String email, String phoneNumber, int age) {
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

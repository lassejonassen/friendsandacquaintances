package logic;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private ArrayList<String> interests = new ArrayList<String>();

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void putInterest(String interest) {
		interests.add(interest);
	}
	
	public void putInterest(ArrayList<String> interestList) {
		interests.addAll(interestList);
	}
	
	public void delInterest(String interest) {
		interests.remove(interest);
	}
	
	public ArrayList<String> getInterests() {
		return interests;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile
				+ ", interests=" + interests + "]";
	}
	
	public String toStringInterests() {
		return ""+ interests +"";
	}
}

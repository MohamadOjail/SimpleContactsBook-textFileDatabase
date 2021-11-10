package ojail.mohamad.contactbook.model;

import java.time.LocalDate;

public class PersonModel {
	
	public PersonModel(int iD, String firstName, String lastName, String telNumber, LocalDate birthDate) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		TelNumber = telNumber;
		BirthDate = birthDate;
	}
	
	private int ID;
	private String FirstName;
	private String LastName;
	private String TelNumber;
	private LocalDate BirthDate;
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getTelNumber() {
		return TelNumber;
	}
	public void setTelNumber(String telNumber) {
		TelNumber = telNumber;
	}
	
	public LocalDate getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}
	
	public int getID() {
		return ID;
	}
	
	
}

package ojail.mohamad.contactbook.model;

import java.time.LocalDate;

public class PersonModel {

	public PersonModel(int id, String firstName, String lastName, String telNumber, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
		this.birthDate = birthDate;
	}

	private int id;
	private String firstName;
	private String lastName;
	private String telNumber;
	private LocalDate birthDate;

	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelNumber() {
		return this.telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getID() {
		return this.id;
	}

	public String getPersonData() {
		return id + "|" + firstName + ";" + lastName + ":" + birthDate + "." + telNumber;
	}
}









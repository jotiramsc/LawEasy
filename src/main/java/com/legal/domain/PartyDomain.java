package com.legal.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.legal.Utility;

@Entity(name = "party")
public class PartyDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column
	String type;

	@Column
	String firstName;

	@Column
	String middleName;

	@Column
	String lastName;

	@Column
	int age;

	@Column
	String occupation;

	@Column
	LocalDate dob;

	@Column
	String emailId;

	@Column
	long contactNo;

	@Column
	String gender;

	@ManyToMany(mappedBy = "parties")
	Set<MatterDomain> matters = new HashSet<>();

	public PartyDomain() {
		super();	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matters == null) ? 0 : matters.hashCode());
		result = prime * result + age;
		result = prime * result + (int) (contactNo ^ (contactNo >>> 32));
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartyDomain other = (PartyDomain) obj;
		return ( Utility.equals(matters, other.matters)
				&& Utility.equals(age, other.age)
				&& Utility.equals(contactNo, other.contactNo)
				&& Utility.equals(dob, other.dob)
				&& Utility.equals(emailId, other.emailId)
				&& Utility.equals(firstName, other.firstName)
				&& Utility.equals(gender, other.gender)
				&& Utility.equals(id, other.id)
				&& Utility.equals(lastName, other.lastName)
				&& Utility.equals(middleName, other.middleName)
				&& Utility.equals(occupation, other.occupation)
				&& Utility.equals(type, other.type));
	}

	@Override
	public String toString() {
		return "PartyDomain [id=" + id + ", type=" + type + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", age=" + age + ", occupation=" + occupation + ", dob=" + dob
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", gender=" + gender + ", Cases=" + matters
				+ "]";
	}
	
	public static void main(String[] args) {
		PartyDomain d1=new PartyDomain();
		PartyDomain d2=new PartyDomain();
		d1.setAge(10);
		System.out.println(d1.equals(d2));
	}

}

package com.legal.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder.Case;

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
		// TODO Auto-generated constructor stub
	}

	public PartyDomain(int id, String type, String firstName, String middleName, String lastName, int age,
			String occupation, LocalDate dob, String emailId, long contactNo, String gender, Set<MatterDomain> cases) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.occupation = occupation;
		this.dob = dob;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.gender = gender;
		matters = cases;
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
		if (matters == null) {
			if (other.matters != null)
				return false;
		} else if (!matters.equals(other.matters))
			return false;
		if (age != other.age)
			return false;
		if (contactNo != other.contactNo)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartyDomain [id=" + id + ", type=" + type + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", age=" + age + ", occupation=" + occupation + ", dob=" + dob
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", gender=" + gender + ", Cases=" + matters + "]";
	}

}
package com.legal.domain;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "matter")
public class MatterDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(length = 50)
	String subject;

	@Column
	LocalDate incDate;

	@Column
	LocalDate listingdate;

	@Column
	Timestamp createdDate;

	@Column
	Timestamp modifiedDate;

	@Column
	int type;

	@Column
	String status;

	@Column
	Integer firNo;

	@Column
	String summary;

	@Column
	String juridiction;

	@Column
	String charges;

	@Column
	Integer createdBy;

	@Column
	Integer modifiedBy;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matter_parties", joinColumns = @JoinColumn(name = "matter_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "party_id", referencedColumnName = "id"))
	Set<PartyDomain> parties = new HashSet<>();

	public MatterDomain() {
		super();

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}

	public LocalDate getIncDate() {
		return incDate;
	}

	public void setIncDate(LocalDate incDate) {
		this.incDate = incDate;
	}

	public LocalDate getListingdate() {
		return listingdate;
	}

	public void setListingdate(LocalDate listingdate) {
		this.listingdate = listingdate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int gettype() {
		return type;
	}

	public void settype(int type) {
		this.type = type;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public Integer getFirNo() {
		return firNo;
	}

	public void setFirNo(Integer firNo) {
		this.firNo = firNo;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getJuridiction() {
		return juridiction;
	}

	public void setJuridiction(String juridiction) {
		this.juridiction = juridiction;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Set<PartyDomain> getParties() {
		return parties;
	}

	public void setParties(Set<PartyDomain> parties) {
		this.parties = parties;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + type;
		result = prime * result + ((charges == null) ? 0 : charges.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((firNo == null) ? 0 : firNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incDate == null) ? 0 : incDate.hashCode());
		result = prime * result + ((juridiction == null) ? 0 : juridiction.hashCode());
		result = prime * result + ((listingdate == null) ? 0 : listingdate.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		MatterDomain other = (MatterDomain) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
					return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
					return false;
		if (type != other.type)
			return false;
		if (charges == null) {
			if (other.charges != null)
				return false;
		} else if (!charges.equals(other.charges))
					return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
					return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
					return false;
		if (firNo == null) {
			if (other.firNo != null)
				return false;
		} else if (!firNo.equals(other.firNo))
					return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
					return false;
		if (incDate == null) {
			if (other.incDate != null)
				return false;
		} else if (!incDate.equals(other.incDate))
					return false;
		if (juridiction == null) {
			if (other.juridiction != null)
				return false;
		} else if (!juridiction.equals(other.juridiction))
					return false;
		else if (listingdate == null) {
			if (other.listingdate != null)
				return false;
		} else if (!listingdate.equals(other.listingdate))
					return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
					return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
					return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
					return false;
		return true;
	}

	@Override
	public String toString() {
		return "MatterDomain [id=" + id + ", subject=" + subject + ", incDate=" + incDate + ", listingdate="
				+ listingdate + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", type=" + type
				+ ", status=" + status + ", firNo=" + firNo + ", summary=" + summary + ", juridiction=" + juridiction
				+ ", charges=" + charges + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", parties="
				+ parties + "]";
	}

}

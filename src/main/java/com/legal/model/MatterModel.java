package com.legal.model;

import java.util.ArrayList;
import java.util.List;

public class MatterModel {

	int id;

	String subject;

	String incDate;

	String listingdate;

	String createdDate;

	String modifiedDate;

	int type;

	String status;

	int firNo;

	String summary;

	String juridiction;

	String charges;

	int createdBy;

	int modifiedBy;

	List<PartyModel> parties = new ArrayList<>();

	List<TimeLineModel> timeLines = new ArrayList<>();

	public MatterModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIncDate() {
		return incDate;
	}

	public void setIncDate(String incDate) {
		this.incDate = incDate;
	}

	public String getListingdate() {
		return listingdate;
	}

	public void setListingdate(String listingdate) {
		this.listingdate = listingdate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFirNo() {
		return firNo;
	}

	public void setFirNo(int firNo) {
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<PartyModel> getParties() {
		return parties;
	}

	public void setParties(List<PartyModel> parties) {
		this.parties = parties;
	}

	public List<TimeLineModel> getTimeLines() {
		return timeLines;
	}

	public void setTimeLines(List<TimeLineModel> timeLines) {
		this.timeLines = timeLines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charges == null) ? 0 : charges.hashCode());
		result = prime * result + createdBy;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + firNo;
		result = prime * result + id;
		result = prime * result + ((incDate == null) ? 0 : incDate.hashCode());
		result = prime * result + ((juridiction == null) ? 0 : juridiction.hashCode());
		result = prime * result + ((listingdate == null) ? 0 : listingdate.hashCode());
		result = prime * result + modifiedBy;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((parties == null) ? 0 : parties.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((timeLines == null) ? 0 : timeLines.hashCode());
		result = prime * result + type;
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
		MatterModel other = (MatterModel) obj;
		if (charges == null) {
			if (other.charges != null)
				return false;
		} else if (!charges.equals(other.charges))
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (firNo != other.firNo)
			return false;
		if (id != other.id)
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
		if (listingdate == null) {
			if (other.listingdate != null)
				return false;
		} else if (!listingdate.equals(other.listingdate))
			return false;
		if (modifiedBy != other.modifiedBy)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (parties == null) {
			if (other.parties != null)
				return false;
		} else if (!parties.equals(other.parties))
			return false;
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
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timeLines == null) {
			if (other.timeLines != null)
				return false;
		} else if (!timeLines.equals(other.timeLines))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MatterModel [id=" + id + ", subject=" + subject + ", incDate=" + incDate + ", listingdate="
				+ listingdate + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", type=" + type
				+ ", status=" + status + ", firNo=" + firNo + ", summary=" + summary + ", juridiction=" + juridiction
				+ ", charges=" + charges + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", parties="
				+ parties + ", timeLines=" + timeLines + "]";
	}

	
}

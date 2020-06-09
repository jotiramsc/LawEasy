package com.legal.model;

public class TimeLineModel {
    private String name;
    private String status;
    private String description;
    private String time;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		TimeLineModel other = (TimeLineModel) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
					return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
					return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
					return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
					return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeLineModel [name=" + name + ", status=" + status + ", description=" + description + ", time=" + time
				+ "]";
	}
	
    
    
    }
package com.app.crud.enitty;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="departmentid")
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private int departmentCode;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentID(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public int getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(departmentAddress, departmentCode, departmentId, departmentName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentAddress, other.departmentAddress) && departmentCode == other.departmentCode
				&& departmentId == other.departmentId && Objects.equals(departmentName, other.departmentName);
	}

}

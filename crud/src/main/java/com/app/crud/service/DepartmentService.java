package com.app.crud.service;

import java.util.List;
import java.util.Optional;

import com.app.crud.enitty.Department;

public interface DepartmentService {
	
	/**
	 * 
	 * @param department
	 * @return
	 * For Saving Data into Database
	 */
	Department saveDepartment(Department department); 
	
	/**
	 * 
	 * @return
	 * For Read all the Data from the database
	 */
	List<Department> getDepartment(); 
	
	/**
	 * 
	 * @param departmentId
	 * For deleting record by id
	 */
	void deleteDepartmentById(long departmentId); 
	
	/**
	 * 
	 * @param department
	 * @param departmentId
	 * @return
	 * Updating the Record by id
	 */
	
	Department updateDepartment(Department department,long departmentId); 
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 * Updating the Record by id
	 * Optional Used to deal with null pointer exception if no records are present with provided id null will be returned.
	 */
	Optional<Department> fetchById(long departmentId);  

}

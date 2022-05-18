package com.app.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.enitty.Department;
import com.app.crud.service.DepartmentService;
/**
 * 
 * @author Astegic
 *
 */
@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public ResponseEntity<Department> saveRecord(@RequestBody Department department)
	{
		return ResponseEntity.ok(departmentService.saveDepartment(department));
	}
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getDepartment()
	{
		return ResponseEntity.ok(departmentService.getDepartment());
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> fetchById(@PathVariable("id") long departmentId)
	{
		Optional<Department> department=departmentService.fetchById(departmentId);
		if(department.isPresent()) {
			return ResponseEntity.ok(department.get());
		}
	
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * 
	 * @param department
	 * @param departmentId
	 * @return 
	 * @RequestBody : By using @RequestBody annotation you will get your values mapped with the model you created in your system for handling any specific call. 
	 */
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateById(@RequestBody Department department,@PathVariable("id") long departmentId)
	{
		return ResponseEntity.ok(departmentService.updateDepartment(department, departmentId));
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") long departmentId )	
	{
		departmentService.deleteDepartmentById(departmentId);
		return ResponseEntity.ok("Deleted.");
	}

}

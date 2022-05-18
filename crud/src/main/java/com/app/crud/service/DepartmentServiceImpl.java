package com.app.crud.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.crud.Repository.DepartmentRepository;
import com.app.crud.enitty.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repo;
	
	@Transactional(readOnly = true)
	public List<Department> getDepartment()
	{
		return repo.findAll();
	}
	
	@Transactional(readOnly=false)
	public void deleteDepartmentById(long departmentId)
	{
		repo.deleteById(departmentId);
	}
	
	@Transactional(readOnly=false)
	public Department saveDepartment(Department department) {
		return repo.save(department);
	}
	
	@Transactional(readOnly=true)
	public Optional<Department> fetchById(long DepartmentId)
	{
		return repo.findById(DepartmentId);
	}

	@Transactional(readOnly=false)
	public Department updateDepartment(Department department,long departmentID)
	{
		Department depDB=repo.findById(departmentID).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
		{
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		
		return repo.save(depDB);
	}

}

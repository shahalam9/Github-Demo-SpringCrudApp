package com.app.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.crud.enitty.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}

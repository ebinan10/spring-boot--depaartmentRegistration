package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
  public Department saveDepartment(Department department);

  public Optional<Department> GetDepartment(Long id);

  public List<Department> fetchDepartmentList();

  public String DeleteDepartment(long id);

  public Department UpdateDepartment(long id, Department department);

  public Department GetDepartmentByName(String departmentName);
}

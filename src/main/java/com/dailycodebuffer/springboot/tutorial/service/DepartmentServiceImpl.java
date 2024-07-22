package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> GetDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public String DeleteDepartment(long id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }

    @Override
    public Department UpdateDepartment(long id, Department department) {
                Department departments = departmentRepository.findById(id).get();
                if(Objects.nonNull(department.getDepartmentName()) &&
                        !"".equalsIgnoreCase(department.getDepartmentName())) {
                    departments.setDepartmentName(department.getDepartmentName());
                }
                if(Objects.nonNull(department.getDepartmentAddress()) &&
                        !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                    departments.setDepartmentAddress(department.getDepartmentAddress());
                }
                if(Objects.nonNull(department.getDepartmentCode()) &&
                        !"".equalsIgnoreCase(department.getDepartmentCode())) {
                    departments.setDepartmentCode(department.getDepartmentCode());
                }
        return  departmentRepository.save(departments);
    }

    @Override
    public Department GetDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        return department;
    }
}
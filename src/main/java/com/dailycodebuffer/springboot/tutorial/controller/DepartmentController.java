package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
       return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> GetDepartment(@PathVariable("id") long id){
       return departmentService.GetDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public String DeleteDepartment(@PathVariable("id") long id){
        return departmentService.DeleteDepartment(id);
    }

    @PutMapping("/departments/{id}")
    public Department UpdateDepartment(@PathVariable("id") long id, @RequestBody Department department ){
        return departmentService.UpdateDepartment( id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department GetDepartmentByName(@PathVariable("name") String departmentName ){
        return departmentService.GetDepartmentByName(departmentName);
    }
}
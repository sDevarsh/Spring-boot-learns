package com.first.learnspring.controller;

import com.first.learnspring.entity.Department;
import com.first.learnspring.error.DepartmentNotFound;
import com.first.learnspring.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class DepartmentController {
    private Logger logger=Logger.getLogger(String.valueOf(DepartmentController.class));
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/insert")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        logger.info("Inside save Department");
//        DepartmentService departmentService=new DepartmentServiceImpl(); no need of this
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/fetchAll")
    public List<Department> fetchDepartment()
    {
        return departmentService.fetchDepartment();
    }
    @GetMapping("/fetchById/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartment(departmentId);
        return "Deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public Optional<Department> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) throws DepartmentNotFound {
        return departmentService.updateDepartment(departmentId, department);

    }
    @GetMapping("/fetchByName/{name}")
    public List<Department> fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}

package com.first.learnspring.service;

import com.first.learnspring.entity.Department;
import com.first.learnspring.error.DepartmentNotFound;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFound;

    void deleteDepartment(Long departmentId);

    Optional<Department> updateDepartment(Long departmentId, Department department) throws DepartmentNotFound;

    List<Department> fetchDepartmentByName(String departmentName);
}

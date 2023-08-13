package com.first.learnspring.service;

import com.first.learnspring.entity.Department;
import com.first.learnspring.error.DepartmentNotFound;
import com.first.learnspring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFound {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFound("Department not found");
        }
        else
        return Optional.of(department.get());

    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Optional<Department> updateDepartment(Long departmentId, Department department) throws DepartmentNotFound {
        Optional<Department> depDB0 = departmentRepository.findById(departmentId);

        Department depDB;
        if (!depDB0.isPresent()) {
            throw new DepartmentNotFound("Department not found");
        } else {
            depDB = depDB0.get();

            if (!"".equalsIgnoreCase(department.getDepartmentName()) && department.getDepartmentName() != null) {
                depDB.setDepartmentName(department.getDepartmentName());
            }
            if (!"".equalsIgnoreCase(department.getDepartmentAddress()) && department.getDepartmentAddress() != null) {
                depDB.setDepartmentAddress(department.getDepartmentAddress());
            }
            if (!"".equalsIgnoreCase(department.getDepartmentCode()) && department.getDepartmentCode() != null) {
                depDB.setDepartmentCode(department.getDepartmentCode());
            }
        }
        return Optional.of(departmentRepository.save(depDB));

    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}

package com.first.learnspring.entity;

import com.first.learnspring.controller.DepartmentController;
import com.first.learnspring.repository.DepartmentRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import java.util.logging.Logger;

@Entity
@Data
//@Getter no need if we use Data
//@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//how to generate primary key.so we define it auto in department id is primary key as @id is above it
    private Long departmentId;
    @NotBlank(message = "Enter Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}

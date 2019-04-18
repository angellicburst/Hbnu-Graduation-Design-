package com.hbnu.gradesign.dao;

import com.hbnu.gradesign.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    Department getDepartmentById(Integer id);

    List<Department> getDepartments();
}
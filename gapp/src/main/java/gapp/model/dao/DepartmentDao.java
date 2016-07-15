package gapp.model.dao;

import java.util.List;

import gapp.model.Department;

public interface DepartmentDao {

    Department getDepartment( Integer deptId );

    List<Department> getDepartments();
    
    Department addDepartment(Department department);
        
}

package gapp.model.dao;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.ProgramCount;

import java.util.List;

public interface ProgramDao {

    Program getProgram( Integer id );

    List<Program> getPrograms();

    List<Object[]> listOfPrgPerDept();
    
    List<Program> getProgByDeptId(Integer deptId);
    
    Program addProgram(Program program, Department deptId);
    
    void removeProgram(Program program);

}

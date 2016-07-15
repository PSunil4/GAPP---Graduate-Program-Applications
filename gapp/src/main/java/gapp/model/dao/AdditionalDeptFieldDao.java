package gapp.model.dao;

import gapp.model.AdditionalDepartmentFields;
import gapp.model.AdditionalDeptFieldValue;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.SystemUser;

import java.util.List;

public interface AdditionalDeptFieldDao {

    List<AdditionalDepartmentFields> additionalFieldsPerDept( Integer deptId );
    
    List<AdditionalDeptFieldValue> additionalDeptFieldValue(Integer applicationId);
    
    AdditionalDepartmentFields additionalFields(Integer additionalDeptFieldsId);
    
    AdditionalDepartmentFields addNewFields(AdditionalDepartmentFields fields, Department department, SystemUser userId);
    
    void removeAdditionalFields (AdditionalDepartmentFields additionalFields);
    
    AdditionalDeptFieldValue saveFieldValue(AdditionalDeptFieldValue additionalDeptFieldValue);
    

}

package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gapp.model.AdditionalDepartmentFields;
import gapp.model.AdditionalDeptFieldValue;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.SystemUser;
import gapp.model.dao.AdditionalDeptFieldDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdditionalDeptFieldDaoImpl implements AdditionalDeptFieldDao {

    @PersistenceContext
    private EntityManager entityManager;

    // List the additional fields needed by the department
    @Override
    public List<AdditionalDepartmentFields> additionalFieldsPerDept(
        Integer deptId )
    {
        return entityManager.createQuery(
            "from AdditionalDepartmentFields where department.departmentId = :deptId and isActive = true",
            AdditionalDepartmentFields.class )
            .setParameter( "deptId", deptId )
            .getResultList();
    }

    @Transactional
    @Override
    public AdditionalDepartmentFields addNewFields(
        AdditionalDepartmentFields fields, Department department, SystemUser userId )
    {
        fields.setSystemStaff( userId );
        fields.setDepartment( department );
        fields.setActive( true );
        return entityManager.merge( fields );
    }
    
    @Transactional
    @Override
    public void removeAdditionalFields(
        AdditionalDepartmentFields additionalFields )
    {
        additionalFields.setActive( false );
        entityManager.merge( additionalFields );        
    }

    @Override
    public AdditionalDepartmentFields additionalFields(
        Integer additionalDeptFieldsId )
    {
        return entityManager.find( AdditionalDepartmentFields.class, additionalDeptFieldsId );
    }

    @Override
    @Transactional
    public AdditionalDeptFieldValue saveFieldValue(
        AdditionalDeptFieldValue additionalDeptFieldValue )
    {
        return entityManager.merge( additionalDeptFieldValue );
    }

    @Override
    public List<AdditionalDeptFieldValue> additionalDeptFieldValue(
        Integer applicationId )
    {
        return entityManager.createQuery(
            "from AdditionalDeptFieldValue where application.applicationId = :applicationId",
            AdditionalDeptFieldValue.class )
            .setParameter( "applicationId", applicationId )
            .getResultList();
    }


  
}

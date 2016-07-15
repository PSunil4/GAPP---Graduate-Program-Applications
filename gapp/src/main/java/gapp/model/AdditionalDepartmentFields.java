package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additional_dept_fields")
public class AdditionalDepartmentFields implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column( name = "id" )
    private Integer additionalDeptFieldsId;

    //many additional fields can be required by one department
    //GMAT or Statement of Purpose for accounting 
    @ManyToOne
    private Department department;

    //Allow staff to customize the applications of a department by adding additional fields
    @ManyToOne
    private SystemUser systemStaff;
    
    @Column( name = "field_name" )
    private String fieldName;

    @Column( name = "field_value_type" )
    private String fieldValueType;

    @Column( name = "isfield_required" )
    private boolean isFieldRequired;

    private boolean isActive;
    
    public Integer getAdditionalDeptFieldsId()
    {
        return additionalDeptFieldsId;
    }

    
    public void setAdditionalDeptFieldsId( Integer additionalDeptFieldsId )
    {
        this.additionalDeptFieldsId = additionalDeptFieldsId;
    }

    
    public Department getDepartment()
    {
        return department;
    }

    
    public void setDepartment( Department department )
    {
        this.department = department;
    }

    
    public SystemUser getSystemStaff()
    {
        return systemStaff;
    }

    
    public void setSystemStaff( SystemUser systemStaff )
    {
        this.systemStaff = systemStaff;
    }

    
    public String getFieldName()
    {
        return fieldName;
    }

    
    public void setFieldName( String fieldName )
    {
        this.fieldName = fieldName;
    }

    
    public String getFieldValueType()
    {
        return fieldValueType;
    }

    
    public void setFieldValueType( String fieldValueType )
    {
        this.fieldValueType = fieldValueType;
    }

    
    public boolean isFieldRequired()
    {
        return isFieldRequired;
    }

    
    public void setFieldRequired( boolean isFieldRequired )
    {
        this.isFieldRequired = isFieldRequired;
    }

    
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }


    public boolean isActive()
    {
        return isActive;
    }


    public void setActive( boolean isActive )
    {
        this.isActive = isActive;
    }
}

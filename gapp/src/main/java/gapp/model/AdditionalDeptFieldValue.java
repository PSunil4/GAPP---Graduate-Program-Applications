package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additional_dept_field_values")
public class AdditionalDeptFieldValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer additional_dept_field_valuesId;

    // Many additional field values for one department field
    @ManyToOne
    private AdditionalDepartmentFields additionalDeptField;

    // Many additional field values can be entered for one student
    // @ManyToOne
    // private Student student;

    // value of the field based on fieldValueType from additionalDeptField
    @Column(name = "additional_field_value")
    private String additionalFieldValue;
    
    @ManyToOne
    private Application application;

    public Integer getAdditional_dept_field_valuesId()
    {
        return additional_dept_field_valuesId;
    }

    public void setAdditional_dept_field_valuesId(
        Integer additional_dept_field_valuesId )
    {
        this.additional_dept_field_valuesId = additional_dept_field_valuesId;
    }

    /*
    public Student getStudent()
    {
        return student;
    }

    public void setStudent( Student student )
    {
        this.student = student;
    }
     */
    public String getAdditionalFieldValue()
    {
        return additionalFieldValue;
    }

    public void setAdditionalFieldValue( String additionalFieldValue )
    {
        this.additionalFieldValue = additionalFieldValue;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    
    public AdditionalDepartmentFields getAdditionalDeptField()
    {
        return additionalDeptField;
    }

    
    public void setAdditionalDeptField(
        AdditionalDepartmentFields additionalDeptField )
    {
        this.additionalDeptField = additionalDeptField;
    }

    
    public Application getApplication()
    {
        return application;
    }

    
    public void setApplication( Application application )
    {
        this.application = application;
    }
}

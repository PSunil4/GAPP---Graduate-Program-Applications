package gapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "program_id")
    private Integer programId;

    @Column(name = "program_name")
    private String programName;

    @ManyToOne
    private Department department;
    
    private boolean isActive;

    public int getProgramId()
    {
        return programId;
    }

    public void setProgramId( int programId )
    {
        this.programId = programId;
    }

    public String getProgramName()
    {
        return programName;
    }

    public void setProgramName( String programName )
    {
        this.programName = programName;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment( Department department )
    {
        this.department = department;
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

package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_term")
    private String applicationTerm;
    
    @ManyToOne
    private SystemUser user;

    private String applicationStatus;
    // One application is only for one program
    //Changed From oneToOne Later
    @ManyToOne
    private Program programToApply;
    
    @Column(name = "date_of_submission")
    private Date dateOfSubmission;
    
    @Embedded
    private AcademicRecords academicRecords;
    
    @OneToMany(mappedBy = "studentApplication")
    private Set<EducationalBackground> studentEduBackground;
    
    @Column(name = "app_firstname")
    private String appfirstname;
    
    @Column(name = "app_lastname")
    private String appLastname;
    
    @Column(name = "app_email")
    private String appEmail;
    
    @Column(name = "cin")
    private int appCIN;

    @Column(name = "phone_number")
    private String appPhoneNumber;

    @Column(name = "app_gender")
    private String appGender;

    @Column(name = "app_birthdate")
    private Date appBirthdate;
    
    @Column(name = "app_citizenship")
    private String appCitizenship;
    
    private boolean international;

    public Integer getApplicationId()
    {
        return applicationId;
    }

    public void setApplicationId( Integer applicationId )
    {
        this.applicationId = applicationId;
    }

    public String getApplicationTerm()
    {
        return applicationTerm;
    }

    public void setApplicationTerm( String applicationTerm )
    {
        this.applicationTerm = applicationTerm;
    }

    public Program getProgramToApply()
    {
        return programToApply;
    }

    public void setProgramToApply( Program programToApply )
    {
        this.programToApply = programToApply;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public Date getDateOfSubmission()
    {
        return dateOfSubmission;
    }

    public void setDateOfSubmission( Date dateOfSubmission )
    {
        this.dateOfSubmission = dateOfSubmission;
    }
    
    public AcademicRecords getAcademicRecords()
    {
        return academicRecords;
    }

    public void setAcademicRecords( AcademicRecords academicRecords )
    {
        this.academicRecords = academicRecords;
    }

    
    public Set<EducationalBackground> getStudentEduBackground()
    {
        return studentEduBackground;
    }

    
    public void setStudentEduBackground(
        Set<EducationalBackground> studentEduBackground )
    {
        this.studentEduBackground = studentEduBackground;
    }
    
    public String getAppfirstname()
    {
        return appfirstname;
    }
    
    public void setAppfirstname( String appfirstname )
    {
        this.appfirstname = appfirstname;
    }

    public String getAppLastname()
    {
        return appLastname;
    }
    
    public void setAppLastname( String appLastname )
    {
        this.appLastname = appLastname;
    }
    
    public String getAppEmail()
    {
        return appEmail;
    }
    
    public void setAppEmail( String appEmail )
    {
        this.appEmail = appEmail;
    }

    
    public SystemUser getUser()
    {
        return user;
    }

    
    public void setUser( SystemUser user )
    {
        this.user = user;
    }

    
    public int getAppCIN()
    {
        return appCIN;
    }

    
    public void setAppCIN( int appCIN )
    {
        this.appCIN = appCIN;
    }

    
    public String getAppPhoneNumber()
    {
        return appPhoneNumber;
    }

    
    public void setAppPhoneNumber( String appPhoneNumber )
    {
        this.appPhoneNumber = appPhoneNumber;
    }

    
    public String getAppGender()
    {
        return appGender;
    }

    
    public void setAppGender( String appGender )
    {
        this.appGender = appGender;
    }

    
    public Date getAppBirthdate()
    {
        return appBirthdate;
    }

    
    public void setAppBirthdate( Date appBirthdate )
    {
        this.appBirthdate = appBirthdate;
    }

    
    public String getAppCitizenship()
    {
        return appCitizenship;
    }

    
    public void setAppCitizenship( String appCitizenship )
    {
        this.appCitizenship = appCitizenship;
    }

    
    public boolean isInternational()
    {
        return international;
    }

    
    public void setInternational( boolean international )
    {
        this.international = international;
    }

    public String getApplicationStatus()
    {
        return applicationStatus;
    }

    public void setApplicationStatus( String applicationStatus )
    {
        this.applicationStatus = applicationStatus;
    }
}

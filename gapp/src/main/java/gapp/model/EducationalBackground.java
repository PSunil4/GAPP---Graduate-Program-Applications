package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "educational_backgrounds")
public class EducationalBackground implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer educationalBackgroundId;

    @Column(name = "name_of_institute")
    private String nameOfInstitute;

    @Column(name = "time_period_attended")
    private String timePeriodAttended;

    @Column(name = "degree_earned")
    private String degreeEarned;

    @Column(name = "major_of_degree")
    private String majorOfDegree;

    // Many educational degrees for one student
    // @ManyToOne
    // private Student studentBackgroundInfo;

    @ManyToOne
    private Application studentApplication;
    
    public Integer getEducationalBackgroundId()
    {
        return educationalBackgroundId;
    }

    public void setEducationalBackgroundId( Integer educationalBackgroundId )
    {
        this.educationalBackgroundId = educationalBackgroundId;
    }

    public String getNameOfInstitute()
    {
        return nameOfInstitute;
    }

    public void setNameOfInstitute( String nameOfInstitute )
    {
        this.nameOfInstitute = nameOfInstitute;
    }

    public String getTimePeriodAttended()
    {
        return timePeriodAttended;
    }

    public void setTimePeriodAttended( String timePeriodAttended )
    {
        this.timePeriodAttended = timePeriodAttended;
    }

    public String getDegreeEarned()
    {
        return degreeEarned;
    }

    public void setDegreeEarned( String degreeEarned )
    {
        this.degreeEarned = degreeEarned;
    }

    public String getMajorOfDegree()
    {
        return majorOfDegree;
    }

    public void setMajorOfDegree( String majorOfDegree )
    {
        this.majorOfDegree = majorOfDegree;
    }

    /*
    public Student getStudentBackgroundInfo()
    {
        return studentBackgroundInfo;
    }

    public void setStudentBackgroundInfo( Student studentBackgroundInfo )
    {
        this.studentBackgroundInfo = studentBackgroundInfo;
    }
    */
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    
    public Application getStudentApplication()
    {
        return studentApplication;
    }

    
    public void setStudentApplication( Application studentApplication )
    {
        this.studentApplication = studentApplication;
    }

    
}

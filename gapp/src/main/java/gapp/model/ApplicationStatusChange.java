package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_status_changes")
public class ApplicationStatusChange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer applicationStatusChange;

    // One status can change many times
    private String applicationStatus;

    // Many status changes for one application
    @ManyToOne
    private Application application;

    @Column(name = "time_of_status")
    private Date timeOfStatus;

    // The comment is entered by the user who initiated the change (Reason)
    private String comment;

    @OneToOne
    private SystemUser user;
    
    public Integer getApplicationStatusChange()
    {
        return applicationStatusChange;
    }

    public void setApplicationStatusChange( Integer applicationStatusChange )
    {
        this.applicationStatusChange = applicationStatusChange;
    }

    public Application getApplication()
    {
        return application;
    }

    public void setApplication( Application application )
    {
        this.application = application;
    }

    public Date getTimeOfStatus()
    {
        return timeOfStatus;
    }

    public void setTimeOfStatus( Date timeOfStatus )
    {
        this.timeOfStatus = timeOfStatus;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment( String comment )
    {
        this.comment = comment;
    }
}

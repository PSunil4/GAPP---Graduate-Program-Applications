package gapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_status")
public class ApplicationStatus {

    @Id
    @GeneratedValue
    @Column(name = "app_status_id")
    private Integer applicationStatusId;

    @Column(name = "status_name")
    private String statusName;
   

    public int getApplicationStatusId()
    {
        return applicationStatusId;
    }

    public String getStatusName()
    {
        return statusName;
    }

    public void setStatusName( String statusName )
    {
        this.statusName = statusName;
    }

    
    public void setApplicationStatusId( Integer applicationStatusId )
    {
        this.applicationStatusId = applicationStatusId;
    }   
}

package gapp.model.dao;

import java.util.Date;
import java.util.List;

import gapp.model.Application;

public interface ApplicationDao {

    // get application based on the ID
    Application getApplication( Integer id );

    // get all the applications
    List<Application> getApplications();

    List<Application> getListOfApplications( Integer studentId );

    // get applications based on the Department and for which term
    List<Application> applicationPerDeptForTerm( String term, String department );

    // get application based on Email if "id" is unknown by user
    List<Application> applicationPerStudent( String studentEmail );
    
    Application saveApplication(Application application);
    
    Application addApplication( double gpa,
                                Integer toefl,
                                String transcript,
                                String applicationTerm,
                                Date dateOfSubmission,
                                Integer applicationStatusId,
                                Integer programToApplyId,
                                Integer studentId);

}

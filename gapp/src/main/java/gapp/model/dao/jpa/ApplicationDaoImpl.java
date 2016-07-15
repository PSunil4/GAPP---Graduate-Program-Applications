package gapp.model.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.dao.ApplicationDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application getApplication( Integer id )
    {
        return entityManager.find( Application.class, id );
    }

    @Override
    public List<Application> getApplications()
    {
        return entityManager.createQuery(
            "from Application order by applicationId", Application.class )
            .getResultList();
    }

    @Override
    public List<Application> applicationPerDeptForTerm( String term,
        String department )
    {
        return entityManager.createQuery(
            "from Application where applicationTerm = :term and programToApply.department.departmentName = :deptName",
            Application.class )
            .setParameter( "term", term )
            .setParameter( "deptName", department )
            .getResultList();
    }

    @Override
    public List<Application> applicationPerStudent( String studentEmail )
    {
        return entityManager.createQuery(
            "from Application where studentSystemUser.email = :studentEmail",
            Application.class )
            .setParameter( "studentEmail", studentEmail )
            .getResultList();
    }

    @Override
    public List<Application> getListOfApplications( Integer studentId )
    {
        return entityManager.createQuery( "from Application where user.userId = :studentId", Application.class )
            .setParameter( "studentId", studentId ).getResultList();
    }

    @Override
    @Transactional
    public Application saveApplication( Application application )
    {
        return entityManager.merge( application );
    }

    @Override
    public Application addApplication( double gpa, Integer toefl,
        String transcript, String applicationTerm, Date dateOfSubmission,
        Integer applicationStatusId, Integer programToApplyId, Integer studentId )
    {
        return null;
    }

}

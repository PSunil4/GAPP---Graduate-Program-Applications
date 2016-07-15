package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gapp.model.ApplicationStatus;
import gapp.model.dao.ApplicationStatusDao;

import org.springframework.stereotype.Repository;

@Repository
public class ApplicationStatusDaoImpl implements ApplicationStatusDao{


    @PersistenceContext
    private EntityManager applicationStatusDao;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationStatus> getListOfApplicationStatus()
    {
        return applicationStatusDao.createQuery( "from ApplicationStatus" ).getResultList();
    }

}

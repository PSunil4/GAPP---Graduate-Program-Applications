package gapp.model.dao.jpa;

import java.util.List;

import gapp.model.Application;
import gapp.model.EducationalBackground;
import gapp.model.dao.EducationalBackgroundDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EducationalBackgroundDaoImpl implements EducationalBackgroundDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EducationalBackground> getEduBackgroundByAppId(
        Application application )
    {
        return entityManager.createQuery( "from EducationalBackground where studentApplication.applicationId = :applicationId", EducationalBackground.class )
            .setParameter( "applicationId", application.getApplicationId() ).getResultList();
    }

    @Override
    @Transactional
    public EducationalBackground saveEducationalBackground(
        EducationalBackground eduBackground )
    {
        return entityManager.merge( eduBackground );
    }

    @Override
    @Transactional
    public void removeEducationalBackground(
        EducationalBackground educationalBackground )
    {
        entityManager.remove( educationalBackground );
    }

}

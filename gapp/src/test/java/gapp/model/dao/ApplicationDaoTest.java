package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests{

    /*
    @Autowired
    ApplicationDao applicationDao;
    
    @Test
    public void student1OneApplicationTest() {
        assert applicationDao.applicationPerDeptForTerm( "Fall 2016", "Accounting" ).size() == 1;
    }
    
    public void student1SubmittedApplication() {
        assert applicationDao.applicationPerStudent( "student1@localhost.localdomain" ).size() == 1;
    }
    */
    
}

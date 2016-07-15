package gapp.model.dao.jpa;

import gapp.model.SystemUser;
import gapp.model.dao.UserDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SystemUser getUser( Integer id )
    {
        return entityManager.find( SystemUser.class, id );
    }

    @Override
    public List<SystemUser> getUsers()
    {
        return entityManager.createQuery( "from SystemUser order by id",
            SystemUser.class ).getResultList();
    }

    @Override
    @Transactional
    public SystemUser saveUser( SystemUser user )
    {
        return entityManager.merge( user );
    }

    @Override
    public SystemUser userAuthentication( String email, String password )
    {
        Query checkUser = entityManager.createQuery( 
            "from SystemUser where email = :email and password = :password" , SystemUser.class )
            .setParameter( "email", email )
            .setParameter( "password", password);
            
        if(checkUser.getResultList().size() == 0) {
            return null;
        } else {
            return (SystemUser) checkUser.getSingleResult();
        }
    }
}

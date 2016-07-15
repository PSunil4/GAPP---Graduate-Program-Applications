package gapp.model.dao;

import java.util.List;

import gapp.model.SystemUser;

public interface UserDao {

    SystemUser getUser( Integer id );

    List<SystemUser> getUsers();
    
    SystemUser saveUser(SystemUser user);
    
    SystemUser userAuthentication(String email, String password);
    
}

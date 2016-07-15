package gapp.validator;

import java.util.List;

import gapp.model.SystemUser;
import gapp.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports( Class<?> clazz )
    {
        // clazz is User.class or a subclass of User
        return SystemUser.class.isAssignableFrom( clazz );
    }

    @Override
    public void validate( Object target, Errors errors )
    {
        /* USED REQUIRED TAG
            if( !StringUtils.hasText( user.getEmail() ) )
                errors.rejectValue( "email", "error.email.required" );
    
            if( !StringUtils.hasText( user.getPassword() ) )
                errors.rejectValue( "password", "error.password.required" );
            
            if( !StringUtils.hasText( user.getLastname() ) )
                errors.rejectValue( "lastname", "error.lastname.required" );
            
            if( !StringUtils.hasText( user.getFirstname() ) )
                errors.rejectValue( "firstname", "error.firstname.required" );
       */
    }
}

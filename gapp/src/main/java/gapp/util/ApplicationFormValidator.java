package gapp.util;

import gapp.model.Application;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ApplicationFormValidator implements Validator {

    @Override
    public boolean supports( Class<?> clazz )
    {
        return Application.class.isAssignableFrom( clazz );
    }

    @Override
    public void validate( Object target, Errors errors )
    {
        Application application = (Application) target;

        if( !StringUtils.hasText( application.getAppfirstname() ) )
        {
            errors.rejectValue( "appfirstname", "error.firstname.empty" );
        }

        if( !StringUtils.hasText( application.getAppLastname() ) )
        {
            errors.rejectValue( "appLastname", "error.lastname.empty" );
        }

        if( !StringUtils.hasText( application.getAppEmail() ) )
        {
            errors.rejectValue( "appEmail", "error.email.empty" );
        }

        if( !StringUtils.hasText( application.getAppPhoneNumber() ) )
        {
            errors.rejectValue( "appPhoneNumber", "error.phone.empty" );
        }

        if( !StringUtils.hasText( application.getAppCitizenship() ) )
        {
            errors.rejectValue( "appCitizenship", "error.citizenship.empty" );
        }
    }

}

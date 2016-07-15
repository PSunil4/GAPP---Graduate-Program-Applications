package gapp.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gapp.model.SystemUser;
import gapp.model.dao.UserDao;
import gapp.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("systemuser")
public class SystemUserController {
    
    @Autowired
    private UserDao userDao;

    @Autowired
    UserValidator userValidator;
    
    @RequestMapping("/users.html")
    public String users( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "users";
    }
    
    @RequestMapping(value = "/systemuser/registration.html", method = RequestMethod.GET)
    public String registerUser(ModelMap models, HttpServletRequest request) {
        request.getSession().removeAttribute( "error" );
        models.put( "systemuser", new SystemUser() );
        return "systemuser/registration";
    }
    
    @RequestMapping(value = "/systemuser/registration.html", method = RequestMethod.POST)
    public String registerUser( @ModelAttribute SystemUser user, 
                                BindingResult bindingResult,
                                HttpServletRequest request,
                                RedirectAttributes redirectAttributes)
    {
        List<SystemUser> users = userDao.getUsers();
       
        for (SystemUser su: users) {
            if(su.getEmail().equalsIgnoreCase( user.getEmail() )){
                request.getSession().setAttribute( "error", "Email Exists, Enter A Unique Email." );
                return "systemuser/registration";
            }
        }
        
        user.setTypeOfUser( "student" );
        userDao.saveUser( user );
        redirectAttributes.addFlashAttribute( "user", user );
        redirectAttributes.addFlashAttribute( "registrationSuccess", "Registration Successful For" );
        return "redirect:/systemuser/login.html";
    }
    
    @RequestMapping(value = "/systemuser/login.html", method = RequestMethod.GET)
    public String login( ModelMap models, HttpServletRequest request )
    {
        request.getSession().removeAttribute( "error" );
        models.put( "systemuser", new SystemUser() );
        return "systemuser/login";
    }
    
    @RequestMapping(value = "/systemuser/login.html", method = RequestMethod.POST)
    public String login( @ModelAttribute SystemUser user, BindingResult bindingResult, HttpServletRequest request )
    {
        List<SystemUser> users = userDao.getUsers();
        int counter = 0;
        for (SystemUser su: users) {
            if(su.getEmail().equalsIgnoreCase( user.getEmail() )){
                counter = 1;
            }
        }
   
        /* Valid User Authetication */
        if( counter == 1 )
        {
            SystemUser activeUser = userDao.userAuthentication(
                user.getEmail(), user.getPassword() );

            if( activeUser == null )
            {
                request.getSession().setAttribute( "error",
                    "Invalid Username OR Password." );
                return "systemuser/login";
            }
            else
            {
                String fullName = activeUser.getFirstname() + " "
                    + activeUser.getLastname();

                request.getSession().setAttribute( "username", fullName );
                request.getSession().setAttribute( "userId",
                    activeUser.getUserId() );

                switch( activeUser.getTypeOfUser() )
                {
                    case "admin":
                        return "redirect:/administrator/adminhome.html";
                    case "staff":
                        return "redirect:/staff/staffhome.html";
                    case "student":
                        return "redirect:/student/studenthome.html";
                    default:
                        return "redirect:/systemuser/login.html";
                }
            }
        }
        else
        {
            request.getSession().setAttribute( "error",
                "Email Address Is Not Registered!" );
            return "systemuser/login";
        }
        
    }
    
    @RequestMapping(value = "/administrator/adminhome.html", method = RequestMethod.GET)
    public String administrator( ModelMap models, HttpServletRequest request )
    {
        request.getSession().removeAttribute( "error" );
        // models.put( "systemuser", new SystemUser() );
        return "administrator/adminhome";
    }
    
    @RequestMapping(value = "/staff/staffhome.html", method = RequestMethod.GET)
    public String staff( ModelMap models, HttpServletRequest request )
    {
        request.getSession().removeAttribute( "error" );
        return "staff/staffhome";
    }
    
    

}

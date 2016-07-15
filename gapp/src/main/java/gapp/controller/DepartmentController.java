package gapp.controller;

import javax.servlet.http.HttpServletRequest;

import gapp.model.AdditionalDepartmentFields;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.SystemUser;
import gapp.model.dao.AdditionalDeptFieldDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("department")
public class DepartmentController {
    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private AdditionalDeptFieldDao additionalDeptFieldDao;
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping("/administrator/detailsofdepartment.html")
    public String departmentDetails( ModelMap models, @RequestParam Integer deptId )
    {
        models.put( "departmentDetail", departmentDao.getDepartment( deptId ) );
        models.put( "programInfo", programDao.getProgByDeptId( deptId ) );
        models.put( "deptAdditionalFields", additionalDeptFieldDao.additionalFieldsPerDept( deptId ) );
        return "administrator/detailsofdepartment";
    }
    
    /* START OF ADDING A NEW DEPARTMENT */
    @RequestMapping(value = "/administrator/addnewdepartment.html", method = RequestMethod.GET)
    public String addNewDepartment (ModelMap models) {
        models.put( "department", new Department() );
        return "administrator/addnewdepartment";
    }
    
    @RequestMapping(value = "/administrator/addnewdepartment.html", method = RequestMethod.POST)
    public String addNewDepartment( @ModelAttribute Department department )
    {
        departmentDao.addDepartment( department );
        return "redirect:/administrator/listofdepartments.html";
    }
    
    /* START OF ADDING A NEW DEPARTMENT PROGRAMS*/
    @RequestMapping(value = "/administrator/addnewdeptprograms.html", method = RequestMethod.GET)
    public String addNewDepartmentPrograms (ModelMap models ) {
        models.put( "listOfdept", departmentDao.getDepartments() );
        models.put( "program", new Program() );
        return "administrator/addnewdeptprograms";
    }
    
    @RequestMapping(value = "/administrator/addnewdeptprograms.html", method = RequestMethod.POST)
    public String addNewDepartmentPrograms ( @ModelAttribute Program program, HttpServletRequest request )
    {
        Integer deptId = Integer.parseInt( request.getParameter( "departmentNames" ) );
        programDao.addProgram( program, departmentDao.getDepartment( deptId ) );
        return "redirect:/administrator/detailsofdepartment.html?deptId="+deptId+"";
    }
    
    /* START OF ADDING ADDITIONAL DEPARTMENT FIELDS */
    @RequestMapping(value = "/administrator/addadditionaldeptfields.html", method = RequestMethod.GET)
    public String addAdditionalDeptFields (ModelMap models) {
        models.put( "listOfdept", departmentDao.getDepartments() );
        models.put( "additionalRequirement", new AdditionalDepartmentFields() );
        return "administrator/addadditionaldeptfields";
    }
    
    @RequestMapping(value = "/administrator/addadditionaldeptfields.html", method = RequestMethod.POST)
    public String addAdditionalDeptFields ( @ModelAttribute AdditionalDepartmentFields additional, HttpServletRequest request )
    {
        Integer systemUserId = (Integer) request.getSession().getAttribute( "userId" );
       
        Integer deptId = Integer.parseInt( request.getParameter( "departmentNames" ) );
        SystemUser userId = userDao.getUser( systemUserId );
        
        additionalDeptFieldDao.addNewFields( additional, departmentDao.getDepartment( deptId ),  userId);
        return "redirect:/administrator/detailsofdepartment.html?deptId="+deptId+"";
    }
    
    /*START OF EDIT DEPARTMENT NAME */
    @RequestMapping(value = "/administrator/editdepartmentname.html", method = RequestMethod.GET)
    public String editDepartmentName (ModelMap models, @RequestParam Integer deptId) {
        
        models.put( "department", departmentDao.getDepartment( deptId ) );
        return "administrator/editdepartmentname";
    }
 
    @RequestMapping(value = "/administrator/editdepartmentname.html", method = RequestMethod.POST)
    public String editDepartmentName ( @ModelAttribute Department department, SessionStatus sessionStatus)
    {
        departmentDao.addDepartment( department );
        sessionStatus.setComplete();
        return "redirect:/administrator/listofdepartments.html";
    }
    
    /*START OF EDIT DEPARTMENT ADDITIONAL FIELDS */
    @RequestMapping(value = "/administrator/editadditionalinformation.html", method = RequestMethod.GET)
    public String additionalDepartmentFields (ModelMap models, @RequestParam Integer deptId) {
        
        models.put( "additionalFields", additionalDeptFieldDao.additionalFieldsPerDept( deptId ) );
        models.put( "department", departmentDao.getDepartment( deptId ) );
        models.put( "additional", new AdditionalDepartmentFields() );
        return "administrator/editadditionalinformation";
    }
 
    @RequestMapping(value = "/administrator/editadditionalinformation.html", method = RequestMethod.POST)
    public String additionalDepartmentFields ( @ModelAttribute AdditionalDepartmentFields adf, SessionStatus sessionStatus)
    {
        return "redirect:/administrator/editadditionalinformation.html";
    }
    
    
    
}

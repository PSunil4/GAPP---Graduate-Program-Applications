package gapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.ProgramCount;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ProgramController {

    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/administrator/listofdepartments.html")
    public String programs( ModelMap models )
    {
        List<ProgramCount> PrgsPerDepts = new ArrayList<ProgramCount>();
        List<Object[]> programCount = programDao.listOfPrgPerDept();
        
        for (Object[] p: programCount) {
            PrgsPerDepts.add( new ProgramCount(Integer.parseInt( p[0].toString() ), Integer.parseInt( p[1].toString() )) );
        }
        
        models.put( "PrgsPerDepts", PrgsPerDepts );
        models.put( "listOfDepts", departmentDao.getDepartments() );
        return "administrator/listofdepartments";
    }
    
    @RequestMapping(value = "/administrator/editdepartmentprogram.html", method = RequestMethod.GET)
    public String editDepartmentProgram (ModelMap models, @RequestParam Integer deptId) {
        
        models.put( "program", new Program() );
        models.put("programList", programDao.getProgByDeptId( deptId ));
        models.put( "department", departmentDao.getDepartment( deptId ) );
        return "administrator/editdepartmentprogram";
    }
    
    @RequestMapping(value = "/administrator/editdepartmentprogram.html", method = RequestMethod.POST)
    public String addAdditionalDeptProgram ( @ModelAttribute Department department, SessionStatus sessionStatus)
    {
        departmentDao.addDepartment( department );
        sessionStatus.setComplete();
        return "redirect:/administrator/listofdepartments.html";
    }

    
    @RequestMapping(value = "/administrator/removedeptprograms.html", method = RequestMethod.GET)
    public String removeDepartmentPrograms (ModelMap models, @RequestParam Integer prgmId, @RequestParam Integer deptId) {
        
        programDao.removeProgram( programDao.getProgram( prgmId ) );
        return "redirect:/administrator/editdepartmentprogram.html?deptId="+deptId+"";
    }
    
    @RequestMapping(value = "/administrator/logout.html", method = RequestMethod.GET)
    public String removeDepartmentPrograms (HttpSession session) {
        
        session.invalidate();
        return "redirect:/systemuser/login.html";
    }
}

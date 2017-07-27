package gapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gapp.model.dao.AdditionalDeptFieldDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.EducationalBackgroundDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private EducationalBackgroundDao educationalBackgroundDao;
    
    @Autowired
    private AdditionalDeptFieldDao additionalDeptFieldDao;
    
    @Autowired
    private WebApplicationContext context;
    
    private File getFileDirectory() {
        String path = context.getServletContext().getRealPath( "/WEB-INF/files/" );
        return new File(path);
    }
    
    @RequestMapping("/applications.html")
    public String applications (ModelMap models) {
        models.put( "applications", applicationDao.applicationPerDeptForTerm( "Fall 2016", "Accounting" ) );
        return "applications";
    }
    
    @RequestMapping(value = "/student/applicationdetails.html", method = RequestMethod.GET)
    public String student( ModelMap models, HttpServletRequest request, @RequestParam Integer appsId )
    {
        models.put( "applicationDetails", applicationDao.getApplication( appsId ) );
        models.put( "educationBackground", educationalBackgroundDao.getEduBackgroundByAppId( applicationDao.getApplication( appsId )));
        models.put( "additionalFields", additionalDeptFieldDao.additionalFieldsPerDept( applicationDao.getApplication( appsId ).getProgramToApply().getDepartment().getDepartmentId() ) );
        models.put( "additionalFieldsValue",  additionalDeptFieldDao.additionalDeptFieldValue( appsId ));
        return "student/applicationdetails";
    }
    
    @RequestMapping(value = "/student/download.html")
    public String downloadFile(HttpServletResponse response, @RequestParam String fileName) throws IOException {
        
        response.setContentType( "text/plain" );        
        response.setHeader( "Content-Disposition", "attachment; filename="+fileName+"" );
        
        InputStream in = context.getServletContext().getResourceAsStream( "/WEB-INF/files/"+fileName );
        
        int read = 0;
        byte[] bytes = new byte[2048];
        OutputStream os = response.getOutputStream();
        while((read = in.read(bytes)) > 0){
            os.write( bytes, 0, read );
        }
        
        os.flush();
        os.close();
        
        return null;        
    }
   
}





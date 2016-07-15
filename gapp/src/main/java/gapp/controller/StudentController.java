package gapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import gapp.model.AdditionalDepartmentFields;
import gapp.model.AdditionalDeptFieldValue;
import gapp.model.Application;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.dao.AdditionalDeptFieldDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.EducationalBackgroundDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;
import gapp.util.ApplicationFormValidator;
import gapp.util.FileUploadForm;
import gapp.util.IntEditor;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@EnableWebMvc
@SessionAttributes("application")
public class StudentController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private AdditionalDeptFieldDao additionalDepartmentFieldDao;
    
    @Autowired
    private EducationalBackgroundDao educationalBackgroundDao;
    
    @Autowired
    private ApplicationFormValidator applicationFormValidator;
    
    private Integer departmentId = 0;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private File getFileDirectory() {
        String path = context.getServletContext().getRealPath( "/WEB-INF/files" );
        return new File(path);
    }
    
    @RequestMapping(value = "/student/studenthome.html", method = RequestMethod.GET)
    public String studenthome ( ModelMap models, HttpServletRequest request )
    {
        request.getSession().removeAttribute( "error" );
        Integer studentId = (Integer) request.getSession().getAttribute( "userId" );
        models.put( "listOfApplications", applicationDao.getListOfApplications( studentId ) );
        return "student/studenthome";
    }
    
    @RequestMapping(value = "/student/createnewapplication.html", method = RequestMethod.GET)
    public String createNewStudentApplication (ModelMap models, HttpSession session) {
        
        String username = (String) session.getAttribute( "username" );
        Integer userId = (Integer) session.getAttribute( "userId" );
        
        Application application = new Application();
        
        
        models.put( "application", application );
        models.put( "listOfDepartments", departmentDao.getDepartments() );
        models.put( "listOfPrograms", programDao.getPrograms() );
        models.put( "listOfFields",  additionalDepartmentFieldDao.additionalFieldsPerDept( 1 ));
        
        return "student/createnewapplication";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(int.class, new IntEditor(int.class));
    }
    
    @RequestMapping(value = "/student/createnewapplication.html", method = RequestMethod.POST)
    public String createNewStudentApplication ( ModelMap models, HttpServletRequest request,
                                                HttpSession session,
                                                @ModelAttribute Application application,
                                                RedirectAttributes redirectAttributes,
                                                BindingResult result,
                                                @ModelAttribute("FileUploadForm") FileUploadForm additionalFileUpload,
                                                @RequestParam( required = false ) MultipartFile transcript) throws IllegalStateException, IOException, ParseException {
      
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        
        Integer userId = (Integer) session.getAttribute( "userId" );
        
        String institutionName1 = request.getParameter( "institutionName1" );
        String timePeriodAttended1 = request.getParameter( "timePeriodAttended1" );
        String degreeEarned1 = request.getParameter( "degreeEarned1" );
        String majorOfDegree1 = request.getParameter( "majorOfDegree1" );
        
        String institutionName2 = request.getParameter( "institutionName2" );
        String timePeriodAttended2 = request.getParameter( "timePeriodAttended2" );
        String degreeEarned2 = request.getParameter( "degreeEarned2" );
        String majorOfDegree2 = request.getParameter( "majorOfDegree2" );
        
        String institutionName3 = request.getParameter( "institutionName3" );
        String timePeriodAttended3 = request.getParameter( "timePeriodAttended3" );
        String degreeEarned3 = request.getParameter( "degreeEarned3" );
        String majorOfDegree3 = request.getParameter( "majorOfDegree3" );
        
        String institutionName4 = request.getParameter( "institutionName4" );
        String timePeriodAttended4 = request.getParameter( "timePeriodAttended4" );
        String degreeEarned4 = request.getParameter( "degreeEarned4" );
        String majorOfDegree4 = request.getParameter( "majorOfDegree4" );
              
        String departmentId = request.getParameter( "departmentNames" );
        String appBirthdate = request.getParameter( "appBirthdate" );
        Integer programId = Integer.parseInt( request.getParameter( "programName" ) );
        
        String submitValue = request.getParameter( "submit" );
        
        List<AdditionalDepartmentFields> additionalFields = additionalDepartmentFieldDao.additionalFieldsPerDept( Integer.parseInt( departmentId ) );
        
        
        if(submitValue.equalsIgnoreCase( "Save" )) {
            
            /*SET APPLICATION ATTRIBUTES AND OBJECT */
            List<String> fileNames = new ArrayList<String>();
            
            application.setUser( userDao.getUser( userId ) );
            application.setProgramToApply( programDao.getProgram( programId ) );
            application.setApplicationStatus( "Not Submitted" );
            
            if (!transcript.getOriginalFilename().isEmpty()){
                /*SAVE FILE TO WEB-INF*/
                transcript.transferTo( new File(getFileDirectory(), "(" +  dateFormat.format(date) + ") " + transcript.getOriginalFilename() ) );
                application.getAcademicRecords().setTranscript( "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() );
            } 
            
            if(!appBirthdate.isEmpty()) {
                application.setAppBirthdate( dateFormat2.parse( appBirthdate ) );
            }
            
            Application  addedApplicationId = applicationDao.saveApplication( application );
            
            addEducationalBackgroundOne(degreeEarned1, majorOfDegree1, institutionName1, timePeriodAttended1, addedApplicationId);
            
            if(!institutionName2.isEmpty() && institutionName2.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned2, majorOfDegree2, institutionName2, timePeriodAttended2, addedApplicationId);
            }
            
            if(!institutionName3.isEmpty() && institutionName3.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned3, majorOfDegree3, institutionName3, timePeriodAttended3, addedApplicationId);
            }
            
            if(!institutionName4.isEmpty() && institutionName4.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned4, majorOfDegree4, institutionName4, timePeriodAttended4, addedApplicationId);
            }
            
            /* Upload The Additional Files */
            List<MultipartFile> uploadFile = additionalFileUpload.getFiles();
            if( null != uploadFile && uploadFile.size() > 0 )
            {
                for( MultipartFile file : uploadFile )
                {
                    if( file != null )
                    {
                        file.transferTo( new File( getFileDirectory(), "("
                            + dateFormat.format( date ) + ") "
                            + file.getOriginalFilename() ) );
                        fileNames.add( file.getOriginalFilename() );
                    }
                }
            }
            
            int counter = 0;
            for (int i = 0; i < additionalFields.size(); i++) {
                if (additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "Number" ) || 
                        additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "Text" )) {
                    
                    AdditionalDeptFieldValue additionalFieldValue = new AdditionalDeptFieldValue();
                    
                    additionalFieldValue.setAdditionalDeptField( additionalFields.get( i ) );
                    additionalFieldValue.setAdditionalFieldValue( request.getParameter( "textbox" + i ) );
                    additionalFieldValue.setApplication( addedApplicationId );
                    
                    additionalDepartmentFieldDao.saveFieldValue( additionalFieldValue );
                    
                } else if (additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "File" )){
                    
                    AdditionalDeptFieldValue additionalFieldValue = new AdditionalDeptFieldValue();
                    additionalFieldValue.setAdditionalFieldValue( "(" +  dateFormat.format(date) + ") " + fileNames.get( counter ) );
                    additionalFieldValue.setAdditionalDeptField( additionalFields.get( i ) );
                    additionalFieldValue.setApplication( addedApplicationId );
                    additionalDepartmentFieldDao.saveFieldValue( additionalFieldValue );
                    counter++;
                }    
          }
            

            redirectAttributes.addFlashAttribute( "applicationstatus", "Application Saved.");
            redirectAttributes.addFlashAttribute( "date", date );
    
            
        } else {
            
            /*SET APPLICATION ATTRIBUTES AND OBJECT */
            List<String> fileNames = new ArrayList<String>();
            application.setUser( userDao.getUser( userId ) );
            application.setProgramToApply( programDao.getProgram( programId ) );
            application.setApplicationStatus( "Submitted" );
            application.getAcademicRecords().setTranscript( "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() );
            application.setDateOfSubmission(  date );
            
            if(!appBirthdate.isEmpty()) {
                application.setAppBirthdate( dateFormat2.parse( appBirthdate ) );
            }
     
            
            /*DISPLAY ERROR IF FIELDS ARE EMPTY WHILE SUBMITTING */
            applicationFormValidator.validate( application, result );
            if(result.hasErrors()){
                redirectAttributes.addFlashAttribute( "applicationstatus", "All (*) Fields Are Required");
                return "redirect:/student/createnewapplication.html";
            }
            
            Application  addedApplicationId = applicationDao.saveApplication( application );
            
            addEducationalBackgroundOne(degreeEarned1, majorOfDegree1, institutionName1, timePeriodAttended1, addedApplicationId);
            
            if(!institutionName2.isEmpty() && institutionName2.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned2, majorOfDegree2, institutionName2, timePeriodAttended2, addedApplicationId);
            }
            
            if(!institutionName3.isEmpty() && institutionName3.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned3, majorOfDegree3, institutionName3, timePeriodAttended3, addedApplicationId);
            }
            
            if(!institutionName4.isEmpty() && institutionName4.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned4, majorOfDegree4, institutionName4, timePeriodAttended4, addedApplicationId);
            }
            
            /* ADDITIONAL FILE UPLOAD */
            
            /* Upload The Additional Files */
            List<MultipartFile> uploadFile = additionalFileUpload.getFiles();
            if( null != uploadFile && uploadFile.size() > 0 )
            {
                for( MultipartFile file : uploadFile )
                {
                    if( file != null )
                    {
                        file.transferTo( new File( getFileDirectory(), "("
                            + dateFormat.format( date ) + ") "
                            + file.getOriginalFilename() ) );
                        fileNames.add( file.getOriginalFilename() );
                    }
                }
            }
            
            int counter = 0;
            for (int i = 0; i < additionalFields.size(); i++) {
                if (additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "Number" ) || 
                        additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "Text" )) {
                    
                    AdditionalDeptFieldValue additionalFieldValue = new AdditionalDeptFieldValue();
                    
                    additionalFieldValue.setAdditionalDeptField( additionalFields.get( i ) );
                    additionalFieldValue.setAdditionalFieldValue( request.getParameter( "textbox" + i ) );
                    additionalFieldValue.setApplication( addedApplicationId );
                    
                    additionalDepartmentFieldDao.saveFieldValue( additionalFieldValue );
                    
                } else if (additionalFields.get( i ).getFieldValueType().equalsIgnoreCase( "File" )){
                    
                    AdditionalDeptFieldValue additionalFieldValue = new AdditionalDeptFieldValue();
                    additionalFieldValue.setAdditionalFieldValue( "(" +  dateFormat.format(date) + ") " + fileNames.get( counter ) );
                    additionalFieldValue.setAdditionalDeptField( additionalFields.get( i ) );
                    additionalFieldValue.setApplication( addedApplicationId );
                    additionalDepartmentFieldDao.saveFieldValue( additionalFieldValue );
                    counter++;
                }
            }
            
            /* ADDITIONAL FILE UPLOAD */
            
            if (transcript.isEmpty()) {
                redirectAttributes.addFlashAttribute( "applicationstatus", "All * Fields Are Required");
                return "redirect:/student/createnewapplication.html";
            }
            
            /*SAVE FILE TO WEB-INF*/
            transcript.transferTo( new File(getFileDirectory(), "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() ) );
            
            redirectAttributes.addFlashAttribute( "applicationstatus", "Application Submitted." );
            redirectAttributes.addFlashAttribute( "date", date );
        }
        
        return "redirect:/student/studenthome.html";
    }

    @RequestMapping(value = "/student/editstudentapplication.html", method = RequestMethod.GET)
    public String editStudentApplication(ModelMap models, @RequestParam Integer appsId) {
        
        Application application = applicationDao.getApplication( appsId );
        models.put( "application", application );
        models.put( "programs", programDao.getProgByDeptId( application.getProgramToApply().getDepartment().getDepartmentId() ) );
        models.put( "programSelected", application.getProgramToApply().getProgramName() );
        models.put( "department",  departmentDao.getDepartment( application.getProgramToApply().getDepartment().getDepartmentId() ));
        models.put( "educationalBackground", educationalBackgroundDao.getEduBackgroundByAppId( application ) );
        return "student/editstudentapplication";
    }
    
    @RequestMapping(value = "/student/editstudentapplication.html", method = RequestMethod.POST)
    public String editstudentapplication (      ModelMap models, HttpServletRequest request,
                                                HttpSession session,
                                                @ModelAttribute Application application,
                                                SessionStatus sessionStatus,
                                                RedirectAttributes redirectAttributes,
                                                BindingResult result,
                                                @RequestParam( required = false ) MultipartFile transcript) throws IllegalStateException, IOException, ParseException {
      
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Integer userId = (Integer) session.getAttribute( "userId" );
        
        String institutionName1 = request.getParameter( "institutionName1" );
        String timePeriodAttended1 = request.getParameter( "timePeriodAttended1" );
        String degreeEarned1 = request.getParameter( "degreeEarned1" );
        String majorOfDegree1 = request.getParameter( "majorOfDegree1" );
        
        String institutionName2 = request.getParameter( "institutionName2" );
        String timePeriodAttended2 = request.getParameter( "timePeriodAttended2" );
        String degreeEarned2 = request.getParameter( "degreeEarned2" );
        String majorOfDegree2 = request.getParameter( "majorOfDegree2" );
        
        String institutionName3 = request.getParameter( "institutionName3" );
        String timePeriodAttended3 = request.getParameter( "timePeriodAttended3" );
        String degreeEarned3 = request.getParameter( "degreeEarned3" );
        String majorOfDegree3 = request.getParameter( "majorOfDegree3" );
        
        String institutionName4 = request.getParameter( "institutionName4" );
        String timePeriodAttended4 = request.getParameter( "timePeriodAttended4" );
        String degreeEarned4 = request.getParameter( "degreeEarned4" );
        String majorOfDegree4 = request.getParameter( "majorOfDegree4" );
        
        String departmentId = request.getParameter( "departmentNames" );
        String appBirthdate = request.getParameter( "appBirthdate" );
        Integer programId = Integer.parseInt( request.getParameter( "programName" ) );
        
        String submitValue = request.getParameter( "submit" );
        
       
        Application oldApplication = applicationDao.getApplication( application.getApplicationId() );
            
        List<EducationalBackground> listEb = educationalBackgroundDao.getEduBackgroundByAppId( oldApplication );
            
        for (EducationalBackground e: listEb) {
            educationalBackgroundDao.removeEducationalBackground( e );
        }  
         
        
        if(submitValue.equalsIgnoreCase( "Save" )) {
            
            /*SET APPLICATION ATTRIBUTES AND OBJECT */
            application.setUser( userDao.getUser( userId ) );
            application.setProgramToApply( programDao.getProgram( programId ) );
            application.setApplicationStatus( "Not Submitted" );

            if(!appBirthdate.isEmpty()) {
                application.setAppBirthdate( dateFormat2.parse( appBirthdate ) );
            }
            
            if (!transcript.getOriginalFilename().isEmpty()){
                /*SAVE FILE TO WEB-INF*/
                transcript.transferTo( new File(getFileDirectory(), "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() ) );
                application.getAcademicRecords().setTranscript("(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() );
            }
            
            
            Application  addedApplicationId = applicationDao.saveApplication( application );
            
            addEducationalBackgroundOne(degreeEarned1, majorOfDegree1, institutionName1, timePeriodAttended1, addedApplicationId);
            
            if(!institutionName2.isEmpty() && institutionName2.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned2, majorOfDegree2, institutionName2, timePeriodAttended2, addedApplicationId);
            }
            
            if(!institutionName3.isEmpty() && institutionName3.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned3, majorOfDegree3, institutionName3, timePeriodAttended3, addedApplicationId);
            }
            
            if(!institutionName4.isEmpty() && institutionName4.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned4, majorOfDegree4, institutionName4, timePeriodAttended4, addedApplicationId);
            }
            
            redirectAttributes.addFlashAttribute( "applicationstatus", "Application Saved.");
            redirectAttributes.addFlashAttribute( "date", date );
            redirectAttributes.addFlashAttribute( "icon", "glyphicon glyphicon-info-sign" );
    
            
        } else {
             
            /*SET APPLICATION ATTRIBUTES AND OBJECT */
            application.setUser( userDao.getUser( userId ) );
            application.setProgramToApply( programDao.getProgram( programId ) );
                        
            if(!transcript.isEmpty()) {
                application.getAcademicRecords().setTranscript( "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() );
            }
            
            applicationFormValidator.validate( application, result );
            if(!result.hasErrors()) {
                application.setDateOfSubmission( date );
                application.setApplicationStatus( "Submitted" );
            }
            
            if(!appBirthdate.isEmpty()) {
                application.setAppBirthdate( dateFormat2.parse( appBirthdate ) );
            }
           
            Application  addedApplicationId = applicationDao.saveApplication( application );
            
            addEducationalBackgroundOne(degreeEarned1, majorOfDegree1, institutionName1, timePeriodAttended1, addedApplicationId);
            
            if(!institutionName2.isEmpty() && institutionName2.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned2, majorOfDegree2, institutionName2, timePeriodAttended2, addedApplicationId);
            }
            
            if(!institutionName3.isEmpty() && institutionName3.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned3, majorOfDegree3, institutionName3, timePeriodAttended3, addedApplicationId);
            }
            
            if(!institutionName4.isEmpty() && institutionName4.trim().length() > 0) {
                addEducationalBackgroundTwo(degreeEarned4, majorOfDegree4, institutionName4, timePeriodAttended4, addedApplicationId);
            }
            
            
            /*DISPLAY ERROR IF FIELDS ARE EMPTY WHILE SUBMITTING */
            
            if(result.hasErrors()){
                redirectAttributes.addFlashAttribute( "applicationstatus", "All (*) Fields Are Required");
                return "redirect:/student/editstudentapplication.html?appsId="+application.getApplicationId()+"";
            }
            
            if (transcript.isEmpty()) {
                if (application.getAcademicRecords().getTranscript() == null) {
                    redirectAttributes.addFlashAttribute( "applicationstatus", "All * Fields Are Required");
                    return "redirect:/student/editstudentapplication.html?appsId="+application.getApplicationId()+"";
                }
            }
            
            /*SAVE FILE TO WEB-INF*/
            transcript.transferTo( new File(getFileDirectory(), "(" +  dateFormat.format(date) + ") "  + transcript.getOriginalFilename() ) );
            redirectAttributes.addFlashAttribute( "applicationstatus", "Application Submitted." );
            redirectAttributes.addFlashAttribute( "date", date );
        }
        
        
        sessionStatus.setComplete();        
        return "redirect:/student/studenthome.html";
    }
    
    public void addEducationalBackgroundOne(String degreeEarned1, String majorOfDegree1, String institutionName1, String timePeriodAttended1, Application addedApplicationId)
    {
        EducationalBackground eb = new EducationalBackground();        
        
        eb.setDegreeEarned( degreeEarned1 );
        eb.setMajorOfDegree( majorOfDegree1 );
        eb.setNameOfInstitute( institutionName1 );
        eb.setTimePeriodAttended( timePeriodAttended1 );
        eb.setStudentApplication( addedApplicationId );
      
        educationalBackgroundDao.saveEducationalBackground( eb );
    }

    public void addEducationalBackgroundTwo(String degreeEarned2, String majorOfDegree2, String institutionName2, String timePeriodAttended2, Application addedApplicationId)
    {
        EducationalBackground eb2 = new EducationalBackground();
        
        eb2.setDegreeEarned( degreeEarned2 );
        eb2.setMajorOfDegree( majorOfDegree2 );
        eb2.setNameOfInstitute( institutionName2 );
        eb2.setTimePeriodAttended( timePeriodAttended2 );
        eb2.setStudentApplication( addedApplicationId );
        
        educationalBackgroundDao.saveEducationalBackground( eb2 );
    }

    public void addEducationalBackgroundThree(String degreeEarned3, String majorOfDegree3, String institutionName3, String timePeriodAttended3, Application addedApplicationId)
    {
        EducationalBackground eb3 = new EducationalBackground();
        
        eb3.setDegreeEarned( degreeEarned3 );
        eb3.setMajorOfDegree( majorOfDegree3 );
        eb3.setNameOfInstitute( institutionName3 );
        eb3.setTimePeriodAttended( timePeriodAttended3 );
        eb3.setStudentApplication( addedApplicationId );
        
        educationalBackgroundDao.saveEducationalBackground( eb3 );
    }

    public void addEducationalBackgroundFour(String degreeEarned4, String majorOfDegree4, String institutionName4, String timePeriodAttended4, Application addedApplicationId)
    {
        EducationalBackground eb4 = new EducationalBackground();
        
        eb4.setDegreeEarned( degreeEarned4 );
        eb4.setMajorOfDegree( majorOfDegree4 );
        eb4.setNameOfInstitute( institutionName4 );
        eb4.setTimePeriodAttended( timePeriodAttended4 );
        eb4.setStudentApplication( addedApplicationId );
        
        educationalBackgroundDao.saveEducationalBackground( eb4 );
    }
    
    @RequestMapping(value = "/student/deptprogwithajax.html", method = RequestMethod.GET) 
    @ResponseBody
    public String deptProgramWithAjax(ModelMap models, HttpServletResponse response, @RequestParam(value="deptId", required=true) Integer deptId) throws JsonGenerationException, JsonMappingException, IOException {    
       
        List<Program> departmentPrograms = programDao.getProgByDeptId( deptId );
        response.setContentType( "application/json" );
        objectMapper.writeValue( response.getWriter(), departmentPrograms );
        
        return null;  
    }
    
    @RequestMapping(value = "/student/additionalFieldsWithAjax.html", method = RequestMethod.GET) 
    @ResponseBody
    public String additionalFieldsWithAjax( ModelMap models, 
                                            HttpServletResponse response,
                                            @RequestParam(value="deptId", required=true) Integer deptId) throws JsonGenerationException,
                                            JsonMappingException, IOException {    
       
        List<AdditionalDepartmentFields> additionalFields = additionalDepartmentFieldDao.additionalFieldsPerDept( deptId );
        response.setContentType( "application/json" );
        objectMapper.writeValue( response.getWriter(), additionalFields );
        
        return null;  
    }
        
    
    @RequestMapping(value = "/student/logout.html", method = RequestMethod.GET)
    public String removeDepartmentPrograms (HttpSession session) {
        session.invalidate();
        return "redirect:/systemuser/login.html";
    }
}


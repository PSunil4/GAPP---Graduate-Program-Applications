package gapp.controller;

import gapp.model.dao.ApplicationStatusDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusDao applicationStatusDao;
    
    @RequestMapping("/applicationstatus.html")
    public String applicationstatus (ModelMap models) {
        models.put( "applicationstatus", applicationStatusDao.getListOfApplicationStatus());
        return "applicationstatus";
    }
}

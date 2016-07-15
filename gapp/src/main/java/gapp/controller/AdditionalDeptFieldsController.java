package gapp.controller;

import gapp.model.dao.AdditionalDeptFieldDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdditionalDeptFieldsController {

    @Autowired
    private AdditionalDeptFieldDao additionalDeptFieldDao;
    
    @RequestMapping("/additionaldeptfield.html")
    public String additionalFields (ModelMap models) {
        return "additionaldeptfield";
    }
    
    @RequestMapping(value = "/administrator/removeadditionaldeptfields.html", method = RequestMethod.GET)
    public String removeAdditionalDeptFields (ModelMap models, @RequestParam Integer addFieldsId, @RequestParam Integer deptId) {
        
        additionalDeptFieldDao.removeAdditionalFields( additionalDeptFieldDao.additionalFields( addFieldsId ) );
        return "redirect:/administrator/editadditionalinformation.html?deptId="+deptId+"";
    }
    
}
package gapp.model.dao;

import gapp.model.Application;
import gapp.model.EducationalBackground;

import java.util.List;


public interface EducationalBackgroundDao {
    
    List<EducationalBackground> getEduBackgroundByAppId(Application application);
    
    EducationalBackground saveEducationalBackground(EducationalBackground eduBackground);
    
    void removeEducationalBackground (EducationalBackground educationalBackground);

}

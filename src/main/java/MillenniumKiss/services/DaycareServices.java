package MillenniumKiss.services;

import java.util.List;

import MillenniumKiss.entity.DayCare;

public interface DaycareServices {
	 // Save Daycare Student
    DayCare saveDaycare(DayCare dayCare);
    
   

    // Get All Daycare Students
    List<DayCare> getAllDaycare();

    // Get Daycare Student By Id
    DayCare getDaycareById(Long id);
    
    // Get All Daycare Students
    List<DayCare> getByBranch(String branch);

    // Update Daycare Student
    DayCare updateDaycare(Long id, DayCare dayCare);

    // Delete Daycare Student
    void deleteDaycare(Long id);
}

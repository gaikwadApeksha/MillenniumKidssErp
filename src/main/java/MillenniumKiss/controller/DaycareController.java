package MillenniumKiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MillenniumKiss.entity.DayCare;
import MillenniumKiss.services.DaycareServices;

@RestController
@RequestMapping("/api/daycare")
//@CrossOrigin(origins = "http://localhost:5173")
public class DaycareController {
	
	   @Autowired
	    private DaycareServices daycareServices;

	    // Save Daycare Student
	    @PostMapping("/save")
	    public DayCare saveDaycareStudent(@RequestBody DayCare dayCare) {
	        return daycareServices.saveDaycare(dayCare);
	    }

	    @GetMapping("/branch/{branch}")
	    public List<DayCare> getByBranch(@PathVariable String branch) {
	        return daycareServices.getByBranch(branch);
	    }
	    
	    // Get All Daycare Students
	    @GetMapping("/all")
	    public List<DayCare> getAllDaycareStudents() {
	        return daycareServices.getAllDaycare();
	    }

	    // Get Student By Id
	    @GetMapping("/{id}")
	    public DayCare getDaycareStudentById(@PathVariable Long id) {
	        return daycareServices.getDaycareById(id);
	    }

	    // Update Student
	    @PutMapping("/update/{id}")
	    public DayCare updateDaycareStudent(@PathVariable Long id,
	                                        @RequestBody DayCare dayCare) {
	        return daycareServices.updateDaycare(id, dayCare);
	    }

	    // Delete Student
	    @DeleteMapping("/delete/{id}")
	    public String deleteDaycareStudent(@PathVariable Long id) {
	        daycareServices.deleteDaycare(id);
	        return "Daycare student deleted successfully.";
	    }
}

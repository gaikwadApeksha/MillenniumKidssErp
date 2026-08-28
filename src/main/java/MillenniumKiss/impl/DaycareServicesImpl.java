package MillenniumKiss.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MillenniumKiss.entity.DayCare;
import MillenniumKiss.repository.DaycareRepository;
import MillenniumKiss.services.DaycareServices;
@Service
public class DaycareServicesImpl implements DaycareServices{
	
	 @Autowired
	    private DaycareRepository daycareRepository;

	    // Save Daycare Student
	    @Override
	    public DayCare saveDaycare(DayCare dayCare) {

	        String lastAdmissionNo = daycareRepository.findLastAdmissionNo();

	        String newAdmissionNo;

	        if (lastAdmissionNo == null) {
	            newAdmissionNo = "DK0001";
	        } else {
	            int number = Integer.parseInt(lastAdmissionNo.substring(2));
	            newAdmissionNo = String.format("DK%04d", number + 1);
	        }

	        dayCare.setAdmissionNo(newAdmissionNo);

	        return daycareRepository.save(dayCare);
	    }
	    
	    // Get Daycare Student By Id
	    @Override
	    public List<DayCare> getByBranch(String branch) {
	        return daycareRepository.findByBranch(branch);
	    }

	    // Get All Daycare Students
	    @Override
	    public List<DayCare> getAllDaycare() {
	        return daycareRepository.findAll();
	    }

	    // Get Daycare Student By Id
	    @Override
	    public DayCare getDaycareById (Long id) {
	        return daycareRepository.findById(id).orElse(null);
	    }

	    // Update Daycare Student
	    @Override
	    public DayCare updateDaycare(Long id, DayCare dayCare) {

	        DayCare existingDayCare = daycareRepository.findById(id).orElse(null);

	        if (existingDayCare != null) {

	            // Admission No should NOT be changed during update
	            existingDayCare.setStudentName(dayCare.getStudentName());
	            existingDayCare.setBranch(dayCare.getBranch());
	            existingDayCare.setParentName(dayCare.getParentName());
	            existingDayCare.setEmployeeId(dayCare.getEmployeeId());
	            existingDayCare.setMobileNo(dayCare.getMobileNo());
	            existingDayCare.setAlternateNo(dayCare.getAlternateNo());
	            existingDayCare.setDaycareType(dayCare.getDaycareType());
	            existingDayCare.setJoiningDate(dayCare.getJoiningDate());
//	            existingDayCare.setPickupTime(dayCare.getPickupTime());
	            existingDayCare.setTotalFees(dayCare.getTotalFees());
	            existingDayCare.setFromTime(dayCare.getFromTime());
	            existingDayCare.setToTime(dayCare.getToTime());
	            existingDayCare.setTotalHours(dayCare.getTotalHours());
	            
	            return daycareRepository.save(existingDayCare);
	        }

	        return null;
	    }

	    // Delete Daycare Student
	    @Override
	    public void deleteDaycare(Long id) {
	        daycareRepository.deleteById(id);
	    }
	

}

package MillenniumKiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MillenniumKiss.entity.Branch;
import MillenniumKiss.repository.BranchRepository;

@RestController
@RequestMapping("/api/branches")
//@CrossOrigin(origins = "http://localhost:5173")
public class BranchController {
	@Autowired
    private BranchRepository branchRepository;

    @GetMapping("/all")
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}

package com.company.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.company.student.entity.StudentEntity;
import com.company.student.repo.StudentRepo;

@RestController
public class StudentController {
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	@Autowired
	StudentRepo sRepo;

	@Autowired
	StudentEntity se;

	@RequestMapping(value = "/setStudent", method = RequestMethod.POST)
	public String setStudent(@RequestBody StudentEntity stEnty) {
		sRepo.save(stEnty);
		return stEnty.toString();

	}

	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentEntity> getAllStudents() {
		return sRepo.findAll();
	}

	@RequestMapping(value = "/getStudent/{sId}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<StudentEntity> getStudById(@PathVariable int sId) {
		if (sRepo.existsById(sId)) {
		return sRepo.findById(sId);
		}
		else
			return null;
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@RequestParam int sId, @RequestHeader boolean auth) {
		if (sRepo.existsById(sId)) {
		sRepo.deleteById(sId);
		return "Deleted Student with id: " + sId;
		}
		else 
			return "Enter a valid student Id!";
		
	
	}

	
	@RequestMapping(value = "/UpdateStudent/{sId}", method = RequestMethod.PUT)
	@ResponseBody
	public StudentEntity UpdateEmpData(@PathVariable  int sId,
			@RequestParam(required = false, defaultValue = "HERO") String sName, @RequestParam @Valid String sNewSubject) {
		if (sRepo.existsById(sId)) {
			se.setsId(sId);
			se.setsName(sName);
			se.setsSubject(sNewSubject);

			sRepo.save(se);
			return se;
		}

		else 
			return null;
	}

}

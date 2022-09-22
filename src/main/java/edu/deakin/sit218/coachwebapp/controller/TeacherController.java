package edu.deakin.sit218.coachwebapp.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.coachwebapp.dao.ExamDAO;
import edu.deakin.sit218.coachwebapp.dao.ExamDAOImpl;
import edu.deakin.sit218.coachwebapp.entity.Exam;

@Controller
@RequestMapping("/workout")
public class TeacherController {

	@RequestMapping("/examForm")
	public String workout(
			@Valid @ModelAttribute("exam") Exam exam, 
			BindingResult validationErrors, Model model) {
		//Input validation
		if (validationErrors.hasErrors())
			return "exam-form";

		//Retrieve Client object from database
		
		//Check whether the client doesn't exist
		ExamDAO dao = new ExamDAOImpl(); 
		if (!dao.existsExam(exam)) 
			dao.insertExam(exam); //If not, save it
		//This client object is identical to a row in the database
		exam = dao.retrieveExam(exam);

		//Logic when there is no error
		
		//Sync Client object with database
		dao.updateExam(exam);
		
		//Return the View 
		return "workout";
	}
	
}

package edu.deakin.sit218.coachwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.coachwebapp.entity.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		//Create a client object
		Exam exam = new Exam();
		
		//add client object to model
		model.addAttribute("exam", exam);
		
		return "exam-form";
	}
	
}


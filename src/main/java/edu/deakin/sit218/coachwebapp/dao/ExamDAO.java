package edu.deakin.sit218.coachwebapp.dao;

import edu.deakin.sit218.coachwebapp.entity.Exam;

public interface ExamDAO {
	
	public void updateExam(Exam exam);

	public void insertExam(Exam exam);

	public Exam retrieveExam(Exam exam);

	public boolean existsExam(Exam exam);
	
}

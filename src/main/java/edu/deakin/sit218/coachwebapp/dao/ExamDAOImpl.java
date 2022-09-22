package edu.deakin.sit218.coachwebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.coachwebapp.entity.Exam;


public class ExamDAOImpl implements ExamDAO{
	
	SessionFactory factory;

	public ExamDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Exam.class)
				.buildSessionFactory();
	}
	
	
	public void updateExam(Exam exam) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(exam);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	public void insertExam(Exam exam) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(exam);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	/* 
	 * If the client exists in the database, this method returns
	 * the persistent client. Otherwise, it inserts a new client
	 * with the name and age provided as an argument. 
	 */
	public Exam retrieveExam(Exam exam) {
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			String hql = "from Exam where area = '"+
					exam.getArea()+"' and question = '"+
					exam.getQuestion()+"'";
			Query<Exam> query = session.createQuery(hql);
			//Obtain the query results
			List<Exam> exams = query.getResultList();
			if (exams.isEmpty()) {
				throw new RuntimeException("There is no client: "+ exam.toString());
			}
			else if (exams.size() > 1) { 
				throw new RuntimeException("More than one client: "
						+ exam.toString() +" exists");
			}
			else {
				return exams.get(0);
			}
		}
		finally {
			session.close();
		}
	}

	/* 
	 * If the client exists in the database, this method returns
	 * the persistent client. Otherwise, it inserts a new client
	 * with the name and age provided as an argument. 
	 */
	public boolean existsExam(Exam exam) {
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Exam where area = '"+
					exam.getArea()+"' and question = '"+
					exam.getQuestion() + "' and answer = '" +
					exam.getAnswer()+"'";
			Query<Exam> query = session.createQuery(hql);
			//Obtain the query results
			List<Exam> exams = query.getResultList();
			return !exams.isEmpty();
		}
		finally {
			session.close();
		}
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		//Close session factory before destroying the object
		factory.close();
	}
	
}

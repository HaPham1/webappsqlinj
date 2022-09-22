package edu.deakin.sit218.coachwebapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.coachwebapp.entity.Exam;
import java.util.Scanner; 

public class TestJDBC {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost/questionschema?" +
                "user=teacher&password=teacher";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			conn.close();
			System.out.println("Connection successful!");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Exam.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			//Get input
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter area: ");
			String area = myObj.nextLine();
			
			
			//create the query
			String hql = "from Exam where area = '"+
					area + "'";
			Query<Exam> query = session.createQuery(hql);
			//Obtain the query results
			List<Exam> exams = query.getResultList();
			if (exams.isEmpty()) {
				throw new RuntimeException("There is no exam about this area");
			}
			else {
				for(int i=0; i < exams.size();i++){
				    System.out.println(exams.get(i));
				} 
			}
			
		}
		finally {
			//close session and factory
			session.close();
			factory.close();
		}

	}

}	
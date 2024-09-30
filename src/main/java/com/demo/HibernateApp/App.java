package com.demo.HibernateApp;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.HibernateApp.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Step 1. Creating a configuration object
    			Configuration cfg = new Configuration();

    			// Step2. configure hibernate.cfg.xml file to Configuration object
    			cfg.configure("resources/hibernate.cfg.xml");

    			// Step3. Create SessionFactory Object
    			SessionFactory sessionFactory = cfg.buildSessionFactory();

    			// Step4. Get the Session Object from SessionFactory
    			Session session = sessionFactory.openSession();

    			// Step5. Begin the Transaction within a session
    			Transaction transaction = session.beginTransaction();

    			Employee employee = new Employee();
    			employee.setEmpId(1000);
    			employee.setEmpName("Ab");
    			employee.setEmpSalary(45000);

    			// Step6. Perform operations
    			Serializable object = (Serializable) session.save(employee);
    			System.out.println(object);

    			// Step7. Performing Transaction operations
    			transaction.commit();

    			// Step8. Close the session
    			session.close();


    }
}
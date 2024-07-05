package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.config.HibernateConfiguration;
import com.entity.Employee;

public class EmployeeDao {
	public void getEmployees() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		transaction.commit();
	}

	public boolean addEmployee(Employee e) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		openSession.save(e);
		transaction.commit();
		return true;
	}

	public void sumOfSalary() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("Salary"));
		List list = criteria.list();
		System.out.println("Sum OF Salary : " + list);

		transaction.commit();

	}

	public void maxSalaryTestProfile() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("profile", "test"));
		criteria.setProjection(Projections.max("Salary"));
		List list = criteria.list();
		System.out.println("Max Salary Test Profile : " + list);

		transaction.commit();

	}

	public void avgExperience() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("experience"));
		List list = criteria.list();
		System.out.println("Average Experience level  : " + list);

		transaction.commit();

	}

	public void getHighestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("Salary"));
		Double maxSalary2 = (Double) criteria.uniqueResult();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("Salary", maxSalary2));
		List<Employee> employeesWithMaxSalary = employeeCriteria.list();

		for (Employee employee : employeesWithMaxSalary) {
			System.out.println(employee);
		}

		transaction.commit();

	}

	public void getLowestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.min("Salary"));
		Double minSalary = (Double) criteria.uniqueResult();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("Salary", minSalary));
		List<Employee> employeesWithMaxSalary = employeeCriteria.list();

		for (Employee employee : employeesWithMaxSalary) {
			System.out.println(employee.getEname() + "  " + employee.getExperience());
		}

		transaction.commit();

	}

	public void getCountOfEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.count("id"));
		List list = criteria.list();
		System.out.println("Count of Employees  : " + list);

		transaction.commit();
	}

	public void getTestSalaryHavingMoreThanTwentyFiveK() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.gt("Salary", 25000.00));
		List<Employee> employeesWithMaxSalary = employeeCriteria.list();

		for (Employee employee : employeesWithMaxSalary) {
			if ("test".equals(employee.getProfile())) {
				System.out.println(employee);
			}
		}

	}

	public boolean updateEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ename", "radha"));
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			employee.setProfile("support");
			openSession.update(employee);
		}

		transaction.commit();

		return true;

	}

	public void getSecondHighestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("Salary"));
		Double maxSalary = (Double) criteria.uniqueResult();

		Criteria secondHighestCriteria = openSession.createCriteria(Employee.class);
		secondHighestCriteria.add(Restrictions.lt("Salary", maxSalary));
		secondHighestCriteria.setProjection(Projections.max("Salary"));
		Double secondMaxSalary = (Double) secondHighestCriteria.uniqueResult();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("Salary", secondMaxSalary));

		List<Employee> employees = employeeCriteria.list();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		transaction.commit();

		openSession.close();
	}

	public void getSecondLowestPaidEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.min("Salary"));
		Double minSalary = (Double) criteria.uniqueResult();

		Criteria secondLowestCriteria = openSession.createCriteria(Employee.class);
		secondLowestCriteria.add(Restrictions.gt("Salary", minSalary));
		secondLowestCriteria.setProjection(Projections.min("Salary"));
		Double secondMinSalary = (Double) secondLowestCriteria.uniqueResult();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("Salary", secondMinSalary));

		List<Employee> employees = employeeCriteria.list();

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		transaction.commit();

		openSession.close();

	}

	public void getAvgSalaryDevProfile() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("profile", "dev"));
		List<Employee> employeesWithMaxSalary = employeeCriteria.list();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("Salary"));
		List list = criteria.list();
		System.out.println("Average Salary Dev Profile : " + list);

		transaction.commit();

	}

	public void getLowestExperience() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		criteria.setProjection(Projections.min("experience"));
		int lowestExp = (int) criteria.uniqueResult();

		Criteria employeeCriteria = openSession.createCriteria(Employee.class);
		employeeCriteria.add(Restrictions.eq("experience", lowestExp));
		List<Employee> list = employeeCriteria.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

	public void getEmployeeWithLowestAgeAndMaxSalary() {

		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Criteria maxSalaryCriteria = session.createCriteria(Employee.class);
		maxSalaryCriteria.setProjection(Projections.max("Salary"));
		Double maxSalary = (Double) maxSalaryCriteria.uniqueResult();

		Criteria employeesWithMaxSalaryCriteria = session.createCriteria(Employee.class);
		employeesWithMaxSalaryCriteria.add(Restrictions.eq("Salary", maxSalary));
		List<Employee> employeesWithMaxSalary = employeesWithMaxSalaryCriteria.list();

		Employee employeeWithLowestAge = null;
		for (Employee employee : employeesWithMaxSalary) {
			
				employeeWithLowestAge = employee;
		
		}

		System.out.println(employeeWithLowestAge);

		transaction.commit();

		session.close();

	}

	public boolean removeAllEmployee() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();

		Criteria criteria = openSession.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			openSession.remove(employee);
		}
		transaction.commit();
		return true;
	}

}

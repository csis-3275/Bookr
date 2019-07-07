package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.User;
/**
 * Class Implemented UserDAO
 * @author Gahyun Lee 300289068
 *
 */
public class UserDAOImpl implements UserDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer createUser(User user) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer userId = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userId = (Integer) session.save(user);
			transaction.commit();

		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(ex.getMessage());
		} finally {
			session.close();
			sessionFactory.close();
		}
		return userId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateUser(User user) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.update(user);

			transaction.commit();

		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(ex.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteUser(User user) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.delete(user);

			transaction.commit();

		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(ex.getMessage());
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User readUser(Integer userId) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		User readUser = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			readUser = session.get(User.class, userId);

			transaction.commit();

		} catch (HibernateException ex) {
			System.err.println(ex.getMessage());
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		return readUser;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<User> readAllUser() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		ArrayList<User> userList = null;
		String query = "FROM User";
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userList = (ArrayList<User>) session.createQuery(query).list();

			transaction.commit();

		} catch (HibernateException ex) {
			System.err.println(ex.getMessage());
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		return userList;	
	}

}

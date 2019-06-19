package com.csis3275.Boundary;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.User;

public class UserDAOImpl implements UserDAO {

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
			System.err.println(ex);
			return false;
		} finally {
			session.close();
			sessionFactory.close();
		}
		return true;
	}

}

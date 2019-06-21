package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.BookingTransaction;

public class BookingTransactionDAOImpl implements BookingTransactionDAO {

	@Override
	public Integer createTransaction(BookingTransaction bTransaction) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer bTransId = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			bTransId = (Integer) session.save(bTransaction);
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
		return bTransId;
	}

	@Override
	public boolean updateTransaction(BookingTransaction bTransaction) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.update(bTransaction);

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

	@Override
	public BookingTransaction readTransaction(Integer bTransactionId) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		BookingTransaction bTransaction = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.get(BookingTransaction.class, bTransactionId);
			transaction.commit();
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		return bTransaction;
	}

	@Override
	public boolean deleteTransaction(BookingTransaction bTransaction) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
		}catch(HibernateException hx) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(hx.getMessage());
			return false;
		}finally {
			session.close();
			sessionFactory.close();
		}
		return true;
	}
	

	@Override
	public ArrayList<BookingTransaction> readAllTransactions() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction  = null;
		ArrayList<BookingTransaction> bTransList = null;
		String query = "FROM BookingTransaction";
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			bTransList = (ArrayList<BookingTransaction>) session.createQuery(query).list();
			
			transaction.commit();
			
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		return null;
	}

}

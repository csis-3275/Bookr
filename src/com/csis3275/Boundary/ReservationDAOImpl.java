package com.csis3275.Boundary;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.Reservation;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public Integer createReservation(Reservation reservation) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer reserveId = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			reserveId = (Integer) session.save(reservation);
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
		return reserveId;
	}

	@Override
	public boolean updateReservation(Reservation reservation) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.update(reservation);

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

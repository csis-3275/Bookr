package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.Reservation;
/**
 * Class Implemented ReservationDAO
 * @author Gahyun Lee 300289068
 *
 */
public class ReservationDAOImpl implements ReservationDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer createReservation(Reservation reservation) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer reserveNum = null;
		
//		LocalDate today = LocalDate.now();
//		int date = today.getDayOfMonth();
//		int month = today.getMonthValue();
//		int year = today.getYear();
//		
//		instanceCounter++;
//		counter = instanceCounter;
//		_reservation_number = "RS" + year + month+date + counter;
//		

		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			reserveNum = (Integer) session.save(reservation);
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
		return reserveNum;
	}

	/**
	 * {@inheritDoc}
	 */
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
	public Reservation readReservation(Integer reservationId) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Reservation readReserv = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			readReserv = session.get(Reservation.class, reservationId);
			
			transaction.commit();
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		return readReserv;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Reservation> readAllReservations() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		String query = "FROM Reservation";
		ArrayList<Reservation> reservList= null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			reservList = (ArrayList<Reservation>) session.createQuery(query).list();
			
			transaction.commit();
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		return reservList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteReservation(Reservation reservation) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			String hql = "DELETE FROM Reservation WHERE res_number = : resNum";
			session.createQuery(hql)
			.setParameter("resNum", reservation.get_reservation_number())
			.executeUpdate();
			
			transaction.commit();
			
		}catch(HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(ex.getMessage());
			return false;
		}finally {
			session.close();
			sessionFactory.close();
		}
		return true;
	}

}

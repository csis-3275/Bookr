package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.Room;
/**
 * Class Implemented RoomDAO
 * @author Gahyun Lee 300289068
 *
 */
public class RoomDAOImpl implements RoomDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer createRoom(Room room) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer roomId = null;
		
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(room);
			transaction .commit();
			
		}catch(HibernateException hx) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		return roomId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateRoom(Room room) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.update(room);
			transaction .commit();
			
		}catch(HibernateException hx) {
			if(transaction != null) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Room readRoom(Integer roomId) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Room readRoom = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			readRoom = session.get(Room.class, roomId);
			transaction.commit();
			
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally{
			session.close();
			sessionFactory.close();
		}
		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Room> readAllRooms() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		ArrayList<Room> roomList = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String query = "FROM Room";
			
			roomList = (ArrayList<Room>) session.createQuery(query).list();
			
			transaction.commit();
			
		}catch(HibernateException hx) {
			System.err.println(hx.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
		return roomList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteRoom(Room room) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = FactoryGenerator.getFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.delete(room);
			
			transaction.commit();
			
		}catch(HibernateException hx) {
			if(transaction != null) {
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

}

package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.BookingTransaction;
import com.csis3275.Entities.Room;
/**
 * Interface of BookingTransactionDAO
 * @author Gahyun Lee 300289068
 *
 */
public interface BookingTransactionDAO {

	/**
	 * A method creating new transaction and return its ID
	 * @param bTransaction
	 * @return transactionID
	 */
	public Integer createTransaction(BookingTransaction bTransaction);
	
	/**
	 * A method update transaction info and return if it was successful 
	 * @param bTransaction
	 * @return updated(boolean)
	 */
	public boolean updateTransaction(BookingTransaction bTransaction);
	
	/**
	 * A method read transaction using transactionId and return BookingTransaction
	 * @param bTransactionId
	 * @return bookingTransaction
	 */
	public BookingTransaction readTransaction(Integer bTransactionId);
	
	/**
	 * A method deleting a specified transaction.
	 * @param bTransaction
	 * @return deleted(boolean)
	 */
	public boolean deleteTransaction(BookingTransaction bTransaction);
	
	/**
	 * A method getting list of all the transactions
	 * @return bookingTransactionList
	 */
	public ArrayList<BookingTransaction> readAllTransactions();
	
}

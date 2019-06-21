package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.BookingTransaction;
import com.csis3275.Entities.Room;

public interface BookingTransactionDAO {

	public Integer createTransaction(BookingTransaction bTransaction);
	public boolean updateTransaction(BookingTransaction bTransaction);
	public BookingTransaction readTransaction(Integer bTransactionId);
	public boolean deleteTransaction(BookingTransaction bTransaction);
	public ArrayList<BookingTransaction> readAllTransactions();
	
}

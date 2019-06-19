package com.csis3275.Boundary;

import com.csis3275.Entities.BookingTransaction;

public interface BookingTransactionDAO {

	public Integer createTransaction(BookingTransaction bTransaction);
	public boolean updateTransaction(BookingTransaction bTransaction);
}

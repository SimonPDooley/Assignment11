package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactions;
	
	public List<Transaction> findAllAndSortByDate() {
		List<Transaction> allTransactions = transactions.findAll();
		
		Collections.sort(allTransactions, (c1, c2) -> { if(c1.getDate()
				   .isBefore(c2.getDate())) return -1; else return 1; });

		return allTransactions;
	}

	public Transaction findById(long id) {
		return transactions.findById(id);		
	}
}

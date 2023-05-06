package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.repositories.TransactionsRepository;

@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {
	@Autowired
	private TransactionsRepository transactionsrepo;

	@Autowired
	private ModelMapper mapper;
}

package com.inetum.appliSpringjpa.dao;

import java.util.List;

import com.inetum.appliSpringjpa.entity.Operation;

/**
 * 
 * DAO = Data Access Object
 * avec methode CRUD
 *
 */

public interface DaoOperation {
	Operation findById(Long idOp);
	List<Operation> findAll();
	Operation insert(Operation op);
	void update(Operation emp);
	void deleteById(Long idOp);
	
}

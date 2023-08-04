package com.inetum.appliSpringjpa.dao;

import java.util.List;


public interface DaoGeneric<E,PK> {

	E findById(PK id);
	List<E> findAll();
	E insert(E e);
	void update(E e);
	void deleteById(PK num);
			
}

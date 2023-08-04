package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.exception.NotFoundException;

public interface GenericService<E,ID,DTO> {
 
		public E searchById(ID id);
		public DTO searchDtoById(ID id) throws NotFoundException;
		public E saveOrUpdate(E entity);
				
		public void deleteById(ID id) throws NotFoundException;
	    
	    public boolean existById(ID id);
	    void shouldExistById(ID id) throws NotFoundException;
		public List<E> searchAll();
		public List<DTO> searchAllDTO();
		
		
}

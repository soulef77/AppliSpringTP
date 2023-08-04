

package com.inetum.appliSpringjpa.dao;

import com.inetum.appliSpringjpa.entity.Client;

public interface DaoClient extends DaoGeneric<Client, Long>{

	Client findClientWithCompteById(Long numero);
		
}

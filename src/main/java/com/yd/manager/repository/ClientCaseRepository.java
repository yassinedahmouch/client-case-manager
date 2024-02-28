package com.yd.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yd.manager.model.ClientCase;
@Repository
public interface ClientCaseRepository extends CrudRepository<ClientCase, Long> {
	
	@Override
	List<ClientCase> findAll();

	ClientCase findByClientCaseId(Long clientCaseId);

}

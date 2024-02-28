package com.yd.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yd.manager.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

	@Override
	List<Message> findAll();
	
	Message findByMessageId(Long messageId);
	
	List<Message> findAllByCreator(String creator);
}

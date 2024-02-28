package com.yd.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yd.manager.dto.client.ClientCaseRequest;
import com.yd.manager.dto.client.ClientCaseRequestForUpdate;
import com.yd.manager.model.ClientCase;
import com.yd.manager.model.Message;
import com.yd.manager.repository.ClientCaseRepository;
import com.yd.manager.repository.MessageRepository;

@Service
public class ClientCaseService {

	@Autowired
	private ClientCaseRepository clientCaseRepository;
	
	@Autowired
    private MessageRepository messageRepository;
	
	public List<ClientCase> getAllClientCases() {
		return clientCaseRepository.findAll();
	}

	public ClientCase getClientCaseById(Long id) {
		return clientCaseRepository.findById(id).orElse(null);
	}

	public ClientCase createClientCase(ClientCaseRequest clientCaseRequest) {
		ClientCase clientCase  = ClientCase.builder()
										   .clientName(clientCaseRequest.getClientName())
										   .clientReference(clientCaseRequest.getClientReference())
										   .messages(clientCaseRequest.getMessages())
										   .build();
		List<Message> messagesLinkedToCase = messageRepository.findAllByCreator(clientCaseRequest.getClientName());
		
		List<Message> existingMessages = clientCase.getMessages() != null ? clientCase.getMessages() : new ArrayList<>();
		for (Message message : messagesLinkedToCase) {
			existingMessages.add(message);
			message.setClientCase(clientCase);
		}
		
		clientCase.setMessages(existingMessages);

		return clientCaseRepository.save(clientCase);
	}

	public ClientCase updateClientCase(Long clientCaseId, ClientCaseRequestForUpdate clientCaseRequest) {
		ClientCase existingClientCase = clientCaseRepository.findByClientCaseId(clientCaseId);

		existingClientCase.setClientReference(clientCaseRequest.getClientReference());

		Long messageId = clientCaseRequest.getMessageId();
		if(messageId != null) {
			List<Message> existingMessage = existingClientCase.getMessages();
			Message messageToAddFromDb = messageRepository.findByMessageId(messageId);
			existingMessage.add(messageToAddFromDb);
			
			existingClientCase.setMessages(existingMessage);
			messageToAddFromDb.setClientCase(existingClientCase);			
		}

		return clientCaseRepository.save(existingClientCase);
	}
}

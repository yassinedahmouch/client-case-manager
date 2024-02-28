package com.yd.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yd.manager.dto.message.MessageRequest;
import com.yd.manager.model.Message;
import com.yd.manager.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
    private MessageRepository messageRepository;
	
	public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message createMessage(MessageRequest messageRequest) {
        return messageRepository.save(Message.builder().creator(messageRequest.getCreator())
        											   .content(messageRequest.getContent())
        											   .build());
    }

    public Message updateMessage(Long messageId, String content) {
    	Message existingMessage = messageRepository.findByMessageId(messageId);
    	existingMessage.setContent(content);
        return messageRepository.save(existingMessage);
    }
}

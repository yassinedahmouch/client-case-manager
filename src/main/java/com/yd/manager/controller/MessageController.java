package com.yd.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yd.manager.dto.message.MessageRequest;
import com.yd.manager.model.Message;
import com.yd.manager.service.MessageService;

@RestController
@RequestMapping(value="/messages")
public class MessageController {
	
	@Autowired
    private MessageService messageService;

	@GetMapping
	public ResponseEntity<List<Message>> getAllMessages() {
		List<Message> messages = messageService.getAllMessages();

		if (messages != null && !messages.isEmpty()) {
			return ResponseEntity.ok(messages);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

    @GetMapping("/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
		Message message = messageService.getMessageById(id);

		if (message != null) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody MessageRequest messageRequest) {
        Message message =  messageService.createMessage(messageRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/{messageId}")
	public ResponseEntity<Message> updateMessage(@PathVariable Long messageId,
											     @RequestParam String content) {
		Message message = messageService.updateMessage(messageId, content);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
}

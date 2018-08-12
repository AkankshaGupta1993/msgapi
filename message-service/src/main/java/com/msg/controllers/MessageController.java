package com.msg.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.entity.Message;

@RestController
@RequestMapping(path = "/messages")
public class MessageController {

	private static List<Message> messages = new ArrayList<>();
	private static Long count = 1L;
	
	@PostMapping(path = "/")
	public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
		message.setMessageId(count++);
		messages.add(message);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@PutMapping(path = "/{messageId}")
	public ResponseEntity<Message> updateMessage(@RequestBody Message message,
			@PathVariable(name ="messageId" ) Long messageId) {
		Message retMsg = null;	
		for (Message val: messages) {
				if (val.getMessageId().equals(messageId)) {
					retMsg = val;
					break;
				}
		}
		if (retMsg != null) {
			retMsg.setMessageBody(message.getMessageBody());
		}
		return ResponseEntity.status(HttpStatus.OK).body(retMsg);
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Message>> getMessages() {
		return ResponseEntity.status(HttpStatus.OK).body(messages);//messages;
	}
	
	
	@GetMapping(path = "/{messageId}")
	public ResponseEntity<Message> getMessage(@PathVariable(name ="messageId" ) Long messageId ) {
		Message retMsg = null;	
		for (Message message: messages) {
				if (message.getMessageId().equals(messageId)) {
					retMsg = message;
					break;
				}
			}
		HttpStatus status = null;
		if (retMsg != null) {
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		
		return ResponseEntity.status(status).body(retMsg);
	}
	
	@DeleteMapping(path = "/{messageId}")
	public ResponseEntity<String> removeMessage(@PathVariable(name ="messageId" ) Long messageId) {
		/*Message retMsg = null;	
		for (Message val: messages) {
				if (val.getMessageId().equals(messageId)) {
					retMsg = val;
					break;
				}
		}
		if (retMsg != null) {
			messages.remove(retMsg);
		}*/
		
		Iterator<Message> iterator = messages.iterator();
		while (iterator.hasNext()) {
			Message message = iterator.next();
			if (message.getMessageId().equals(messageId)) {
				iterator.remove();
				break;
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

}
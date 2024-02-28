package com.yd.manager.dto.client;

import java.util.List;

import com.yd.manager.model.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientCaseRequest {

	private String clientName;
	private String clientReference;
    private List<Message> messages;
}

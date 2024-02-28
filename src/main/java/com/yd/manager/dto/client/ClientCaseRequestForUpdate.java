package com.yd.manager.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientCaseRequestForUpdate {
	
	private String clientReference;
    private Long messageId;

}

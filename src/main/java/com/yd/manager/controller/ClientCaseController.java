package com.yd.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yd.manager.dto.client.ClientCaseRequest;
import com.yd.manager.dto.client.ClientCaseRequestForUpdate;
import com.yd.manager.model.ClientCase;
import com.yd.manager.service.ClientCaseService;

@RestController
@RequestMapping("/client-cases")
public class ClientCaseController {

	@Autowired
    private ClientCaseService clientCaseService;

    @GetMapping
    public List<ClientCase> getAllClientCases() {
        return clientCaseService.getAllClientCases();
    }

    @GetMapping("/{id}")
    public ClientCase getClientCaseById(@PathVariable Long id) {
        return clientCaseService.getClientCaseById(id);
    }

    @PostMapping
    public ClientCase createClientCase(@RequestBody ClientCaseRequest clientCaseRequest) {
        return clientCaseService.createClientCase(clientCaseRequest);
    }

    @PutMapping("/{clientCaseId}")
    public ClientCase updateClientCase(@PathVariable Long clientCaseId, @RequestBody ClientCaseRequestForUpdate clientCaseRequest) {
        return clientCaseService.updateClientCase(clientCaseId, clientCaseRequest);
    }
}

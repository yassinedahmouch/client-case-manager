package com.yd.manager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_case")
public class ClientCase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientCaseId;
	private String clientName;
	private String clientReference;
	@JsonManagedReference
	@OneToMany(mappedBy = "clientCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages;
}

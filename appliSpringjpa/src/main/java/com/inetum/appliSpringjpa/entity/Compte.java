package com.inetum.appliSpringjpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQuery(name="Compte.findByLabel", query="select c from Compte as c where c.label= ?1") 
@NamedQuery(name="Compte.findCompteWithOperationById", query="select c from Compte c LEFT JOIN FETCH c.operations op where c.numero= ?1") 
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	private String label;
	private Double solde;
	
	/*
	@ManyToOne
	 @JoinColumn(name = "numero_client") 
	private Client client;*/
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "Compte_Client",
	 joinColumns = {@JoinColumn(name = "num_compte")},
	 inverseJoinColumns = {@JoinColumn(name = "num_client")})
	private List<Client> clients = new ArrayList<>();
			
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="compte", cascade = CascadeType.ALL)
		private List<Operation> operations;
	
	public void addOperation(Operation op) {
		if(this.operations == null) this.operations = new ArrayList<>();
		this.operations.add(op);
	}
	
	public Compte() {
		super();
	}
	
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	/*
	public Compte(Long numero, String label, Double solde, Client client) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
		this.client = client;
	}*/
	
	
	
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	public Compte(Long numero, String label, Double solde, List<Client> clients, List<Operation> operations) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
		this.clients = clients;
		this.operations = operations;
	}

	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	/*
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}*/
		
	
}

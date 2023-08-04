package com.inetum.appliSpringWeb.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NamedQuery(name = "Compte.findBySoldeMini", 
            query = "SELECT c FROM Compte c WHERE c.solde>= ?1")
@NamedQuery(name ="Compte.findByWithOperations",
			query= "SELECT c from Compte c LEFT JOIN FETCH c.operations op WHERE c.numero= ?1")
@Getter @Setter @NoArgsConstructor 
public class Compte {
	
	@Transient
	private static Double decouvertAutorise = -500.00;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	private String label;
	private Double solde;
	
	@JsonIgnore //pour demander à ignorer la liste des opérations lorsque l'objet courant de la classe cOMPTESERA AUTOMATIQUEMENT CONVERTIE DE JAVA EN JSON
 	@OneToMany(fetch=FetchType.LAZY,mappedBy="compte", cascade = CascadeType.ALL)
	private List<Operation> operations;
	
	@ManyToOne
	@JoinColumn( name ="id_customer")
	private Customer customer;
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	public static Double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public static void setDecouvertAutorise(Double decouvertAutorise) {
		Compte.decouvertAutorise = decouvertAutorise;
	}

	

	
}

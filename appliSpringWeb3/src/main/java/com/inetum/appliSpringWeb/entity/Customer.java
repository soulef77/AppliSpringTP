package com.inetum.appliSpringWeb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NamedQuery(name ="Customer.findByWithCompteByCustomerId",
query= "SELECT cus from Customer cus LEFT JOIN FETCH cus.comptes cp WHERE cus.id= ?1")
@Entity
@Setter @Getter @NoArgsConstructor
public class Customer {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	private String password;
	
	



	public Customer(Long id,String lastname,String firstname, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ "]";
	}



	
	
	@JsonIgnore //pour demander à ignorer la liste des opérations lorsque l'objet courant de la classe cOMPTESERA AUTOMATIQUEMENT CONVERTIE DE JAVA EN JSON
 	@OneToMany(fetch=FetchType.LAZY,mappedBy="customer", cascade = CascadeType.ALL)
	private List<Compte> comptes;
	
}

package tp.entity;

public class Personne {
	public  enum Nationalite{ FRANCAIS, ANGLAIS, ESPAGNOL , ITALIEN };
	
	private Integer id; //pk/id (pk= primary key)
	private String prenom;
	private String nom;
	
	//private String nationalite; //V1 avec String, V2 avec enum
	
	private Nationalite nationalite;
	
	
	
	public Personne() {
		super();
	}
	
	public Personne(Integer id, String prenom, String nom) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}
		
	@Override
	public String toString() {
		return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
/*
	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	*/

	public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}
	
	
	

}

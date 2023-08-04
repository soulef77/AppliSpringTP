package tp.personnes;

public class Employe extends Personne {

	private Integer salaire;
	private String employeur;
	
	
	public Employe() {
		super();
		this.salaire = 0;
		// TODO Auto-generated constructor stub
	}
 
	
	public Employe(String employeur) {
		super();
		this.employeur = employeur;
	}



	public Employe(String prenom, String nom, int age, Integer salaire) {
		super(prenom, nom, age);
		this.salaire = salaire;
	}
	
	
	
	
	public Employe(String prenom, String nom, int age) {
		super(prenom, nom, age);
		// TODO Auto-generated constructor stub
	}


	public Employe(String prenom, String nom, int age, Integer salaire, String employeur) {
		super(prenom, nom, age);
		this.salaire = salaire;
		this.employeur = employeur;
	}


	public Employe(Integer salaire, String employeur) {
		super();
		this.salaire = salaire;
		this.employeur = employeur;
	}


	public String getEmployeur() {
		return employeur;
	}
	
	
	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}


	public Integer getSalaire() {
		return salaire;
	}

	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", employeur=" + employeur + ", toString()=" + super.toString() + "]";
	}
	
	
}

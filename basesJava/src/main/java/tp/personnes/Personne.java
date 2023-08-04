package tp.personnes;

import tp.Transportable;

public class Personne implements Transportable {
	private String prenom;
	private String nom;
	private int age;
	public final static int AGE_MAX = 150;
	private static int ageMajorite = 18;

	private static final double  POIDS_MOYEN = 70.0;
	private static final double  VOLUME_MOYEN = 70.0;
	
	//Integer age;

	
	public Personne()  {
		super();
		this.prenom = "?";
		this.nom = "toto";
		this.age = 0;
	}
		
	public Personne(String prenom, String nom, int age) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}
		
	
	public double getVolume() {
		return VOLUME_MOYEN;
	}
	
	public double getPoids() {
		return POIDS_MOYEN;
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", age=" + age + "]";
	}

	public String majoriteAsString()  {
		//retourner je suis majeur ou  mineur
		/*if (this.age >= ageMajorite) {
			return "Je suis majeur(e)";
			
		} return "Je suis mineur(e)";*/
		
		return(this.age >= ageMajorite) ? "je suis majeur(e)" : "je suis mineur(e)";
	}

	public String getEmployeur() {
		return null;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	//fonction incrementerAge()
	public void IncrementerAge() {
		//age = this.age + 1;
		this.age++;
	}

	//nomComplet()
	//retourne la concaténation de prénom et nom
	public String nomComplet( ) {
		return "le nom complet est : " +prenom +" "+ nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int nouvel_age) {
		if(nouvel_age >= 0 && nouvel_age < AGE_MAX)  { this.age = nouvel_age;  }
		else { System.out.println("age invalide pas pris en compte dans this.age");}
	}

}

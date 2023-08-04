package tp;

import java.util.ArrayList;

import tp.bagages.Bagage;
import tp.personnes.Personne;

public class Avion {

	private String label;
	
	private ArrayList<Bagage> bagages = new ArrayList<>();
	
	private ArrayList<Personne> personnes = new ArrayList<>();
	
	
	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Avion(String label) {
		super();
		this.label = label;
	}

	public Avion(String label, ArrayList<Bagage> bagages) {
		super();
		this.label = label;
		this.bagages = bagages;
	}

	public Avion(String label, ArrayList<Bagage> bagages, ArrayList<Personne> personnes) {
		super();
		this.label = label;
		this.bagages = bagages;
		this.personnes = personnes;
	}


	public void addPersonnes(Personne p) {
		this.personnes.add(p);
	}
	
	public void retirerPersonne(Personne p) {
		this.personnes.remove(p);
	}
		
	public void addBagages(Bagage b) {
		this.bagages.add(b);
	}
	
	public void retirerBagage(Bagage b) {
		this.bagages.remove(b);
	}
	
	public double chargeUtile() {
		//calculer et retourner le poids total des éléments mis dans l'avion
		double poidsTotal = 0;
		for (Bagage b : this.bagages) {
			poidsTotal += b.getPoids();
		}
						
		for (Transportable personneTransportable : this.personnes) {
			poidsTotal += personneTransportable.getPoids();
		}
				
		return poidsTotal;
	}
	
	public void afficher() {
		System.out.println("Avion.afficher()"+ this.label);
		System.out.println("chargeUtile" +this.chargeUtile());
		System.out.println("bagages : "  );
		for (Bagage b : this.bagages) {
			//b est quelques fois de type sac et d'autres fois de type valise, on parle de polymorphisme
			System.out.println("\t" + b.toString() + " de volume= "+ b.getVolume());
			//b.toString() et b.getVolume() déclenche du polymorphisme
		}
		 System.out.println("personnes " );
		 for (Personne p : this.personnes) {
			System.out.println("\t" + p.toString() + " de nom " + p.getNom() + " de prénom "+ p.getPrenom() + "employeur = "+ p.getEmployeur());
			Transportable t = p;
			System.out.println("poids de la personne transportable = "+ t.getPoids());
			
		}
	}
		

	@Override
	public String toString() {
		return "Avion [label=" + label + ", bagages=" + bagages + ", personnes=" + personnes + "]";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}

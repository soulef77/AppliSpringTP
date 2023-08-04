package tp.bagages;

import tp.Transportable;

/**
 * 
 * @author soulef
 * Bagage est une classe abstarite représentant un babage quelconque valise ou sac
 */

public abstract class Bagage implements Transportable {

	protected String label;
	protected String couleur;
	protected double poids;
	
	public Bagage() {
	
	}
	
	
	public Bagage(String label, String couleur, double poids) {
		this.label = label;
		this.couleur = couleur;
		this.poids = poids;
	}
	
	public abstract double getVolume();


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
}

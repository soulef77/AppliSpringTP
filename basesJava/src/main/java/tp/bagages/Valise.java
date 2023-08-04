package tp.bagages;

public class Valise extends Bagage {

	private double hauteur; //en cm
	private double profondeur; // en cm
	private double largeur; // en cm
	
	public Valise() {
		super();
	}
	
	
	public Valise(String label,String couleur, double poids) {
		super(label, couleur, poids);
		this.hauteur= this.profondeur = this.largeur =20;
	}
	
	public Valise(String label, String couleur, double poids, double hauteur, double profondeur, double largeur) {
		super(label, couleur,poids);
		this.hauteur = hauteur;
		this.profondeur = profondeur;
		this.largeur= largeur;
	}
			
	@Override
	public String toString() {
		return "Valise [hauteur=" + hauteur + ", profondeur=" + profondeur + ", largeur=" + largeur + "]";
	}

	public double getVolume() {
		return (this.hauteur*this.profondeur*this.largeur)/1000;
	}
}

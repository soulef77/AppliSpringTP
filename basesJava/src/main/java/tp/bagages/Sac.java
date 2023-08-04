package tp.bagages;

public class Sac extends Bagage {

	private double volume;
	
	
	public Sac() {
		super();
	}
	
	public Sac(String label, String couleur, double poids) {
		super(label, couleur, poids);
		this.volume = 20;
	}
	
	public Sac(String label, String couleur, double poids, double volume) {
		super(label, couleur,poids);
		this.volume = volume;
	}
		
	
	@Override
	public String toString() {
		return "Sac [volume=" + volume + ", label=" + label + ", couleur=" + couleur + ", poids=" + poids + "]";
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public double getVolume() {
		return volume;
	}
	
}

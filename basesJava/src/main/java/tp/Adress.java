package tp;

public class Adress {
	private Integer num;
	private String rue;
	private Integer codePostal;
	private String ville;
	
	
	
	
	
	public Adress() {
		super();
	}


	public Adress(Integer num, String rue, Integer codePostal, String ville) {
		super();
		this.num = num;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	public Integer getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adress [num=" + num + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	
	
	
	
	
	
}
 /* get set constructeur toString() tester ça depuis MyApp */
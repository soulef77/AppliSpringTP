package fr.inetum.tp.entites;

public class Adresse {
	private String nomVoie;
	private String codePostale;
	private String  ville;
	private Integer id;
	
	
	
	
	public Adresse(String nomVoie, String codePostale, String ville, Integer id) {
		super();
		this.nomVoie = nomVoie;
		this.codePostale = codePostale;
		this.ville = ville;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Adresse [nomVoie=" + nomVoie + ", codePostale=" + codePostale + ", ville=" + ville + ", id=" + id + "]";
	}
	public String getNomVoie() {
		return nomVoie;
	}
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}

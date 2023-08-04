package com.inetum.mbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inetum.data.Produit;

import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;

@ManagedBean
//@ApplicationScoped
@SessionScoped
public class ProduitMBean {
	private List<Produit> produits;
	
	private String categorie=null; //categorie choisie/sélectionnée par l'utilisateur
	
	private static Map<String,List<Produit>> maCategorieProduits;
	
	private List<String> categorieSelectionnable;

	static {
		maCategorieProduits = new HashMap<String,List<Produit>>();
		var listeLivres = new ArrayList<Produit>();
		listeLivres.add(new Produit("l2", "reine", 8.76, "LIVRE"));
		listeLivres.add(new Produit("l3", "java", 8.96, "LIVRE"));
		listeLivres.add(new Produit("11", "barbie", 14.52, "LIVRE"));
		maCategorieProduits.put("LIVRE",listeLivres);
		
		
		var listeDvd = new ArrayList<Produit>();
		listeDvd.add(new Produit("dvd1", "promenade", 8.76, "DVD"));
		listeDvd.add(new Produit("dvd2", "chant d'oiseaux", 8.96, "DVD"));
		listeDvd.add(new Produit("dvd3", "miaulements de chats", 14.52, "DVD"));
		maCategorieProduits.put("DVD",listeDvd);
	}
	
	
	public String selectionnerCategorie() {
		this.produits = maCategorieProduits.get(categorie);
		return null;//rester sur même page
	}
	
	public void onSelectionnerCategorie(ValueChangeEvent event) {
		this.categorie = (String) event.getNewValue();
		this.produits = maCategorieProduits.get(categorie);
		
	}
	
	
	public ProduitMBean() {
		
		this.categorieSelectionnable = new ArrayList<String>();
		categorieSelectionnable.add("LIVRE");
		categorieSelectionnable.add("DVD");
		
		this.produits = new ArrayList<Produit>();
		
		}

	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<String> getCategorieSelectionnable() {
		return categorieSelectionnable;
	}

	public void setCategorieSelectionnable(List<String> categorieSelectionnable) {
		this.categorieSelectionnable = categorieSelectionnable;
	}

	public static Map<String,List<Produit>> getMaCategorieProduits() {
		return maCategorieProduits;
	}

	public static void setMaCategorieProduits(Map<String,List<Produit>> maCategorieProduits) {
		ProduitMBean.maCategorieProduits = maCategorieProduits;
	}
	
	
}

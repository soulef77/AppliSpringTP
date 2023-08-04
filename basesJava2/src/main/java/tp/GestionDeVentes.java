package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GestionDeVentes {

			
	List<Vente>listeVentes = new ArrayList<>();
	
	public void lireFichier(String fileName) {
	
		try (BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(fileName)))) {
			   br.readLine();
				
				String ligne= br.readLine();
				while(ligne != null) {
					String[] t = ligne.split(";");
					Vente v = new Vente(t[0], Integer.parseInt(t[1]), Long.parseLong(t[2]));
					
					this.listeVentes.add(v);
					ligne = br.readLine();
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void lireFichier2(String fileName) throws IOException, NumberFormatException {
		Scanner reader = null;
		try {
			reader = new Scanner(Paths.get(fileName));
			String ligne = reader.nextLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			String ligne = reader.nextLine();
		
			while(ligne != null) {
				String[] t = ligne.split(";");
				Vente v = new Vente(t[0], Integer.parseInt(t[1]), Long.parseLong(t[2]));
				
				this.listeVentes.add(v);
				ligne = reader.hasNextLine()? reader.nextLine():null;
			}
		reader.close();
	}
	
	
	public void afficherV1() {
		
		//TP, trier par ca croissant
		
		Collections.sort(this.listeVentes,new ComparateurDeVentes());
		
		for (Vente vente : this.listeVentes) {
			System.out.println("GestionDeVentes.afficher()"+ vente);
		}
		
		
	}
	
	public void afficherV2() {
		
		//TP, trier par ca croissant
		
		Collections.sort(this.listeVentes,(o1,o2) -> (int) (o1.getCa() - o2.getCa() ));
		
		
		Collections.sort(this.listeVentes,
				(Vente o1, Vente o2) -> { return (int) (o1.getCa() - o2.getCa()); } );
		System.out.println(" ventes par ca croissants:");
		
		for (Vente vente : this.listeVentes) {
			System.out.println("GestionDeVentes.afficher()"+ vente);
		}
		
		Collections.sort(this.listeVentes, (Vente o1, Vente o2) -> {
			return o1.getDomaine().compareToIgnoreCase(o2.getDomaine());
		});
		System.out.println("Ventes par domaines croissants:");
		for (Vente vente : this.listeVentes) {
			System.out.println("GestionDeVentes.afficher()" + vente);
		}
	}
	
	
	public void afficher() {
		System.out.println("ventes triées par ca:");
		//this.listeVentes.stream().
			//		forEach((v)-> {System.out.println("\t"+ v); } );
		/*
		this.listeVentes.stream()
							.sorted((o1,o2) -> (int) (o1.getCa() - o2.getCa() ))
							.forEach( (v)-> {System.out.println("\t" + v);} );
		*/
		
		List<Vente>listeVentesTriesParCa= 
				this.listeVentes.stream()
				.sorted((o1,o2) -> (int) (o1.getCa() - o2.getCa()))
				.collect(Collectors.toList());
		
		for (Vente vente : listeVentesTriesParCa) {
			System.out.println("\t" + vente);
		}
	}
	
	public void ecrireFichierStats(String fileNameStats) {
		int ca_total= 0;
		for (Vente vente : listeVentes) {
			ca_total+= vente.getCa();
		}
		
		Map<String, List<Vente>> mapVentesParDomaine = new HashMap<>();
		for (Vente vente : listeVentes) {
			String domaine = vente.getDomaine();
			List<Vente>	sousListe = mapVentesParDomaine.get(domaine);
			if(sousListe == null) {
				sousListe = new ArrayList<Vente>();
				mapVentesParDomaine.put(domaine, sousListe);
			}
			sousListe.add(vente);
		}
		try {
			FileOutputStream of = new FileOutputStream(fileNameStats);
			PrintStream ps = new PrintStream(of);
			
			ps.println("domaine; ca_total");
			ps.println("all;" + ca_total);
			
			for (String domaine : mapVentesParDomaine.keySet()) {
				List<Vente> souListe = mapVentesParDomaine.get(domaine);
				long sous_total_ca_par_domaine = 0;
				for (Vente vente : souListe) {
					sous_total_ca_par_domaine+= vente.getCa();
				}
				ps.printf("%s,%d\n", domaine, sous_total_ca_par_domaine);
			}
			
			ps.close(); of.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

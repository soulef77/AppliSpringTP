package tp;

import java.util.ArrayList;
import java.util.Arrays;

import tp.bagages.Bagage;
import tp.bagages.Sac;
import tp.bagages.Valise;
import tp.personnes.Employe;
import tp.personnes.Personne;

//import javax.swing.JOptionPane;

public class MyApp {
	
	public static final int TAILLE_MAX = 24;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		//test_types();
		//test_personnes();
		//test_String();
		//ExtraireMois();
		//test_Adresse();
		//test_Tableaux();
		//test_Collection();
		//test_Employe();
		//test_Bagage();
		//test_Avion();
		test_Afficheur();
		 
		 
	}
	
	public static void test_Afficheur() {
		AfficheurDialog affiche = new AfficheurDialog();
		affiche.afficher("Hello World");
		
		AfficheurInteractif afficheurInteractif = new AfficheurInteractifDialog();
		String prenom = afficheurInteractif.saisirReponse("quel est votre prénom");
		afficheurInteractif.afficher("votre prénom est :" + prenom);
		
		String age = afficheurInteractif.saisirReponse("quel est votre age ");
		afficheurInteractif.afficher("votre age " + age);
		
		
	}
	
	public static void test_Avion( ) {
		Avion a1 = new Avion();
		a1.setLabel("avion A320");
		a1.addBagages(new Sac("sac1", "rouge",12.0,15.0));
		a1.addBagages(new Valise("valise1", "bleu", 32.0,10.0,20.0,25.0));
		System.out.println("MyApp.test_Avion() " + a1.chargeUtile());
	
		
		a1.addPersonnes(new Personne("omar", "saber", 36));
		a1.afficher();
		System.out.println("MyApp.test_Avion()" +a1.toString());
		Employe personne = new Employe("ss", "ok", 56,2000, "hotesse de l'air");
		a1.addPersonnes(personne);
		System.out.println("MyApp.test_Avion()" + personne.getEmployeur());
		a1.addPersonnes(new Employe("oo", "lol", 56, 4500, null));
		a1.afficher();
		
	}
	
	
	public static void test_Bagage() {
		Bagage b = null;
		b= new Sac(" label1", "rouge",45.6,60);
		System.out.println(" toString() " + b.toString());
		System.out.println("volume sac 1 "+ b.getVolume());
				
		b = new Valise("label2", "violet", 85, 25,62,36);
		System.out.println("MyApp.test_Bagage()"+ b.toString());
		System.out.println("MyApp.test_Bagage() volume valise1 "+ b.getVolume());
		
	}
	
	public static void test_Employe() {
		Employe employe1 = new Employe();
		employe1.setNom("Louis");
		employe1.setPrenom("Hugo");
		employe1.setAge(29);
		employe1.setSalaire(2500);
		System.out.println("MyApp.test_Employe1()"+ employe1);
		
		Employe employe2 = new Employe("soulef", "saoud", 43, 2500);
		System.out.println("MyApp.test_Employe2()"+ employe2.toString());
		
		Personne p = null;
		p = new Personne("luc", "sky", 35);
		System.out.println("p= "+ p.toString());
		p.nomComplet();
		
		p=employe1;
		p.IncrementerAge();
		System.out.println(" p= "+ p.toString());
		
		//p.setSalaire(2500); // imposssible car toutes les personnes n'ont pas forcément de salaire
		if(p instanceof Employe) {
			Employe EmployepVuCommeEmploye = (Employe) p;
			EmployepVuCommeEmploye.setSalaire(2500);
		}
	}
	
	public static void test_Collection() {
		String [] tabJours = new String[7];
		tabJours[0] = "lundi";
		tabJours[1] = "mardi";
		for (int i = 0; i < 7; i++) {
			System.out.println("MyApp.test_Collection()" + tabJours[i]);
		}
	
		//Avec collection
		
		ArrayList<String> listeJours = new ArrayList<String>();
		listeJours.add("lundi");
		listeJours.add("mardi");
		
		System.out.println("MyApp.test_Collection()" + listeJours.size());
		for (int i = 0; i < listeJours.size(); i++) {
			System.out.println("MyApp.test_Collection()"+ listeJours.get(i));
		}
		
		for (String string : listeJours) {
			System.out.println("MyApp.test_Collection()" + string);
		}
		
		
	}
	
	
	public static void test_Tableaux() {
		double[] tabDouble;
		tabDouble = new double[TAILLE_MAX];
		
		for (int i = 0; i < tabDouble.length; i++) {
			tabDouble[i] = Math.sqrt(i);
			
		}
		
		for (int i = 0; i < tabDouble.length; i++) {
			System.out.println("MyApp.test_Tableaux()" +" i " + i + " résultat "+  tabDouble[i]);
			
		}
		
		for (int i = 0; i < tabDouble.length; i++) {
			System.out.println("ok pb" + tabDouble[i]);
		}
		
		System.out.println("MyApp.test_Tableaux()" + Arrays.toString(tabDouble));
	}
	
	public static void test_Adresse( ) {
		Adress a = new Adress();
		a.setVille("Meaux");
		a.setCodePostal(77100);
		a.setRue("passage de la cour");
		String adresse = a.toString();
		System.out.println(adresse);
	}
	
	
	public static void test_String() {
		//construire et afficher la grosse chaine de caractère suivante:
	//	"1,2,3,4,...,64"
		
		StringBuilder longString = new StringBuilder(64);
		int a = 0;
		for(int i=0;i<64;i++) {
			a++;
			longString.append(a);
			longString.append(",");
		}
		String longStringAffichage = longString.toString();
		System.out.println("MyApp.test_String()" + longStringAffichage);
		
	}
	
	public static void ExtraireMois() {
		String chaineDate= "16/06/2023";
		int posDuPremierSlash = chaineDate.indexOf("/");
		int posDuDernierSlash = chaineDate.lastIndexOf("/");
		String chaineMois = chaineDate.substring(posDuPremierSlash+1, posDuDernierSlash);
		System.out.println("chaineMois " + chaineMois);
		
		
	}

	public static void test_personnes() {
		Personne p1 = new Personne();
		//System.out.println("p1" + p1);
		//System.out.println(" to string " +p1.toString());

		Personne p2 = new Personne();
		//p2.nom = "jean";
		//		p2.prenom = " louis";
		p2.setPrenom("yousra");
		//p2.age = 25;
		p2.setAge(25);
		p2.IncrementerAge();		
		String resultNom = p2.nomComplet();
		System.out.println("p2 " +"  "+ resultNom);
		System.out.println("p2 "+ p2.toString());
		System.out.println("MyApp.test_personnes()"+ p2.majoriteAsString());
		
		ArrayList<Personne> personne = new ArrayList<Personne>();
		personne.add(p1); personne.add(p2);
		
		for (Personne personne2 : personne) {
			System.out.println("MyApp.test_personnes()"+ personne2);
		}
	}

	public static void test_types() {
		int a=5;
		System.out.println("a="+a);
		String s1="15", s2="3";
		//s2 = JOptionPane.showInputDialog(null,"s2=");
		System.out.println(s1+s2);

		String s3= s1+s2;
		System.out.println("s3= s1+s2=" +s3);

		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		int i3= i1+i2;
		Integer obj3 = i3; //fait automatiquement new Integer(i3); //BOXING
		int i4 = obj3; //fait automatiquement obj3.intValue(); //UNBOXING
		System.out.println("i4 =" +i4);
		System.out.println("resultat addition="+i3);
		System.out.println("resultat addition="+(i1+i2));
	}

}

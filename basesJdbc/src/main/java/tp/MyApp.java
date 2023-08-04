package tp;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import tp.dao.PersonneDAO;
import tp.dao.PersonneDaoJDB;
import tp.dao.PersonneDaoSimu;
import tp.entity.Personne;


public class MyApp {

	public static void main(String[] args) {
		//testCrud();
		//stConnection();
		//testCrudJDBC();
		//testEnum();
		//testDate();
		testIntrospection();
		testIntrospection2();
	}
	
	public static void testIntrospection2() {
		Personne p1 =  new Personne(null, "dalila","ok"); 
		Class<?> c = p1.getClass();
		Field[] fields = c.getDeclaredFields();
		System.out.println("Liste attributs" );
		for (Field f : fields) {
			f.setAccessible(true);
			System.out.println("\t"+  f.getName()+ " de type = "+ f.getType().getSimpleName() + " de valeur "+ fieldValue);
			try {
				String fieldValue= f.get(p1)==null?null:f.get(p1).toString();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void testIntrospection() {
		try {
			Class<?> c = Class.forName("tp.entity.Personne");
			Field[] fields = c.getDeclaredFields();
			System.out.println("Liste attributs" );
			for (Field f : fields) {
				System.out.println("\t"+  f.getName()+ " de type = "+ f.getType().getSimpleName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testDate() {
		Date date = new Date();
		System.out.println("date= "+date);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String sdate = simpleDateFormat.format(new Date());
		
		System.out.println("MyApp.testDate()" +sdate);
		
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String sdate2 = simpleDateFormat2.format(new Date());
		
		System.out.println("MyApp.testDate()" +sdate2);
		
		
	}
	
	public static  void testEnum() {
		Personne p1 = new Personne(null, "dalila","ok"); 
		/*p1.setNationalite("français");*/
		
		//V2 (de type enum Nationalite);
		p1.setNationalite(Personne.Nationalite.ANGLAIS);
		System.out.println("MyApp.testEnum()" + p1.getNationalite());
	}
	
	public static void testCrudJDBC() {
		PersonneDAO pDAO = new PersonneDaoJDB();
		
		Personne p1 = new Personne(null, "benoit","OKbon");  // id méconnu
		Personne savedP1 = pDAO.createPersonne(p1);
		System.out.println("saveP1= "+ savedP1.toString());
		
		System.out.print("MyApp.testCrudJDBC()" +pDAO.rechercherToutesPersonnes());
		
		List<Personne> personnes = pDAO.rechercherToutesPersonnes();
		System.out.println("personnes  :");
		for (Personne personne : personnes) {
			System.out.println("\t" + personne);
		}
		
	}
	
	public static void testConnection() {
		PersonneDaoJDB pDAO = new PersonneDaoJDB();
		System.out.println("Connexion établie =" + pDAO.etablirConnexion());
		
	}
	
	
	public static void testCrud() {
		//créer quelques personnes
		
		PersonneDAO pDAO = new PersonneDaoSimu();
		
		Personne p1 = new Personne(null, "jean","bon");  // id méconnu
		Personne savedP1 = pDAO.createPersonne(p1);
		System.out.println("saveP1= "+ savedP1.toString());
		
		Personne p2 = new Personne(null, "oloui","joli");  // id méconnu
		Personne savedP2 = pDAO.createPersonne(p2);
		System.out.println("saveP1= "+ savedP2.toString());
	
		p2.setPrenom("lola");
		pDAO.updatePersonne(p2);
		
		Personne pMisAJour= pDAO.rechercherPersonneParId(p2.getId());
		System.out.println("p2MisAJour=" + pMisAJour.toString());;
		
		pDAO.deletePersonne(p2.getId());
		
		List<Personne> personnes = pDAO.rechercherToutesPersonnes();
		System.out.println("personnes");
		for (Personne personne : personnes) {
			System.out.println("\t" +personne);
		}
	}
}

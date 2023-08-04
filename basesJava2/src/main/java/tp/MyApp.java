package tp;

import java.io.IOException;

//import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class MyApp {

	
	public static void main(String[] args) throws IOException {
		//test_calcul();
		//test_calcul2();
		test_ventes();
	}
	
	
	public static void test_ventes( ) throws IOException {
		GestionDeVentes g = new GestionDeVentes();
		//g.lireFichier("Ventes2022.csv");
		g.lireFichier2("Ventes2022.csv");
		g.afficher();
		g.ecrireFichierStats("stats.csv.txt");
		
	}
	
	
	public static void test_calcul2(){
		Calcul calcul = new Calcul();
		double x= Double.parseDouble(JOptionPane.showInputDialog(null,"x="));
		double res = calcul.racineCarre(x);
		System.out.println("MyApp.test_calcul()" +res);
		/*try {
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public static void test_calcul() {
		Calcul calcul = new Calcul();
		try {
		//	double x= -8;
			double x= Double.parseDouble(JOptionPane.showInputDialog(null,"x="));
			double res = calcul.racineCarre(x);
			System.out.println("MyApp.test_calcul()" +res);
			
			
			//tp, déclencher une division de a par b
			
			Integer a =  Integer.parseInt(JOptionPane.showInputDialog(null," a="));
			Integer b = Integer.parseInt(JOptionPane.showInputDialog(null,"b="));
			double result1 = calcul.division(a, b);
			JOptionPane.showMessageDialog(null, result1);
			System.out.println("MyApp.test_calcul()"+ result1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

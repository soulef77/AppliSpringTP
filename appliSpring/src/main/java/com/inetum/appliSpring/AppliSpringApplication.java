package com.inetum.appliSpring;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inetum.appliSpring.tp.Encadreur;
import com.inetum.appliSpring.tp.Prefixeur;
import com.inetum.appliSpring.tp2.GenerateurBlagueDrole;
import com.inetum.appliSpring.tp2.PresentateurBlague;
import com.inetum.appliSpring.tp2.PresentateurBlagueImpl;

public class AppliSpringApplication {

	public static void main(String[] args) {
	//	testEncadreur();
		//testBlagues();
			testDataSource();	
	}
	
	
	
	public static void testDataSource() {
		AnnotationConfigApplicationContext springContext =
				 new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		//DataSource ds = springContext.getBean(DataSource.class);
		DataSource ds = (DataSource) springContext.getBean("myDataSource");
		
		try {
			Connection cn = ds.getConnection();
			System.out.println("connection ouverte= "+ cn.toString());
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		springContext.close();
	}
	
	public static void testBlagues() {
	
		System.setProperty("spring.profiles.active","V1,eventuelProfilComplementaire");
		//System.setProperty("spring.profiles.active","V2,eventuelProfilComplementaire");
		
		AnnotationConfigApplicationContext springContext =
				 new AnnotationConfigApplicationContext(MySpringConfig.class);
		
		PresentateurBlague presentateur1= springContext.getBean(PresentateurBlague.class);
		
		System.out.println("applispring 2 démarrée");
		presentateur1.presenterBlague();
		
		springContext.close();
		
	}
	
	public static void testEncadreur() {
		
		//System.setProperty("spring.profiles.active","V1,eventuelProfilComplementaire");
		System.setProperty("spring.profiles.active","V2,eventuelProfilComplementaire");
		
		AnnotationConfigApplicationContext springContext =
				 new AnnotationConfigApplicationContext(MySpringConfig.class);
		
		Prefixeur prefixeur= springContext.getBean(Prefixeur.class);
		//Prefixeur prefixeur= (Prefixeur) springContext.getBean("prefixeurV1quejaime");
		System.out.println("applispring démarrée");
		System.out.println("chaine prefixee=" + prefixeur.prefixer("lundi"));
		
		Encadreur encadreur= springContext.getBean(Encadreur.class);
		System.out.println("chaine encadreée"+ encadreur.encadrer("bob"));
		
		springContext.close();
	
	}

}

package tp;

import java.util.Scanner;

public class AfficheurInteractifText extends AfficheurText {

	
	public String saisirReponse(String question) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(question);
		return scanner.nextLine();
	}
}

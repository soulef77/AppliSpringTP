package tp;

public class Calcul {
	
	public double racineCarre(double x) throws MyException2 {
		//...
		if(x >= 0)
		return Math.sqrt(x);
		else
			//throw new RuntimeException("racine carrée prévue seulement pour x positif");
			//throw new MyException("racine carrée prévue seulement pour x positif");
			throw new MyException2("racine carrée prévue seulement pour x positif");
	}

	public int division(int a, int b) {
		//...
		if(b==0)
			//throw new IllegalArgumentException("division par zéro interdite");
		throw new MyException2("division par zéro interdite");
		else
			return a/b;
	}
}

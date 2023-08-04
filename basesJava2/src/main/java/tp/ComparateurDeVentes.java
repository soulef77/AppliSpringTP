package tp;

public class ComparateurDeVentes implements java.util.Comparator<Vente> {


	public ComparateurDeVentes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	@Override
	public int compare(Vente o1, Vente o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getCa() - o2.getCa());
				
	}*/
	
	@Override
	public int compare(Vente o1, Vente o2) {
		if(o1 == null || o1.getDomaine() == null)
			return -1;
		
		return o1.getDomaine().compareToIgnoreCase(o2.getDomaine());
	}

}

package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.entity.Personne;

//PersonneDaoSimi= version simulé en mémoire sans réelle base de données
public class PersonneDaoSimu implements PersonneDAO {

	
	private Map<Integer, Personne> mapIdPersonnes= new HashMap<>();
	private Integer idMax=0;
	@Override
	public Personne createPersonne(Personne p) {
		p.setId(idMax++);
		mapIdPersonnes.put(p.getId(), p);
		return p;
	}

	@Override
	public Personne rechercherPersonneParId(Integer idPers) {
		return mapIdPersonnes.get(idPers);
	}

	@Override
	public List<Personne> rechercherToutesPersonnes() {
		return new ArrayList<Personne>( mapIdPersonnes.values());
	}

	@Override
	public void updatePersonne(Personne p) {
		mapIdPersonnes.put(p.getId(), p);
		

	}

	@Override
	public void deletePersonne(Integer idPers) {
		mapIdPersonnes.remove(idPers);

	}

}

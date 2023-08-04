package tp.dao;

import java.util.List;

import tp.entity.Personne;

//en cas de pbs, les méthodes de ce DAO vont remonter des exceptions qui hérite de RunTimeException
public interface PersonneDAO {

public Personne createPersonne(Personne p); //en reotour, la Personne avec id en auto_incrémentée par la base de données
public Personne rechercherPersonneParId(Integer idPers);
public List<Personne> rechercherToutesPersonnes();
public void updatePersonne(Personne p);
public void deletePersonne(Integer idPers);

}

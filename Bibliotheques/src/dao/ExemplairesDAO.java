package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import metier.EnumStatusExemplaire;
import metier.Exemplaire;

public class ExemplairesDAO {
	
	private Exemplaire[] exemplaireDB = {
			new Exemplaire(12, new Date(), EnumStatusExemplaire.PRETE, "1213141516"),
			new Exemplaire(13, new Date(), EnumStatusExemplaire.DISPONIBLE, "1314151617"),
			new Exemplaire(14, new Date(), EnumStatusExemplaire.SUPPRIME, "1415161718"),
			new Exemplaire(15, new Date(), EnumStatusExemplaire.DISPONIBLE, "1516171819")
	};
	
	public Exemplaire findByKey(int id){
		
		for(Exemplaire exemplaire : exemplaireDB){
			if(exemplaire.getIdExemplaire()==id){
				return exemplaire;
			}
		}
		return null;
		
	}
	
	public List<Exemplaire> findExemplairesByStatus(EnumStatusExemplaire statut){
		
		List<Exemplaire> exemplairesTrouves = new ArrayList<Exemplaire>();
		
		for(Exemplaire exemplaire : exemplaireDB){
			if(exemplaire.getStatus().equals(statut)){
				exemplairesTrouves.add(exemplaire);
			}
		}
		
		return exemplairesTrouves;
	}

	public static void main(String[] args) {
		
		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();
		
		System.out.println(exemplairesDAO.findByKey(14));
		
		Iterator<Exemplaire> it;
		
		it = exemplairesDAO.findExemplairesByStatus(EnumStatusExemplaire.DISPONIBLE).iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}

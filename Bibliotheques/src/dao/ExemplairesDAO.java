package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import metier.EnumStatusExemplaire;
import metier.Exemplaire;

public class ExemplairesDAO {

	private Exemplaire[] exemplaireDB = {
			new Exemplaire(12, new GregorianCalendar(2013,0,1).getTime(), EnumStatusExemplaire.PRETE, "1213141516"),
			new Exemplaire(13, new GregorianCalendar(2013,0,1).getTime(), EnumStatusExemplaire.DISPONIBLE, "1314151617"),
			new Exemplaire(14, new GregorianCalendar(2013,10,1).getTime(), EnumStatusExemplaire.SUPPRIME, "1415161718"),
			new Exemplaire(15, new GregorianCalendar(2013,10,1).getTime(), EnumStatusExemplaire.DISPONIBLE, "1516171819"),
			new Exemplaire(16, new GregorianCalendar(2013,9,5).getTime(), EnumStatusExemplaire.DISPONIBLE, "1245841231456"),
			new Exemplaire(17, new GregorianCalendar(2013,9,5).getTime(), EnumStatusExemplaire.DISPONIBLE, "865843245")

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

//	public static void main(String[] args) {
//
//		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();
//
//		System.out.println(exemplairesDAO.findByKey(14));
//
//		Iterator<Exemplaire> it;
//
//		it = exemplairesDAO.findExemplairesByStatus(EnumStatusExemplaire.DISPONIBLE).iterator();
//
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
//
//	}

}

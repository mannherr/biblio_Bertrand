package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class RECETTE1_2_TestAdherentEnRetard {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
		ExemplairesDAO eDao = new ExemplairesDAO () ;
  		UtilisateursDAO uDao= new UtilisateursDAO () ;

  		EmpruntEnCours ep2 = new EmpruntEnCours (uDao.findByKey(19),eDao.findByKey(13), new GregorianCalendar(2016,1,14).getTime());
  		EmpruntEnCours ep3 = new EmpruntEnCours (uDao.findByKey(17),eDao.findByKey(15), new GregorianCalendar(2017,2,06).getTime());


		System.out.println("RECETTE 1.2_TestAdhérentEnRetard");
		System.out.println();
 	 		//recherche d'emprunt en retard
	 			System.out.println("L'Adhérent a-t-il un emprunt en retard ? (oui)");
		 		for (EmpruntEnCours eec : uDao.findByKey(19).getEmpruntEnCours()){
						if (eec.isPretEnRetard())
							System.out.println(eec);
				}

	 		//Enregistrement de nouveaux emprunts pour l'Adhérent :
		 		System.out.println();
		 		System.out.println("L'Adhérent peut-il emprunter un nouveau livre ? (Non)");
	 			EmpruntEnCours ep4 = new EmpruntEnCours (uDao.findByKey(19),eDao.findByKey(13), new GregorianCalendar(2017,2,05).getTime());
	 			System.out.println();

	}

}

package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class RECETTE1_3_TestEmployeEnRetard {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();

		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();

		Utilisateur a1 = utilisateursDAO.findByKey(19);


		UtilisateursDAO uDao= new UtilisateursDAO () ;
		ExemplairesDAO eDao = new ExemplairesDAO () ;


		EmpruntEnCours ep1 = new EmpruntEnCours (uDao.findByKey(17),eDao.findByKey(15), new GregorianCalendar(2016,2,06).getTime());

		System.out.println("RECETTE 1.3_TestEmployéEnRetard");
		System.out.println();
		System.out.println("L'Employé a-t-il un emprunt en retard ? (Oui) :");
		EmpruntEnCours ep2 = new EmpruntEnCours();
 		EmpruntEnCours ep3 = new EmpruntEnCours();

	 	//recherche d'emprunt en retard
	 		for (EmpruntEnCours eec : uDao.findByKey(17).getEmpruntEnCours()){
					if (eec.isPretEnRetard())
						System.out.println(eec);
			}

 		//Enregistrement de nouveaux emprunts pour l'Employé :
	 		System.out.println();
	 		System.out.println("L'Employé peut-il emprunter deux nouveaux livres ?");
			uDao.findByKey(17).addEmpruntEnCours(ep2);
			uDao.findByKey(17).addEmpruntEnCours(ep3);
			System.out.println("Oui et il emprunte deux livres supplémentaires... ");
			//recherche d'emprunt en retard
	 		for (EmpruntEnCours eec : uDao.findByKey(17).getEmpruntEnCours()){
						System.out.println(eec);

	 		}
	}

}

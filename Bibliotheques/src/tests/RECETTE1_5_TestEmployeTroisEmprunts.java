package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class RECETTE1_5_TestEmployeTroisEmprunts {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();
		UtilisateursDAO uDao= new UtilisateursDAO () ;
		ExemplairesDAO eDao = new ExemplairesDAO () ;

		System.out.println("RECETTE 1.5_TestEmployeTroisEmprunts");

		//L'Employé emprunte 3 livres
			System.out.println();
			EmpruntEnCours ep1 = new EmpruntEnCours(uDao.findByKey(21),eDao.findByKey(13),new GregorianCalendar(2017,2,4).getTime());
	 		EmpruntEnCours ep2 = new EmpruntEnCours(uDao.findByKey(21),eDao.findByKey(15),new GregorianCalendar(2017,2,3).getTime());
	 		EmpruntEnCours ep3 = new EmpruntEnCours(uDao.findByKey(21),eDao.findByKey(16),new GregorianCalendar(2017,2,2).getTime());

			System.out.println("L'Employé possède déjà 3 livres : ");
			System.out.println();
			//recherche d'emprunt en retard
			for (EmpruntEnCours eec : uDao.findByKey(21).getEmpruntEnCours()){
			System.out.println(eec);
	 		}
			System.out.println();
			System.out.println();

		System.out.println("L'Employé veut emprunter un 4ème livre...");
		System.out.println();
	 		EmpruntEnCours ep4 = new EmpruntEnCours(uDao.findByKey(21),eDao.findByKey(17),new GregorianCalendar(2017,2,5).getTime());
			System.out.println("C'est possible ! Ses emprunts passent à 4 ci-dessous : ");
			for (EmpruntEnCours eec : uDao.findByKey(21).getEmpruntEnCours()){
				System.out.println(eec);
		 		}
				System.out.println();


	}

}

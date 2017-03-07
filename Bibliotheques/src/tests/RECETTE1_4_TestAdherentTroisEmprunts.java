package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;


public class RECETTE1_4_TestAdherentTroisEmprunts {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();

		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();

		UtilisateursDAO uDao= new UtilisateursDAO () ;
		ExemplairesDAO eDao = new ExemplairesDAO () ;

		System.out.println("RECETTE 1.4_TestAdherentTroisEmprunts");
		//L'Adhérent emprunte 3 livres
			System.out.println();
			EmpruntEnCours ep7 = new EmpruntEnCours();
	 		EmpruntEnCours ep8 = new EmpruntEnCours();
	 		EmpruntEnCours ep9 = new EmpruntEnCours();
	 		uDao.findByKey(20).addEmpruntEnCours(ep7);
			uDao.findByKey(20).addEmpruntEnCours(ep8);
			uDao.findByKey(20).addEmpruntEnCours(ep9);
			System.out.println();

		System.out.println("L'Adhérent possède déjà 3 livres : ");
			//recherche d'emprunt en retard
			for (EmpruntEnCours eec : uDao.findByKey(20).getEmpruntEnCours()){
			System.out.println(eec);
	 		}
			System.out.println();

 		System.out.println("L'Adhérent veut emprunter un 4ème livre...");
	 		EmpruntEnCours ep10= new EmpruntEnCours();
			uDao.findByKey(20).addEmpruntEnCours(ep10);
			System.out.println("Impossible ! ");
			System.out.println();


	}

}

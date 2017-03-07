package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class RECETTE1_6_TestRetour {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
 		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();
 		Utilisateur a1 = utilisateursDAO.findByKey(19);
 		EmpruntEnCours ep1 = new EmpruntEnCours(a1, new GregorianCalendar(2017,2,2).getTime());

		UtilisateursDAO uDao= new UtilisateursDAO () ;
		ExemplairesDAO eDao = new ExemplairesDAO () ;


		System.out.println();
		System.out.println("RECETTE 1.6_TestRetour");
		System.out.println();


			EmpruntEnCours ep26 = new EmpruntEnCours(uDao.findByKey(17),eDao.findByKey(16),(new GregorianCalendar(2017,2,3).getTime()));

			System.out.println("L'employé a emprunté "+uDao.findByKey(17).getEmpruntEnCours().size()+" livre(s)");
			System.out.println(ep26.getEmprunteur());
			System.out.println(ep26.getExemplaire());
			System.out.println();

			System.out.println("L'employé rend le livre...");
			ep26.getExemplaire().retourEmprunt();
			System.out.println("L'employé a maintenant "+uDao.findByKey(17).getEmpruntEnCours().size()+" livre(s)");
			System.out.println(ep26);
			System.out.println(eDao.findByKey(16));
			System.out.println(uDao.findByKey(17));



	}

}

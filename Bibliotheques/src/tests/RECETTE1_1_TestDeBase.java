package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class RECETTE1_1_TestDeBase {

	public static void main(String[] args) throws BiblioException {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();
		Utilisateur a1 = utilisateursDAO.findByKey(19);
		EmpruntEnCours ep1 = new EmpruntEnCours(a1, new GregorianCalendar(2017,2,2).getTime());
		ep1.setExemplaire(exemplairesDAO.findByKey(13));


		System.out.println("RECETTE 1.1_TestDeBase");
		System.out.println();


 		System.out.println("Demande de deux exemplaires par leur ID aux DAO : ");
		ExemplairesDAO eDao = new ExemplairesDAO () ;
  		System.out.println(eDao.findByKey(12));
		System.out.println(eDao.findByKey(15));
		System.out.println();


 		System.out.println("Demande d'un adhérent par son ID aux DAO : ");
  		UtilisateursDAO uDao= new UtilisateursDAO () ;
  		System.out.println(uDao.findByKey(19));
		System.out.println();


 		System.out.println("Demande d'un employé par son ID aux DAO : ");
    	System.out.println(uDao.findByKey(17));
    	System.out.println();


 		System.out.println("Création d'un emprunt en cours pour un adhérent : ");
 		EmpruntEnCours ep2 = new EmpruntEnCours (uDao.findByKey(19),eDao.findByKey(13), new GregorianCalendar(2016,1,14).getTime());
 		System.out.println(ep2);
 		System.out.println();


 		System.out.println("Création d'un emprunt en cours pour un Employé : ");
 		EmpruntEnCours ep3 = new EmpruntEnCours (uDao.findByKey(17),eDao.findByKey(15), new GregorianCalendar(2016,1,25).getTime());
 		System.out.println(ep3);
 		System.out.println();

	}

}

//
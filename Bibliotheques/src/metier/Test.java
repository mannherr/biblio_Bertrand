package metier;



import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;

public class Test {

	/**
	 * @param args
	 * @throws BiblioException
	 */
	public static void main(String[] args) throws BiblioException {


//		Adherent a1 = new Adherent("Martin","Jacques",new GregorianCalendar(1989,11,26).getTime(),"M",12, "Jacques", "motdepasse", "0156564523");
//
//		System.out.println(a1);
//
//		Exemplaire e1 = new Exemplaire(1212, new Date(0), EnumStatusExemplaire.DISPONIBLE, "12121212");
//		Exemplaire e2 = new Exemplaire(2323, new Date(), EnumStatusExemplaire.DISPONIBLE, "23232323");
//		Exemplaire e3 = new Exemplaire();
//		Exemplaire e4 = new Exemplaire();
//
//		GregorianCalendar gc1 = new GregorianCalendar(2017,1,17);
//		GregorianCalendar gc2 = new GregorianCalendar(2017,1,18);
//		GregorianCalendar gc3 = new GregorianCalendar(2017,1,19);
//		GregorianCalendar gc4 = new GregorianCalendar(2017,1,20);
//
//		EmpruntEnCours ep1 = new EmpruntEnCours(gc1.getTime());
//		EmpruntEnCours ep2 = new EmpruntEnCours(gc2.getTime());
//		EmpruntEnCours ep3 = new EmpruntEnCours(gc3.getTime());
//		EmpruntEnCours ep4 = new EmpruntEnCours(gc4.getTime());
//
//		ep1.setExemplaire(e1);
//		ep2.setExemplaire(e2);
//		ep3.setExemplaire(e3);
//		ep4.setExemplaire(e4);
//
//		a1.addEmpruntEnCours(ep1);
//		a1.addEmpruntEnCours(ep2);
//		a1.addEmpruntEnCours(ep3);
//		a1.addEmpruntEnCours(ep4);



//		Utilisateur u1 = new Utilisateur(12, "Jacques", "motdepasse");
//
//		System.out.println(u1);
//
//		Exemplaire e1 = new Exemplaire(1212, new Date(0), EnumStatusExemplaire.DISPONIBLE, "12121212");
//		Exemplaire e2 = new Exemplaire(2323, new Date(), EnumStatusExemplaire.DISPONIBLE, "23232323");
//		Exemplaire e3 = new Exemplaire(2525, new Date(), EnumStatusExemplaire.DISPONIBLE, "34343434");
//		Exemplaire e4 = new Exemplaire(3535, new Date(), EnumStatusExemplaire.DISPONIBLE, "45454545");
//
//		GregorianCalendar gc1 = new GregorianCalendar(2017,1,14);
//		GregorianCalendar gc2 = new GregorianCalendar(2017,1,15);
//		GregorianCalendar gc3 = new GregorianCalendar(2017,1,16);
//		GregorianCalendar gc4 = new GregorianCalendar(2017,1,17);
//
//		EmpruntEnCours ep1 = new EmpruntEnCours(gc1.getTime());
//		EmpruntEnCours ep2 = new EmpruntEnCours(gc2.getTime());
//		EmpruntEnCours ep3 = new EmpruntEnCours(gc3.getTime());
//		EmpruntEnCours ep4 = new EmpruntEnCours(gc4.getTime());
//
//		ep1.setExemplaire(e1);
//		ep2.setExemplaire(e2);
//		ep3.setExemplaire(e3);
//		ep4.setExemplaire(e4);
//
//		u1.addEmpruntEnCours(ep1);
//		u1.addEmpruntEnCours(ep2);
//		u1.addEmpruntEnCours(ep3);
//		u1.addEmpruntEnCours(ep4);
//
//		ep1.setEmprunteur(u1);
//		ep1.setEmprunteur(a1);
//
//		System.out.println(a1.getNbRetards());
//
//		System.out.println(ep1.getEmprunteur());
//
//		for(EmpruntEnCours e : a1.getEmpruntEnCours()){
//			System.out.println(e);
//		}

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();

		ExemplairesDAO exemplairesDAO = new ExemplairesDAO();

		Utilisateur a1 = utilisateursDAO.findByKey(19);

		EmpruntEnCours ep1 = new EmpruntEnCours(a1, new GregorianCalendar(2017,2,2).getTime());

		ep1.setExemplaire(exemplairesDAO.findByKey(13));

		System.out.println(ep1);

//
//		System.out.println(ep1.getEmprunteur());
//
//		for(EmpruntEnCours e : u1.getEmpruntEnCours()){
//			System.out.println(e);
//		}


		System.out.println();
		System.out.println("RECETTE 1.1_TestDeBase");
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


		System.out.println("RECETTE 1.2_TestAdhérentEnRetard");
 	 		//recherche d'emprunt en retard
	 			System.out.println("L'Adhérent a-t-il un emprunt en retard ? (oui...)");
		 		for (EmpruntEnCours eec : uDao.findByKey(19).getEmpruntEnCours()){
						if (eec.isPretEnRetard())
							System.out.println(eec);
				}

	 		//Enregistrement de nouveaux emprunts pour l'Adhérent :
		 		System.out.println("L'Adhérent peut-il emprunter un nouveau livre ? (Non)");
//	 			EmpruntEnCours ep4 = new EmpruntEnCours (uDao.findByKey(19),eDao.findByKey(13), new GregorianCalendar(2016,2,05).getTime());
	 			System.out.println();


 			System.out.println("RECETTE 1.3_TestEmployéEnRetard");
			System.out.println("L'Employé a-t-il un emprunt en retard ? (Oui) :");
			EmpruntEnCours ep5 = new EmpruntEnCours();
	 		EmpruntEnCours ep6 = new EmpruntEnCours();

		 	//recherche d'emprunt en retard
		 		for (EmpruntEnCours eec : uDao.findByKey(17).getEmpruntEnCours()){
						if (eec.isPretEnRetard())
							System.out.println(eec);
				}

	 		//Enregistrement de nouveaux emprunts pour l'Employé :
		 		System.out.println("L'Employé peut-il emprunter deux nouveaux livres ?");
				uDao.findByKey(17).addEmpruntEnCours(ep5);
				uDao.findByKey(17).addEmpruntEnCours(ep6);
				System.out.println("Oui et il emprunte deux livres supplémentaires... ");
				System.out.println();


			System.out.println("RECETTE 1.4_TestAdherentTroisEmprunts");
			//L'Adhérent emprunte 3 livres
				EmpruntEnCours ep7 = new EmpruntEnCours();
		 		EmpruntEnCours ep8 = new EmpruntEnCours();
		 		EmpruntEnCours ep9 = new EmpruntEnCours();
		 		uDao.findByKey(20).addEmpruntEnCours(ep7);
				uDao.findByKey(20).addEmpruntEnCours(ep8);
				uDao.findByKey(20).addEmpruntEnCours(ep9);

	 		System.out.println("L'Adhérent veut emprunter un 4ème livre...");
		 		EmpruntEnCours ep10= new EmpruntEnCours();
		//		uDao.findByKey(20).addEmpruntEnCours(ep10);
				System.out.println("Impossible ! ");
				System.out.println();


			System.out.println("RECETTE 1.5_TestEmployeTroisEmprunts");

			//L'Employé emprunte 3 livres
				EmpruntEnCours ep11 = new EmpruntEnCours();
		 		EmpruntEnCours ep12 = new EmpruntEnCours();
		 		EmpruntEnCours ep13 = new EmpruntEnCours();
	 			uDao.findByKey(21).addEmpruntEnCours(ep11);
				uDao.findByKey(21).addEmpruntEnCours(ep12);
				uDao.findByKey(21).addEmpruntEnCours(ep13);
 			System.out.println("L'Employé veut emprunter un 4ème livre...");
				EmpruntEnCours ep14 = new EmpruntEnCours();
				uDao.findByKey(21).addEmpruntEnCours(ep14);
				System.out.println("C'est possible ! ");





	}

}

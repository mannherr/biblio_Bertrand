package metier;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;

public class Test {

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
		
	}

}

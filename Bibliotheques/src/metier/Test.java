package metier;

import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) throws BiblioException {
		
		Utilisateur u1 = new Utilisateur(12, "Jacques", "motdepasse");
		
		System.out.println(u1);
		
		Exemplaire e1 = new Exemplaire(1212, new Date(0), EnumStatusExemplaire.DISPONIBLE, "12121212");
		Exemplaire e2 = new Exemplaire(2323, new Date(), EnumStatusExemplaire.DISPONIBLE, "23232323");
		Exemplaire e3 = new Exemplaire();
		Exemplaire e4 = new Exemplaire();
		
		GregorianCalendar gc1 = new GregorianCalendar(2017,1,14);
		GregorianCalendar gc2 = new GregorianCalendar(2017,1,15);
		GregorianCalendar gc3 = new GregorianCalendar(2017,1,16);
		GregorianCalendar gc4 = new GregorianCalendar(2017,1,17);
		
		EmpruntEnCours ep1 = new EmpruntEnCours(gc1.getTime());
		EmpruntEnCours ep2 = new EmpruntEnCours(gc2.getTime());
		EmpruntEnCours ep3 = new EmpruntEnCours(gc3.getTime());
		EmpruntEnCours ep4 = new EmpruntEnCours(gc4.getTime());
		
		ep1.setExemplaire(e1);
		ep2.setExemplaire(e2);
		ep3.setExemplaire(e3);
		ep4.setExemplaire(e4);	
		
		u1.addEmpruntEnCours(ep1);
//		u1.addEmpruntEnCours(ep2);
//		u1.addEmpruntEnCours(ep3);
//		u1.addEmpruntEnCours(ep4);
		
//		ep1.setEmprunteur(u1);
//		ep1.setEmprunteur(a1);
		
		System.out.println(ep1.getEmprunteur());
		
		for(EmpruntEnCours e : u1.getEmpruntEnCours()){
			System.out.println(e);
		}
		
	}

}

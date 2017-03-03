package dao;

import java.util.GregorianCalendar;

import metier.Adherent;
import metier.Employe;
import metier.EnumCategorieEmploye;
import metier.Utilisateur;

public class UtilisateursDAO {

	private Utilisateur[] utilisateurDB = {
		new Utilisateur(12, "Jacques", "motdepasse"),
		new Utilisateur(13, "John", "password"),
		new Utilisateur(14, "Juan", "palabra"),
		new Utilisateur(15, "Jon", "glufddd"),
		new Utilisateur(16, "Juan", "pregunta"),
		new Employe("Martin", "Jacques", new GregorianCalendar(1960,5,21).getTime(), "M", 17, "JMartin", "motdePasse", "greqgf1545", EnumCategorieEmploye.BIBLIOTHECAIRE),
		new Adherent("Wayne", "John", new GregorianCalendar(1945,5,18).getTime(), "M", 19, "jwayne", "PassWord", "0448563268"),
		new Adherent("Martin", "David", new GregorianCalendar(1955,8,07).getTime(), "M", 20,"DMartin", "Bambi", "0648563251"),
		new Employe("Kmieciak","Lech", new GregorianCalendar(1985,5,21).getTime(), "M", 21, "LKmieciak", "@tfghp", "greqgf1540", EnumCategorieEmploye.RESPONSABLE),
	};

	public Utilisateur findByKey(int id){

		for(Utilisateur utilisateur : utilisateurDB){
			if(utilisateur.getIdUtilisateur()==id){
				return utilisateur;
			}
		}
		return null;

	}

//	public static void main(String[] args) {
//
//		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
//
//		System.out.println(utilisateursDAO.findByKey(14));
//
//	}

}

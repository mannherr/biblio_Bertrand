package dao;

import metier.Utilisateur;

public class UtilisateursDAO {
	
	private Utilisateur[] utilisateurDB = {
		new Utilisateur(12, "Jacques", "motdepasse"),
		new Utilisateur(13, "John", "password"),
		new Utilisateur(14, "Juan", "palabra"),
		new Utilisateur(15, "Jon", "glufddd"),
		new Utilisateur(16, "Juan", "pregunta")
	};

	public Utilisateur findByKey(int id){
		
		for(Utilisateur utilisateur : utilisateurDB){
			if(utilisateur.getIdUtilisateur()==id){
				return utilisateur;
			}
		}
		return null;
		
	}
	
	public static void main(String[] args) {

		UtilisateursDAO utilisateursDAO = new UtilisateursDAO();
		
		System.out.println(utilisateursDAO.findByKey(14));
		
	}

}

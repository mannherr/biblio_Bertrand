package metier;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Bertrand_Lucas
 * @version 1.3.9
 * Classe qui d�finit l'abstraction d'un utilisateur
 */
public class Utilisateur extends Personne {

// VARIABLES

	/** Variable qui d�finit l'identifiant d'un utilisateur */
	private int idUtilisateur;
	/** Variable qui d�finit le mot de passe d'un utilisateur */
	private String pwd;
	/** Variable qui d�finit le pseudonyme d'un utilisateur */
	private String pseudonyme;
	/** Instance d'une collection qui regroupe les emprunts d'un utilisateur */
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();

// GETTERS SETTERS

	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPseudonyme() {
		return pseudonyme;
	}
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}

	/**
	 * Constructeur par d�faut d'un utilisateur
	 */
	public Utilisateur(){
		this(0, "Pseudonyme inconnu", "Mot de passe inconnu");
	}

	/**
	 * Constructeur d'un utilisateur avec trois param�tres
	 * @param id Identifiant de l'utilisateur
	 * @param pseudo Pseudonyme de l'utilisateur
	 * @param mdp Mot de passe de l'utilisateur
	 */
	public Utilisateur(int id, String pseudo, String mdp){
		this.setIdUtilisateur(id);
		this.setPseudonyme(pseudo);
		this.setPwd(mdp);
	}

	/**
	 * Constructeur d'un utilisateur avec param�tres de la classe Personne h�rit�e
	 * @param nom Nom de l'utilisateur
	 * @param prenom Pr�nom de l'utilisateur
	 * @param dateNaiss Date de naissance de l'utilisateur
	 * @param sexe Sexe de l'utilisateur
	 * @param id Identifiant de l'utilisateur
	 * @param Pseudo Pseudonyme de l'utilisateur
	 * @param mdp Mot de passe de l'utilisateur
	 */
	public Utilisateur(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp){
		super(nom, prenom, dateNaiss, sexe);
		this.setIdUtilisateur(id);
		this.setPseudonyme(Pseudo);
		this.setPwd(mdp);
	}

	/**
	 * M�thode d'ajout d'emprunt dans la collection de l'utilisateur
	 * @param ep Emprunt � ajouter dans la collection de l'utilisateur
	 * @throws BiblioException Exception lev�e si l'utilisateur poss�de d�j� l'emprunt dans sa collection
	 */
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException {
		if(this.getEmpruntEnCours().contains(ep))
			throw new BiblioException("L'utilisateur poss�de d�j� l'exemplaire.");
		else{
			empruntEnCours.add(ep);
			ep.setEmprunteur(this);
		}
	}

	/**
	 * M�thode de calcul du nombre d'emprunt d'un utilisateur
	 * @return Retourne la taille de la collection d'emprunts de l'utilisateur
	 */
	public int getNbEmpruntsEnCours(){
		return empruntEnCours.size();
	}

	@Override
	public String toString() {
		return super.toString() + "Utilisateur [idUtilisateur=" + idUtilisateur + ", pwd=" + pwd + ", pseudonyme=" + pseudonyme
				+ ", empruntEnCours=" + empruntEnCours +"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idUtilisateur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (idUtilisateur != other.idUtilisateur)
			return false;
		return true;
	}

}

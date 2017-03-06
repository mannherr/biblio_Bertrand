package metier;

import java.util.Date;

public class Adherent extends Utilisateur {
	
	/** Variable qui définit le numéro de téléphone d'un utilisateur */
	private String telephone;
	/** Variable statique qui définit le nombre maximal de prêts choisi par le service culturel */
	private static int nbMaxPrets = 3;
	/** Variable statique qui définit la durée maximale d'un emprunt choisie par le service culturel */
	private static int dureeMaxPrets = 15;
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public static int getNbMaxPrets() {
		return nbMaxPrets;
	}
	public static void setNbMaxPrets(int nbMaxPrets) {
		Adherent.nbMaxPrets = nbMaxPrets;
	}
	public static int getDureeMaxPrets() {
		return dureeMaxPrets;
	}
	public static void setDureeMaxPrets(int dureeMaxPrets) {
		Adherent.dureeMaxPrets = dureeMaxPrets;
	}
	
	/**
	 * Constructeur par défaut d'un adhérent
	 */
	public Adherent(){
		this("Téléphone non renseigné");
	}
	
	/**
	 * Constructeur d'un adhérent avec paramètre
	 * @param telephone Numéro de téléphone de l'adhérent
	 */
	public Adherent(String telephone){
		this.setTelephone(telephone);
	}
	
	/**
	 * Constructeur d'un adhérent avec tous les paramètres des classes héritées
	 * @param nom Nom de l'adhérent
	 * @param prenom Prénom de l'adhérent
	 * @param dateNaiss Date de naissance de l'adhérent
	 * @param sexe Sexe de l'adhérent
	 * @param id Identifiant de l'adhérent
	 * @param Pseudo Pseudonyme de l'adhérent
	 * @param mdp Mot de passe de l'adhérent
	 * @param telephone Téléphone de l'adhérent
	 */
	public Adherent(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp, String telephone){
		super(nom, prenom, dateNaiss, sexe, id, Pseudo, mdp);
		this.setTelephone(telephone);
	}
	
	/**
	 * Méthode qui calcule et retourne le nombre de retards d'un adhérent
	 * @return Retourne le nombre de retards
	 */
	public int getNbRetards(){
		int i = 0;
		for(EmpruntEnCours e : getEmpruntEnCours()){
			if(e.isPretEnRetard()){
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Méthode qui définit si les conditions de prêts sont acceptées, en fonction du nombre d'emprunts et du nombre de retards
	 * @return Retourne si les conditions sont acceptées ou non
	 */
	public boolean isConditionsPretAcceptees() {
		if(getNbRetards()==0 && getEmpruntEnCours().size()<getNbMaxPrets()){
			return true;
		}
		else
			return false;
	}
	 
	/**
	 * Méthode qui ajoute un emprunt à la collection d'emprunts de l'adhérent
	 */
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException{
		if(isConditionsPretAcceptees() && !getEmpruntEnCours().contains(ep)){
			getEmpruntEnCours().add(ep);
		}
		else throw new BiblioException("Un emprunt est en retard ou le nombre maximal d'emprunts a été atteint.");
	}
	
	@Override
	public String toString() {
		return super.toString() + "Adherent [telephone=" + telephone + "]";
	}
	
}

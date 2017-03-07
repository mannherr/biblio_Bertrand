package metier;

import java.util.Date;

public class Adherent extends Utilisateur {

	/** Variable qui d�finit le num�ro de t�l�phone d'un utilisateur */
	private String telephone;
	/** Variable statique qui d�finit le nombre maximal de pr�ts choisi par le service culturel */
	private static int nbMaxPrets = 3;
	/** Variable statique qui d�finit la dur�e maximale d'un emprunt choisie par le service culturel */
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
	 * Constructeur par d�faut d'un adh�rent
	 */
	public Adherent(){
		this("T�l�phone non renseign�");
	}

	/**
	 * Constructeur d'un adh�rent avec param�tre
	 * @param telephone Num�ro de t�l�phone de l'adh�rent
	 */
	public Adherent(String telephone){
		this.setTelephone(telephone);
	}

	/**
	 * Constructeur d'un adh�rent avec tous les param�tres des classes h�rit�es
	 * @param nom Nom de l'adh�rent
	 * @param prenom Pr�nom de l'adh�rent
	 * @param dateNaiss Date de naissance de l'adh�rent
	 * @param sexe Sexe de l'adh�rent
	 * @param id Identifiant de l'adh�rent
	 * @param Pseudo Pseudonyme de l'adh�rent
	 * @param mdp Mot de passe de l'adh�rent
	 * @param telephone T�l�phone de l'adh�rent
	 */
	public Adherent(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp, String telephone){
		super(nom, prenom, dateNaiss, sexe, id, Pseudo, mdp);
		this.setTelephone(telephone);
	}

	/**
	 * M�thode qui calcule et retourne le nombre de retards d'un adh�rent
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
	 * M�thode qui d�finit si les conditions de pr�ts sont accept�es, en fonction du nombre d'emprunts et du nombre de retards
	 * @return Retourne si les conditions sont accept�es ou non
	 */
	public boolean isConditionsPretAcceptees() {
		if(getNbRetards()==0 && getEmpruntEnCours().size()<getNbMaxPrets()){
			return true;
		}
		else
			return false;
	}

	/**
	 * M�thode qui ajoute un emprunt � la collection d'emprunts de l'adh�rent
	 */
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException{
		if(isConditionsPretAcceptees() && !getEmpruntEnCours().contains(ep)){
			getEmpruntEnCours().add(ep);
		}
		else throw new BiblioException("Un emprunt est en retard ou le nombre maximal d'emprunts a �t� atteint.");
	}

	//
	@Override
	public String toString() {
		return super.toString() + "Adherent [telephone=" + telephone + "]";
	}

}

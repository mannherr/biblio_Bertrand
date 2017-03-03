package metier;

import java.util.Date;

public class Adherent extends Utilisateur {
	
	private String telephone;
	private static int nbMaxPrets = 3;
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
	
	public Adherent(){
		this("Téléphone non renseigné");
	}
	
	public Adherent(String telephone){
		this.setTelephone(telephone);
	}
	
	public Adherent(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp, String telephone){
		super(nom, prenom, dateNaiss, sexe, id, Pseudo, mdp);
		this.setTelephone(telephone);
	}
	
	public int getNbRetards(){
		int i = 0;
		for(EmpruntEnCours e : getEmpruntEnCours()){
			if(e.isPretEnRetard()){
				i++;
			}
		}
		return i;
	}
	
	public boolean isConditionsPretAcceptees() {
		if(getNbRetards()==0 && getEmpruntEnCours().size()<getNbMaxPrets()){
			return true;
		}
		else
			return false;
	}
	 
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

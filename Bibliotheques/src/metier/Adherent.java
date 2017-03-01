package metier;

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
		this("Téléphone non renseigné", new Utilisateur());
	}
	
	public Adherent(String telephone, Utilisateur utilisateur){
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
		if(getNbEmpruntsEnCours()<getNbMaxPrets() && !getEmpruntEnCours().contains(ep))
			getEmpruntEnCours().add(ep);
		else throw new BiblioException("Nombre d'emprunts maximal atteint.");
	}
	
	@Override
	public String toString() {
		return "Adherent [telephone=" + telephone + "]";
	}
	
}

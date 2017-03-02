package metier;

import java.util.ArrayList;
import java.util.Date;

public class Utilisateur extends Personne {

	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();
	
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
	
	public Utilisateur(){
		this(0, "Pseudonyme inconnu", "Mot de passe inconnu");
	}
	
	public Utilisateur(int id, String pseudo, String mdp){
		this.setIdUtilisateur(id);
		this.setPseudonyme(pseudo);
		this.setPwd(mdp);
	}
	
	public Utilisateur(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp){
		super(nom, prenom, dateNaiss, sexe);
		this.setIdUtilisateur(id);
		this.setPseudonyme(Pseudo);
		this.setPwd(mdp);
	}
	
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException {
		if(this.getEmpruntEnCours().contains(ep))
			throw new BiblioException("L'utilisateur possède déjà l'exemplaire.");
		else{
			empruntEnCours.add(ep);
			ep.setEmprunteur(this);
			ep.getExemplaire().setStatus(EnumStatusExemplaire.PRETE);
		}	
	}
	
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

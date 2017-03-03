package metier;

import java.util.Date;

/**
 * @author Bertrand_Lucas
 * @version 1.3.9
 * Classe décrivant l'abstraction d'une personne
 */
public class Personne {
	
	/** Variable qui définit le nom d'une personne */
	private String nom;
	/** Variable qui définit le prénom d'une la personne */
	private String prenom;
	/** Variable qui définit la date de naissance d'une personne */
	private Date dateNaissance;
	/** Variable qui définit le sexe d'une personne */
	private String sexe;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	/**
	 * Constructeur par défaut d'une personne
	 */
	public Personne(){
		this("Prénom inconnu", "Nom inconnu", new Date(), "Sexe inconnu");
	}
	
	/**
	 * Constructeur d'une personne avec paramètres qui définissent cette personne
	 * @param prenom Prenom de la personne
	 * @param nom Nom de la personne
	 * @param dateNaiss Date de naissance de la personne
	 * @param sexe Sexe de la personne
	 */
	public Personne(String prenom, String nom, Date dateNaiss, String sexe){
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setDateNaissance(dateNaiss);
		this.setSexe(sexe);
	}
			
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
}

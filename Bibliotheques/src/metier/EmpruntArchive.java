package metier;

import java.util.Date;

public class EmpruntArchive {

	/** Variable qui définit la date de restitution effective d'un emprunt */
	private Date dateRestitutionEff;
	/** Variable qui définit la date d'emprunt d'un exemplaire */
	private Date dateEmprunt;
	/** Variable qui définit l'utilisateur concerné par l'emprunt */
	private Utilisateur emprunteur = new Utilisateur();
	/** Variable qui définit l'exemplaire concerné par l'emprunt */
	private Exemplaire exemplaire = new Exemplaire();

	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	/**
	 * Constructeur par défaut d'un emprunt archivé
	 */
	public EmpruntArchive(){
		this(new Utilisateur(), new Exemplaire(), new Date(), new Date(0));
	}

	/**
	 * Constructeur par défaut d'un emprunt archivé
	 * @param utilisateur Utilisateur concerné par l'emprunt à archiver
	 * @param exemplaire Exemplaire concerné par l'emprunt à archiver
	 * @param dateRestitution Date de restitution effective de l'emprunt à archiver
	 * @param dateEmprunt Date d'emprunt de l'emprunt à archiver
	 */
	public EmpruntArchive(Utilisateur utilisateur, Exemplaire exemplaire, Date dateRestitution, Date dateEmprunt){
		this.setEmprunteur(utilisateur);
		this.setExemplaire(exemplaire);
		this.setDateRestitutionEff(dateRestitution);
		this.setDateEmprunt(dateEmprunt);
	}

	public static void main (String [] args){
		
		EmpruntArchive ea = new EmpruntArchive () ;

	}


}
